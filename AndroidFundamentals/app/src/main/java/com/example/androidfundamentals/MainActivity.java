package com.example.androidfundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText userAgeEditText;
    private Button saveButton;
    private Button showButton;
    private Button listButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseOperations dbo = new DatabaseOperations(getApplicationContext());

        usernameEditText = (EditText) findViewById(R.id.userName);
        userAgeEditText = (EditText) findViewById(R.id.userAge);
        saveButton = (Button) findViewById(R.id.save);
        showButton = (Button) findViewById(R.id.show);
        listButton = (Button) findViewById(R.id.viewList);
        resultTextView = (TextView) findViewById(R.id.result);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbo.addStudent(
                        usernameEditText.getText().toString(),
                        Integer.parseInt(userAgeEditText.getText().toString()));

                usernameEditText.setText("");
                userAgeEditText.setText("");
                Toast.makeText(getApplicationContext(), "Data saved!", Toast.LENGTH_SHORT).show();
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Student> students = dbo.getStudent();
                printResult(students);
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StudentListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void printResult(List<Student> students) {
        StringBuilder result = new StringBuilder("");
        resultTextView.setText("");
        if (students != null) {
            for (Student student : students) {
                result.append(student.getName() + "," + student.getAge() + "|");
            }
            resultTextView.setText(result.substring(0, result.length() - 2));
        } else {
            resultTextView.setText("No data found!");
        }
    }
}
