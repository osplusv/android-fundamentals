package com.example.androidfundamentals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FireMissilesDialogFragment dialog = new FireMissilesDialogFragment();
                dialog.show(getSupportFragmentManager(), "dialog");
            }
        });
    }

    public void neutralButton() {
        Toast.makeText(getApplicationContext(), "Neutral", Toast.LENGTH_SHORT).show();
    }
}
