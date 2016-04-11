package com.example.androidfundamentals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osvaldo Villagrana on 4/10/16.
 */
public class DatabaseOperations {
    private DatabaseHelper dbHelper;

    public DatabaseOperations(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public long addStudent(String name, int age) {
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(StudentContract.UserEntry.COLUMN_NAME_STUDENT_NAME, name);
        values.put(StudentContract.UserEntry.COLUMN_NAME_STUDENT_AGE, age);

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                StudentContract.UserEntry.TABLE_NAME,
                null,
                values);

        return newRowId;
    }

    public List<Student> getStudent() {
        List<Student> studentList = null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String[] projection = {
                StudentContract.UserEntry._ID,
                StudentContract.UserEntry.COLUMN_NAME_STUDENT_NAME,
                StudentContract.UserEntry.COLUMN_NAME_STUDENT_AGE
        };

        String sortOrder =
                StudentContract.UserEntry.COLUMN_NAME_STUDENT_NAME + " DESC";

        Cursor c = db.query(
                StudentContract.UserEntry.TABLE_NAME,     // The table to query
                projection,                               // The columns to return
                null,                                     // The columns for the WHERE clause
                null,                                     // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        if (c != null && c.moveToFirst()) {
            Student student;
            studentList = new ArrayList<>();
            do {
                student = new Student();
                student.setId(c.getInt(0));
                student.setName(c.getString(1));
                student.setAge(c.getInt(2));

                studentList.add(student);
            } while (c.moveToNext());
        }

        return studentList;
    }

    public Cursor getStudentCursor() {
        List<Student> studentList = null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String[] projection = {
                StudentContract.UserEntry._ID,
                StudentContract.UserEntry.COLUMN_NAME_STUDENT_NAME,
                StudentContract.UserEntry.COLUMN_NAME_STUDENT_AGE
        };

        String sortOrder =
                StudentContract.UserEntry.COLUMN_NAME_STUDENT_NAME + " DESC";

        Cursor c = db.query(
                StudentContract.UserEntry.TABLE_NAME,     // The table to query
                projection,                               // The columns to return
                null,                                     // The columns for the WHERE clause
                null,                                     // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return c;
    }

    public List<Student> getStudentRaw(String name) {
        List<Student> studentList = null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // SELECT
        String selectQuery = "SELECT  " + StudentContract.UserEntry._ID + ","
                + StudentContract.UserEntry.COLUMN_NAME_STUDENT_NAME + ","
                + StudentContract.UserEntry.COLUMN_NAME_STUDENT_AGE + "  FROM "
                + StudentContract.UserEntry.TABLE_NAME + " WHERE "
                + StudentContract.UserEntry.COLUMN_NAME_STUDENT_NAME + "= '" + name + "' ";

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            studentList = new ArrayList<>();
            do {
                Student s = new Student();
                s.setId(cursor.getInt(0));
                s.setName(cursor.getString(1));
                s.setAge(cursor.getInt(2));

                studentList.add(s);
            } while (cursor.moveToNext());
        }
        try { db.close(); } catch (Exception e) {}
        return studentList;
    }

    public int delete(int id) {
        String selection = StudentContract.UserEntry._ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(id) };

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        int count = db.delete(StudentContract.UserEntry.TABLE_NAME, selection, selectionArgs);
        return count;
    }

    public int update(int id, String name, int age) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(StudentContract.UserEntry.COLUMN_NAME_STUDENT_NAME, name);
        values.put(StudentContract.UserEntry.COLUMN_NAME_STUDENT_AGE, age);

        // Which row to update, based on the ID
        String selection = StudentContract.UserEntry._ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(id) };

        int count = db.update(
                StudentContract.UserEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        return count;
    }
}
