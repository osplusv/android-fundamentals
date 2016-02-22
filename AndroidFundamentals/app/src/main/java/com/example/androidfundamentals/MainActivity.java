package com.example.androidfundamentals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String message = "";
    private RadioGroup genreRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genreRadioGroup = (RadioGroup) findViewById(R.id.genreRadioGroup);
        genreRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioFemale:
                        message = "Female!";
                        break;

                    case R.id.radioMale:
                        message = "Male!";
                        break;
                }
                showMessage(message);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        if (!checked) {
            return;
        }

        switch (view.getId()) {
            case R.id.radioYes:
                message = "Yes :)";
                break;

            case R.id.radioMaybe:
                message = "Maybe :/";
                break;

            case R.id.radioNo:
                message = "No :(";
                break;
        }
        showMessage(message);
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
