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
        ViewHolderStudent holder;

        if (convertView == null) {
            convertView = parent.inflate(context, R.layout.student_item, null);

            holder = new ViewHolderStudent();
            holder.studentName = (TextView) convertView.findViewById(R.id.studentName);
            holder.studentLastname = (TextView) convertView.findViewById(R.id.studentLastname);
            holder.studentCareer = (TextView) convertView.findViewById(R.id.studentCareer);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolderStudent) convertView.getTag();
        }

        Student student = (Student) getItem(position);

        holder.studentName.setText(student.getName());
        holder.studentLastname.setText(student.getLastname());
        holder.studentCareer.setText(student.getCareer());

        return convertView;
    }

    private static class ViewHolderStudent {
        TextView studentName;
        TextView studentLastname;
        TextView studentCareer;
    }
}