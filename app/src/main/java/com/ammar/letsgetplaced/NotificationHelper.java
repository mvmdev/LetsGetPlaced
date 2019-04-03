package com.ammar.letsgetplaced;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class NotificationHelper {
    public static void displayNotification(Context context, String title, String message){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context,Home.Channel_id)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_MAX);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(1,mBuilder.build());
    }
}
