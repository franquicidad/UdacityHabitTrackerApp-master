package com.example.mac.udacityhabittrackerapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mac.udacityhabittrackerapp.data.Contract;
import com.example.mac.udacityhabittrackerapp.data.HabitDbHelper;
import com.example.mac.udacityhabittrackerapp.data.Contract.habitEntry;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper dbHelper = new HabitDbHelper(this);
        /**
         * Insert Data into the data base
         */
        dbHelper.insertHabit("Study Udacity Databases", "Finally udacitys " +
                        "last lesson in order to graduate from beginners course",
                1, "9:00AM", 4);
        /**
         * Insert More Data
         */
        dbHelper.insertHabit("Study Next U Fragments", "Static Fragments", 2, "2:00PM", 4);

        /**
         * Insert more data
         */
        dbHelper.insertHabit("Study Unity", "Theme Sprites", 3, "8:00PM", 4);

        /** READ PROCESS
         *
         */
        HabitDbHelper mDbHelper=new HabitDbHelper(this);
        Cursor cursor = mDbHelper.read();

        int idColumnIndex = cursor.getColumnIndex(habitEntry._ID);
        int nameColumnIndex = cursor.getColumnIndex(habitEntry.COLUMN_NAME);
        int desColumnIndex = cursor.getColumnIndex(habitEntry.COLUMN_DES);
        int courseColumnIndex = cursor.getColumnIndex(habitEntry.COLUMN_CONTENT_COURSE);
        int hourColumnIndex = cursor.getColumnIndex(habitEntry.COLUMN_HOUR);
        int durationColIndex = cursor.getColumnIndex(habitEntry.COLUMN_DURATION);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(idColumnIndex);
            String name = cursor.getString(nameColumnIndex);
            String description = cursor.getString(desColumnIndex);
            int courseNumber = cursor.getInt(courseColumnIndex);
            String hour = cursor.getString(hourColumnIndex);
            int studyDuration = cursor.getInt(durationColIndex);


            Log.d(TAG, id + "" + name + "" + description + "" + courseNumber + "" + hour + "" + studyDuration);
        }



            cursor.close();

        }







}
