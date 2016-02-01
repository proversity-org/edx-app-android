package org.proversity.edx.mobile.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.proversity.edx.mobile.R;
import org.proversity.edx.mobile.discussion.DiscussionThread;
import org.proversity.edx.mobile.discussion.TopicThreads;
import org.proversity.edx.mobile.task.SearchThreadListTask;
import org.proversity.edx.mobile.util.ResourceUtil;
import org.proversity.edx.mobile.view.adapters.InfiniteScrollUtils;
import org.proversity.edx.mobile.view.common.MessageType;
import org.proversity.edx.mobile.view.common.TaskProcessCallback;

import roboguice.inject.InjectExtra;

public class CourseDiscussionPostsSearchFragment extends CourseDiscussionPostsBaseFragment {

    @InjectExtra(value = Router.EXTRA_SEARCH_QUERY, optional = true)
    private String searchQuery;

    private SearchThreadListTask searchThreadListTask;

    private int nextPage = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discussion_search_posts, container, false);
    }


    @Override
    public void loadNextPage(@NonNull final InfiniteScrollUtils.PageLoadCallback<DiscussionThread> callback) {
        ((TaskProcessCallback) getActivity()).onMessage(MessageType.EMPTY, "");
        if (searchThreadListTask != null) {
            searchThreadListTask.cancel(true);
        }
        searchThreadListTask = new SearchThreadListTask(getActivity(), courseData.getCourse().getId(), searchQuery, nextPage) {
            @Override
            public void onSuccess(TopicThreads topicThreads) {
                ++nextPage;
                boolean hasMore = topicThreads.next != null && topicThreads.next.length() > 0;
                callback.onPageLoaded(topicThreads.getResults(), hasMore);
                if (discussionPostsAdapter.getCount() == 0) {
                    Activity activity = getActivity();
                    if (activity instanceof TaskProcessCallback) {
                        String escapedTitle = TextUtils.htmlEncode(searchQuery);
                        String resultsText = ResourceUtil.getFormattedString(
                                getContext().getResources(),
                                R.string.forum_no_results_for_search_query,
                                "search_query",
                                escapedTitle
                        ).toString();
                        // CharSequence styledResults = Html.fromHtml(resultsText);
                        ((TaskProcessCallback) activity).onMessage(MessageType.ERROR, resultsText);
                    }
                }
            }

            @Override
            public void onException(Exception ex) {
                logger.error(ex);
                //  hideProgress();

            }
        };
        searchThreadListTask.setProgressCallback(null);
        searchThreadListTask.execute();

    }
}
