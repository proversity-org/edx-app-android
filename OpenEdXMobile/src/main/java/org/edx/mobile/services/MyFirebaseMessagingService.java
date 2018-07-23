package org.edx.mobile.services;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import org.edx.mobile.R;
import org.edx.mobile.view.SplashActivity;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

  private static final String TAG = "MyFirebaseMsgService";

  @Override
  public void onMessageReceived(RemoteMessage remoteMessage) {
    String messageText = remoteMessage.getNotification().getBody();

    Notification.Builder mBuilder =
<<<<<<< HEAD
            new Notification.Builder(this)
                    .setSmallIcon(R.mipmap.small_icon)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle(getString(R.string.platform_name))
                    .setContentText(messageText)
                    .setStyle(new Notification.BigTextStyle().bigText(messageText));
=======
      new Notification.Builder(this)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
        .setContentTitle(getString(R.string.platform_name))
        .setContentText(messageText)
        .setStyle(new Notification.BigTextStyle().bigText(messageText));
>>>>>>> f4998e087c12375f588ea32ba0792ef9a1614b69

    Intent resultIntent = new Intent(this, SplashActivity.class);
    TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
    stackBuilder.addParentStack(SplashActivity.class);
    stackBuilder.addNextIntent(resultIntent);
    PendingIntent resultPendingIntent =
            stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

    mBuilder.setContentIntent(resultPendingIntent)
            .setDefaults(Notification.DEFAULT_ALL)
            .setPriority(Notification.PRIORITY_HIGH)
            .setAutoCancel(true);

    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    mNotificationManager.notify(0, mBuilder.build());
  }

  private void handleNow() {
    Log.d(TAG, "Short lived task is done.");
  }
}
