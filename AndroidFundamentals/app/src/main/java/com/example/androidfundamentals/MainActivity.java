package com.example.androidfundamentals;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    List<Map<String, String>> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.studentListView);

        initDataset();

        String[] from = { "name", "score" };
        int[] widgetIds = {android.R.id.text1, android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), studentList, android.R.layout.simple_list_item_2, from, widgetIds) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView1 = (TextView) view.findViewById(android.R.id.text1);
                textView1.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black));

                TextView textView2 = (TextView) view.findViewById(android.R.id.text2);
                textView2.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black));
                return view;
            }
        };

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item " + position + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDataset() {
        studentList = new ArrayList<>();

        Map<String, String> student = new HashMap<>();
        student.put("name", "Student 1");
        student.put("score", "72");
        studentList.add(student);

        Map<String, String> student2 = new HashMap<>();
        student2.put("name", "Student 2");
        student2.put("score", "80");
        studentList.add(student2);

        Map<String, String> student3 = new HashMap<>();
        student3.put("name", "Student 3");
        student3.put("score", "97");
        studentList.add(student3);

        Map<String, String> student4 = new HashMap<>();
        student4.put("name", "Student 4");
        student4.put("score", "100");
        studentList.add(student4);
    }
}
