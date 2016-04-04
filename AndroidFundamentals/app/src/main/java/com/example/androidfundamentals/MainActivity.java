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

    private DatePicker datePicker;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        Intent intentToFire = new Intent(MainActivity.this, AlarmReceiver.class);
        intentToFire.setAction("com.example.androidfundamentals.ACTION_ALARM");
        alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmIntent = PendingIntent.getBroadcast(MainActivity.this, 1, intentToFire, 0);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setAlarm();
//                Calendar calendar = new GregorianCalendar(datePicker.getYear(),
//                        datePicker.getMonth(),
//                        datePicker.getDayOfMonth(),
//                        timePicker.getCurrentHour(),
//                        timePicker.getCurrentMinute());
//
//                calendar.add(Calendar.HOUR, -5);

                //Calendar calendar = Calendar.getInstance();
//                calendar.set(Calendar.HOUR, 12); // At the hour you wanna fire
//                calendar.set(Calendar.MINUTE, 16); // Particular minute
//                calendar.set(Calendar.SECOND, 0);

                //Toast.makeText(getApplicationContext(), Double.toString(calendar.getTimeInMillis()), Toast.LENGTH_SHORT).show();
//                System.out.println(calendar.getTimeInMillis());
//
//                int alarmType = AlarmManager.RTC_WAKEUP;
//                alarmManager.setInexactRepeating(alarmType, calendar.getTimeInMillis(), 60*1000, alarmIntent);
            }
        });
    }

    private void setAlarm() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.YEAR, datePicker.getYear());
        calendar.set(Calendar.MONTH, datePicker.getDayOfMonth());
        calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour()); // At the hour you wanna fire
        calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute()); // Particular minute
        calendar.set(Calendar.SECOND, 0);

        System.out.println(timePicker.getCurrentHour());
        System.out.println(timePicker.getCurrentMinute());
        System.out.println(calendar.getTimeInMillis());

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 60 * 1000, alarmIntent);
    }
}
