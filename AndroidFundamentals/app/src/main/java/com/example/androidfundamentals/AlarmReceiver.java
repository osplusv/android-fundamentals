package com.example.androidfundamentals;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Osvaldo Villagrana on 4/3/16.
 */
public class AlarmReceiver extends BroadcastReceiver {
    public static final String ACTION_ALARM = "alarm";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm showing", Toast.LENGTH_SHORT).show();
        System.out.println("From Receiver");
    }
}
