package com.example.androidfundamentals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBox3;
    private String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                message = "Setting 3 ";

                if (b) {
                    message += "on";
                } else {
                    message += "off";
                }
                showMessage(message);
            }
        });
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkbox1:
                message = "Setting 1 ";
                if (checked) {
                    message += "on";
                } else {
                    message += "off";
                }
                break;
            case R.id.checkbox2:
                message = "Setting 2 ";
                if (checked) {
                    message += "on";
                } else {
                    message += "off";
                }
                break;
        }
        showMessage(message);
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
