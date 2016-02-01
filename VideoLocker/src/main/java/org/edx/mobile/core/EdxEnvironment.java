package org.proversity.edx.mobile.core;


import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.proversity.edx.mobile.discussion.DiscussionAPI;
import org.proversity.edx.mobile.module.analytics.ISegment;
import org.proversity.edx.mobile.module.db.IDatabase;
import org.proversity.edx.mobile.module.download.IDownloadManager;
import org.proversity.edx.mobile.module.notification.NotificationDelegate;
import org.proversity.edx.mobile.module.prefs.UserPrefs;
import org.proversity.edx.mobile.module.storage.IStorage;
import org.proversity.edx.mobile.services.ServiceManager;
import org.proversity.edx.mobile.util.Config;
import org.proversity.edx.mobile.view.Router;

@Singleton
public class EdxEnvironment implements IEdxEnvironment{

    @Inject
    Context context;

    @Inject
    IDatabase database;

    @Inject
    IStorage storage;

    @Inject
    IDownloadManager downloadManager;

    @Inject
    UserPrefs userPrefs;

    @Inject
    ISegment segment;

    @Inject
    NotificationDelegate notificationDelegate;

    @Inject
    Router router;

    @Inject
    Config config;

    @Inject
    ServiceManager serviceManager;


    @Inject
    DiscussionAPI discussionAPI;

    @Override
    public IDatabase getDatabase() {
        return database;
    }

    @Override
    public IDownloadManager getDownloadManager() {
        return downloadManager;
    }

    @Override
    public UserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public ISegment getSegment() {
        return segment;
    }

    @Override
    public NotificationDelegate getNotificationDelegate() {
        return notificationDelegate;
    }

    @Override
    public Router getRouter() {
        return router;
    }

    @Override
    public Config getConfig() {
        return config;
    }

    @Override
    public IStorage getStorage() {
        return storage;
    }

    @Override
    public ServiceManager getServiceManager() {
        return serviceManager;
    }

    @Override
    public DiscussionAPI getDiscussionAPI(){
        return discussionAPI;
    }

}
