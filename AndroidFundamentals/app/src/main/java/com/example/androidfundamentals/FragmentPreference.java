package com.example.androidfundamentals;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

/**
 * Created by Osvaldo Villagrana on 4/18/16.
 */
public class FragmentPreference extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    protected ListPreference listAlarmFrequence;
    protected CheckBoxPreference checkBoxPreference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
        checkBoxPreference = (CheckBoxPreference)
                findPreference("settingsTask");
        listAlarmFrequence = (ListPreference)
                findPreference("settingsAlarm");

        SharedPreferences sp =
                PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean check = sp.getBoolean("settingsTask", false);
        if(check)
            checkBoxPreference.setSummary("Ascending");
        else
            checkBoxPreference.setSummary("Descending");

        String value = sp.getString("settingsAlarm", "0");
        if(!value.equalsIgnoreCase("0")){
            value += " minutes";
        }else{
            value = "Never";
        }
        listAlarmFrequence.setSummary(value);

    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().
                registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().
                unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("settingsTask")){
            Preference exercisesPref = findPreference(key);
            boolean value = sharedPreferences.getBoolean(key, false);
            if(value)
                exercisesPref.setSummary("Ascending");
            else
                exercisesPref.setSummary("Descending");
        }else if(key.equals("settingsAlarm")){
            String value = sharedPreferences.getString(key, "0");
            if(!value.equalsIgnoreCase("0")){
                value += " minutes";
            }else{
                value = "Never";
            }
            listAlarmFrequence.setSummary(value);
        }

    }
}
