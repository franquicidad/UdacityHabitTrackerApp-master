package com.example.mac.udacityhabittrackerapp.data;

import android.provider.BaseColumns;

/**
 * Created by mac on 11/09/17.
 */

public class Contract {

    public Contract() {
    }

    public static abstract class habitEntry implements BaseColumns{

        /**
         * TABLE NAME
         */
        public static final String TABLE_NAME="FelipesHabit";
        /**
         * ID
         */
        public static final String _ID=BaseColumns._ID;
        /**
         * Name given to the activity to perform
         */
        public static final String COLUMN_NAME="ActivityName";
        /**
         * Description of the activity that is going to be performed.
         */
        public static final String COLUMN_DES="ActivityDescription";
        /**
         * What type of course is the student is going to study during this time.
         * There are three courses: Udacity for android, Next U for android
         * and Game development in Unity.
         */
        public static final String COLUMN_CONTENT_COURSE="ActivityCourse";
        /**
         * Hour the activity will take place
         */
        public static final String COLUMN_HOUR="ActivityHour";
        /**
         * How much time the activity will last
         */
        public static final String COLUMN_DURATION="ActivityDuration";
        /**
         * Three courses are present so i assign the number to each of them.
         */
        public static final int COURSE_NONE= 0;

        public static final int COURSE_UDACITY=1;

        public static final int COURSE_NEXT_U=2 ;

        public static final int COURSE_UNITY=3;




    }
}
