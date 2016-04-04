package com.example.androidfundamentals;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private String ALARM_ACTION = AlarmReceiver.ACTION_ALARM;

    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);

        Intent intentToFire = new Intent(MainActivity.this, AlarmReceiver.class);
        alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intentToFire, 0);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                Calendar calendar = new GregorianCalendar(datePicker.getYear(),
//                        datePicker.getMonth(),
//                        datePicker.getDayOfMonth(),
//                        timePicker.getCurrentHour(),
//                        timePicker.getCurrentMinute());

                Calendar calendar = Calendar.getInstance();
//                calendar.set(Calendar.HOUR, 12); // At the hour you wanna fire
//                calendar.set(Calendar.MINUTE, 16); // Particular minute
//                calendar.set(Calendar.SECOND, 0);

                //Toast.makeText(getApplicationContext(), Double.toString(calendar.getTimeInMillis()), Toast.LENGTH_SHORT).show();

                int alarmType = AlarmManager.RTC_WAKEUP;
                alarmManager.setRepeating(alarmType, calendar.getTimeInMillis(), 30*1000, alarmIntent);
            }
        });
    }
}
