package com.example.androidfundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStartService(View V)
    {
        //start the service from here //MyService is your service class name
        startService(new Intent(this, MyService.class));
    }
    //Stop the started service
    public void onClickStopService(View V)
    {
        //Stop the running service from here
        //MyService is your service class name
        //Service will only stop if it is already running.
        stopService(new Intent(this, MyService.class));
    }
}
