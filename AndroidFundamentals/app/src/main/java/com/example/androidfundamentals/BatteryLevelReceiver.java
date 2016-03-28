package com.example.androidfundamentals;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Osvaldo Villagrana on 3/28/16.
 */
public class BatteryLevelReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if (Intent.ACTION_BATTERY_LOW.equalsIgnoreCase(intentAction)) {
            Toast.makeText(context, "Low battery", Toast.LENGTH_LONG).show();
        } else if (Intent.ACTION_BATTERY_OKAY.equalsIgnoreCase(intentAction)) {
            Toast.makeText(context, "Battery OK", Toast.LENGTH_LONG).show();
        }
    }
}
