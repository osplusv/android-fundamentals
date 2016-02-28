package com.example.androidfundamentals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.studentListView);
        initDataset();
        StudentAdapter adapter = new StudentAdapter(getApplicationContext(), studentList);
        listView.setAdapter(adapter);
    }

    private void initDataset() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Student 1 name", "Student 1 lastname", "Student career 1"));
        studentList.add(new Student("Student 2 name", "Student 2 lastname", "Student career 2"));
        studentList.add(new Student("Student 3 name", "Student 3 lastname", "Student career 3"));
        studentList.add(new Student("Student 4 name", "Student 4 lastname", "Student career 4"));
        studentList.add(new Student("Student 5 name", "Student 5 lastname", "Student career 5"));
        studentList.add(new Student("Student 6 name", "Student 6 lastname", "Student career 6"));
        studentList.add(new Student("Student 7 name", "Student 7 lastname", "Student career 7"));
        studentList.add(new Student("Student 8 name", "Student 8 lastname", "Student career 8"));
        studentList.add(new Student("Student 9 name", "Student 9 lastname", "Student career 9"));
        studentList.add(new Student("Student 10 name", "Student 10 lastname", "Student career 10"));
        studentList.add(new Student("Student 11 name", "Student 11 lastname", "Student career 11"));
        studentList.add(new Student("Student 12 name", "Student 12 lastname", "Student career 12"));
        studentList.add(new Student("Student 13 name", "Student 13 lastname", "Student career 13"));
        studentList.add(new Student("Student 14 name", "Student 14 lastname", "Student career 14"));
        studentList.add(new Student("Student 15 name", "Student 15 lastname", "Student career 15"));

    }
}
