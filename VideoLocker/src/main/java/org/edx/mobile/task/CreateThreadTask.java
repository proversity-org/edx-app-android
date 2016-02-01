package org.proversity.edx.mobile.task;

import android.content.Context;

import org.proversity.edx.mobile.discussion.DiscussionThread;
import org.proversity.edx.mobile.discussion.ThreadBody;

public abstract class CreateThreadTask extends
Task<DiscussionThread> {

    ThreadBody thread;

    public CreateThreadTask(Context context, ThreadBody thread) {
        super(context);
        this.thread = thread;
    }



    public DiscussionThread call( ) throws Exception{
        try {

            if(thread!=null){

                return environment.getDiscussionAPI().createThread(thread);
            }
        } catch (Exception ex) {
            handle(ex);
            logger.error(ex, true);
        }
        return null;
    }
}
