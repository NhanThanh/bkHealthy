package com.ttcnpm.bk_healthy.database;

import android.provider.BaseColumns;

/**
 * Created by anh on 5/5/17.
 */

public class RunningContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private RunningContract() {}

    /* Inner class that defines the table contents */
    public static class RunningEntry implements BaseColumns {
        public static final String TABLE_NAME = "runningplan";
        public static final String COLUMN_NAME_1 = "start_point";
        public static final String COLUMN_NAME_2 = "ending_point";
        public static final String COLUMN_NAME_3 = "time_complete";
        public static final String COLUMN_NAME_4 = "running_date";

    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + RunningEntry.TABLE_NAME + " (" +
                    RunningEntry._ID + " INTEGER PRIMARY KEY," +
                    RunningEntry.COLUMN_NAME_1 + " TEXT," +
                    RunningEntry.COLUMN_NAME_2 + " TEXT," +
                    RunningEntry.COLUMN_NAME_3 + " TEXT," +
                    RunningEntry.COLUMN_NAME_4 + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + RunningEntry.TABLE_NAME;
}
