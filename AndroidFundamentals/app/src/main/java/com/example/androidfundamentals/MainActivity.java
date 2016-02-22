package com.example.androidfundamentals;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private boolean isFragmentVisible = false;
    private  MyFragment2 mf2 = new MyFragment2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonMessage = "";
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (isFragmentVisible) {
                    fragmentTransaction.remove(mf2);
                    buttonMessage = "Show fragment!";
                } else {
                    fragmentTransaction.add(R.id.fragment_container, mf2);
                    buttonMessage = "Hide fragment!";
                }
                button.setText(buttonMessage);
                fragmentTransaction.commit();
                isFragmentVisible = !isFragmentVisible;
            }
        });
    }
}
