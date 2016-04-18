package com.example.androidfundamentals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Osvaldo Villagrana on 4/18/16.
 */
public class ActivityPreference extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new
                        FragmentPreference())
                .commit();
    }

}
