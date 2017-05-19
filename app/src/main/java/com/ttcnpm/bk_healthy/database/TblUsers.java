package com.ttcnpm.bk_healthy.database;

/**
 * Created by nhan on 24/04/2017.
 */

public class TblUsers {
    public static final String USER_ID  = "user_id";
    public static final String USERNAME  = "user_name";
    public static final String FIRST_NAME  = "first_name";
    public static final String LAST_NAME  = "last_name";
    public static final String PASSWORD  = "password";

    /** The Constant TABLE_NAME. */
    public static final String TABLE_NAME = "users";

    /** The Constant TABLE_CREATE. */
    public static final String TABLE_CREATE = "create table if not exists " + TABLE_NAME + "("
            //+ ID + " integer PRIMARY KEY AUTOINCREMENT, "
            + USER_ID + " text, "
            + USERNAME + " text, "
            + FIRST_NAME + " text, "
            + PASSWORD + " text, "
            + LAST_NAME + " text "
            + ")";

    /** The Constant TABLE_DROP. */
    public static final String TABLE_DROP = "Drop table if exists " + TABLE_NAME;
}
