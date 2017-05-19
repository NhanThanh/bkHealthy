package com.ttcnpm.bk_healthy.database;

/**
 * Created by nhan on 24/04/2017.
 */

public class TblFoods {
    public static final String FOOD_ID  = "user_id";
    public static final String NAME  = "name";
    public static final String FOOD_TYPE  = "food_type";
    public static final String CALORIES  = "calories";
    public static final String DESCRIPTION  = "description";

    /** The Constant TABLE_NAME. */
    public static final String TABLE_NAME = "foods";

    /** The Constant TABLE_CREATE. */
    public static final String TABLE_CREATE = "create table if not exists " + TABLE_NAME + "("
            //+ ID + " integer PRIMARY KEY AUTOINCREMENT, "
            + FOOD_ID + " text, "
            + NAME + " text, "
            + FOOD_TYPE + " text, "
            + CALORIES + " text, "
            + DESCRIPTION + " text "
            + ")";

    /** The Constant TABLE_DROP. */
    public static final String TABLE_DROP = "Drop table if exists " + TABLE_NAME;
}
