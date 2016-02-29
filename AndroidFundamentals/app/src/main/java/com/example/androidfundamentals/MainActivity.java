package com.example.androidfundamentals;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int SHOW_SUBACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddInfoActivity.class);
                startActivityForResult(intent, SHOW_SUBACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SHOW_SUBACTIVITY:
                if (resultCode == Activity.RESULT_OK) {
                    String message = data.getStringExtra(AddInfoActivity.MESSAGE);
                    showMessage("Thanks, you've entered correctly all data: " + message);
                } else {
                    showMessage("Sorry, you haven't entered all data");
                }
                break;
        }
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
