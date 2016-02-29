package com.example.androidfundamentals;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        final EditText editText = (EditText) findViewById(R.id.phone);

        Button button2 = (Button) findViewById(R.id.button2);
        final EditText editText1 = (EditText) findViewById(R.id.url);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String phone = editText.getText().toString().trim();
                if (!TextUtils.isEmpty(phone)) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                    //intent.setData(Uri.parse("tel:" + phone));
                    startActivity(intent);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String url = editText1.getText().toString().trim();
                if (!TextUtils.isEmpty(url)) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                    PackageManager pm = getPackageManager();
                    ComponentName cn = intent.resolveActivity(pm);

                    if (cn == null) {
                        Uri marketUri = Uri.parse("market://search?q=browser");
                        Intent marketIntent = new Intent(Intent.ACTION_VIEW).setData(marketUri);

                        if (marketIntent.resolveActivity(pm) != null) {
                            startActivity(marketIntent);
                        } else {
                            Log.v(TAG, "Market client not available.");
                        }
                    } else {
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
