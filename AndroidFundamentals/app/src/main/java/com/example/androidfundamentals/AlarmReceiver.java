package com.example.androidfundamentals;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Osvaldo Villagrana on 4/3/16.
 */
public class AlarmReceiver extends BroadcastReceiver {
    public static final String ACTION_ALARM = "alarm";

    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context, "Alarm showing", Toast.LENGTH_SHORT).show();
        System.out.println("From Receiver");
        notification(context);
    }

    public void notification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Notification Alarm!");
        builder.setContentText("Hi, This is Android Notification Alarm!");

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }
}
