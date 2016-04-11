package com.example.androidfundamentals;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Osvaldo Villagrana on 4/11/16.
 */
public class StudentAdapter extends CursorAdapter {
    public StudentAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_student, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView studentNameTextView = (TextView) view.findViewById(R.id.studentName);
        TextView studentAgeTextView = (TextView) view.findViewById(R.id.studentAge);

        String studentname = cursor.getString(1);
        int age = cursor.getInt(2);

        studentNameTextView.setText(studentname);
        studentAgeTextView.setText(Integer.toString(age));
    }
}
