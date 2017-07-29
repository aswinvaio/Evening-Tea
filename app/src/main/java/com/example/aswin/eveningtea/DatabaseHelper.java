package com.example.aswin.eveningtea;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aswin on 29-Jul-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "EveningTeaDB.db";
    public static final String TABLE_ITEMS = "ITEMS";
    public static final String ITEMS_COL_1 = "ItemId";
    public static final String ITEMS_COL_2 = "Name";
    public static final String ITEMS_COL_3 = "UnitPrice";
    public static final String ITEMS_COL_4 = "IsHidden";
    public static final String ITEMS_COL_5 = "";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_ITEMS+" (ItemID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, UinitPrice ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
