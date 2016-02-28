package com.example.androidfundamentals;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Osvaldo Villagrana on 2/27/16.
 */
public class StudentAdapter extends BaseAdapter {
    private Context context;
    private List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = parent.inflate(context, R.layout.student_item, null);
        }

        Student student = (Student) getItem(position);

        TextView studentName = (TextView) convertView.findViewById(R.id.studentName);
        studentName.setText(student.getName());

        TextView studentLastname = (TextView) convertView.findViewById(R.id.studentLastname);
        studentLastname.setText(student.getLastname());

        TextView studentCareer = (TextView) convertView.findViewById(R.id.studentCareer);
        studentCareer.setText(student.getCareer());
        return convertView;
    }
}