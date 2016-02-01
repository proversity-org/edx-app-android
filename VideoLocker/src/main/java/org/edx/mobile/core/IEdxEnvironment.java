package org.proversity.edx.mobile.core;


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

/**
 * TODO - we should decompose this class into environment setting and service provider settings.
 */
public interface IEdxEnvironment {

    IDatabase getDatabase();

    IStorage getStorage();

    IDownloadManager getDownloadManager();

    UserPrefs getUserPrefs();

    ISegment getSegment();

    NotificationDelegate getNotificationDelegate();

    Router getRouter();

    Config getConfig();

    ServiceManager getServiceManager();

    //TODO - it should be part of ServiceManager
    DiscussionAPI getDiscussionAPI();
}
