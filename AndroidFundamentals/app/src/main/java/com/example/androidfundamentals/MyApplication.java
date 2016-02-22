package com.example.androidfundamentals;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

/**
 * Created by Osvaldo Villagrana on 2/22/16.
 */
public class MyApplication extends Application {
    private static MyApplication singleton;
    private static String TAG = MyApplication.class.getName();

    public static MyApplication getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        Log.v(TAG, "onCreate from Application");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.v(TAG, "onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.v(TAG, "onTrimMemory");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.v(TAG, "onConfigurationChanged");
    }
}
