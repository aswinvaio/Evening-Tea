package com.example.aswin.eveningtea;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aswin on 29-Jul-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "EveningTeaDB.db";
    public static final String TABLE_ITEMS = "ITEMS";
    public static final String ITEMS_COL_ItemId = "ItemId";
    public static final String ITEMS_COL_Name = "Name";
    public static final String ITEMS_COL_UnitPrice = "UnitPrice";
    public static final String ITEMS_COL_IsHidden = "IsHidden";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_ITEMS+" ("+ITEMS_COL_ItemId+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ITEMS_COL_Name+" TEXT NOT NULL, "+ITEMS_COL_UnitPrice+" INT NOT NULL, "+ITEMS_COL_IsHidden+" INT NOT NULL);");
        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_ITEMS+" ("+ITEMS_COL_Name+", "+ITEMS_COL_UnitPrice+", "+ITEMS_COL_IsHidden+") VALUES ('Coffee', 10, 0),('Tea', 8, 0),('Black Tea', 5, 0),('Boost', 10, 0),('Horlicks', 10, 0),('Cake', 10, 0),('Puffs', 12, 0),('Vada', 8, 0),('Ada', 7, 0),('Pazham', 10, 0),('Biscut', 5, 0),('Sweet Roll', 10, 0),('Madal', 10, 0),('Bun', 5, 0),('Brown Bun', 10, 0),('Lime', 10, 0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_ITEMS);
        onCreate(sqLiteDatabase);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_ITEMS, null);
        return res;
    }
}
