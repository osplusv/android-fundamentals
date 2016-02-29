package com.example.androidfundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Osvaldo Villagrana on 2/28/16.
 */
public class AddInfoActivity extends AppCompatActivity {
    public final static String MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_info_activity);

        final TextView name = (TextView) findViewById(R.id.name);
        final TextView lastname = (TextView) findViewById(R.id.lastname);

        Button enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString().trim();
                String lastnameStr = lastname.getText().toString().trim();

                if (TextUtils.isEmpty(nameStr) && TextUtils.isEmpty(lastnameStr)) {
                    setResult(RESULT_CANCELED);
                    finish();
                }

                Intent intent = new Intent();
                intent.putExtra(MESSAGE, nameStr + " " + lastnameStr);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
