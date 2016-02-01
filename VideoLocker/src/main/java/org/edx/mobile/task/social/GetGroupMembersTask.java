package org.proversity.edx.mobile.task.social;

import android.content.Context;

import org.proversity.edx.mobile.services.ServiceManager;
import org.proversity.edx.mobile.social.SocialMember;
import org.proversity.edx.mobile.task.Task;

import java.util.List;

/**
 * Created by marcashman on 2014-12-18.
 */
public abstract class GetGroupMembersTask extends Task<List<SocialMember>> {

    private long groupId;

    public GetGroupMembersTask(Context context, long groupId) {
        super(context);
        this.groupId = groupId;
    }

    @Override
    public List<SocialMember> call( ) {
        ServiceManager api = environment.getServiceManager();
        try {
            return api.getGroupMembers(false, groupId);
        } catch (Exception e) {
            logger.error(e);
            onException(e);
        }
        return null;
    }
}
