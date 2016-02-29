package com.example.androidfundamentals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.student_item, R.id.studentName, studentList);

        // Simple Android layout
        //ArrayAdapter<Student> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, studentList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item clicked " + position, Toast.LENGTH_SHORT).show();
            }
        });
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
