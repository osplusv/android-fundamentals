package com.example.androidfundamentals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Hold a button reference
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting button reference by ID from ActivityMain.xml
        button2 = (Button) findViewById(R.id.button2);

        // Dynamically creating a event listener for a button reference
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast(getString(R.string.message2));
            }
        });
    }

    public void onClickFromLayout(View view) {
        showToast(getString(R.string.message1));
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
