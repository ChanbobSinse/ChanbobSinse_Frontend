package com.oechyeochangmen.chanbapsinse;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

/**
 * Created by eka on 2017. 7. 19..
 */

public class NotificationService extends IntentService {

    public NotificationService() {
        super("");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.layout_notification);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        remoteViews.setImageViewResource(R.layout.layout_notification,R.drawable.bg_splash);
        remoteViews.setTextViewText(R.id.notification_title,"찬밥신세");
        remoteViews.setTextViewText(R.id.notification_content,"식사는 맛있게 하셨나요?\n음식점의 별점을 기록해주시는 것은 어떨까요?");
        Notification notification = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("찬밥신세")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContent(remoteViews)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .build();
        manager.notify(1, notification);


    }
}
