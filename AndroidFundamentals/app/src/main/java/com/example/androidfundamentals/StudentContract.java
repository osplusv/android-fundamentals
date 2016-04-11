package com.example.androidfundamentals;

import android.provider.BaseColumns;

/**
 * Created by Osvaldo Villagrana on 4/10/16.
 */
public final class StudentContract {

    public StudentContract() {
    }

    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_STUDENT_NAME = "name";
        public static final String COLUMN_NAME_STUDENT_AGE = "age";
    }
}
