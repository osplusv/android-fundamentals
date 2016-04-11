package com.example.androidfundamentals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by Osvaldo Villagrana on 4/11/16.
 */
public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final DatabaseOperations dbo = new DatabaseOperations(getApplicationContext());

        ListView listview = (ListView) findViewById(R.id.studentList);

        StudentAdapter studentAdapter = new StudentAdapter(this, dbo.getStudentCursor(), false);
        listview.setAdapter(studentAdapter);
    }
}
