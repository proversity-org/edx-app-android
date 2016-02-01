package org.proversity.edx.mobile.view.view_holders;

import android.view.View;
import android.widget.TextView;

import org.proversity.edx.mobile.R;
import org.proversity.edx.mobile.discussion.DiscussionTextUtils;
import org.proversity.edx.mobile.discussion.IAuthorData;

public class AuthorLayoutViewHolder {

    public final TextView discussionAuthorTextView;

    public AuthorLayoutViewHolder(View itemView) {
        discussionAuthorTextView = (TextView) itemView.
                findViewById(R.id.discussion_author_layout_author_text_view);
    }
}
