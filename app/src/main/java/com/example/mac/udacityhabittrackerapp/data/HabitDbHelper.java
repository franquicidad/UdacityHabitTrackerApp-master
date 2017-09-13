package com.example.mac.udacityhabittrackerapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.ViewAnimationUtils;

import com.example.mac.udacityhabittrackerapp.data.Contract.habitEntry;

/**
 * Created by mac on 11/09/17.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "habitTracker.db";
    public static final int DATABASE_VERSION = 1;
    private static final String LOG_TAG = HabitDbHelper.class.getSimpleName();

    private SQLiteDatabase db;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_HABIT_TABLE = " CREATE TABLE " + habitEntry.TABLE_NAME + " (" +
                habitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                habitEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                habitEntry.COLUMN_DES + " TEXT NOT NULL, " +
                habitEntry.COLUMN_CONTENT_COURSE + " INTEGER NOT NULL DEFAULT 0, " +
                habitEntry.COLUMN_HOUR + " TEXT NOT NULL DEFAULT NONE, " +
                habitEntry.COLUMN_DURATION + " INTEGER NOT NULL DEFAULT 0); ";
        sqLiteDatabase.execSQL(CREATE_HABIT_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertHabit(String name, String descrip, int course, String hour, int duration) {

        SQLiteDatabase writableDB = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(habitEntry.COLUMN_NAME, name);
        values.put(habitEntry.COLUMN_DES, descrip);
        values.put(habitEntry.COLUMN_CONTENT_COURSE, course);
        values.put(habitEntry.COLUMN_HOUR, hour);
        values.put(habitEntry.COLUMN_DURATION, duration);

        long result = writableDB.insert(habitEntry.TABLE_NAME, null, values);
        if (result != -1) {
            Log.v(LOG_TAG, "Insert Row complete" + result);
        } else {
            Log.v(LOG_TAG, "Insert row unsuccesfull");
        }

    }

    public Cursor read() {

        String[] projection = {
                habitEntry._ID,
                habitEntry.COLUMN_NAME,
                habitEntry.COLUMN_DES,
                habitEntry.COLUMN_CONTENT_COURSE,
                habitEntry.COLUMN_HOUR,
                habitEntry.COLUMN_DURATION
        };
        return db.query(habitEntry.TABLE_NAME, projection, null, null, null, null, null);
    }
}
