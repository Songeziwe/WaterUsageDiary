package com.example.andriod.waterusagediary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public  static final String DB_NAME = "Data.db";
    public static final String TABLE_NAME = "Entries_table";
    public static final String ID = "ID";
    public static final String Name1 = "Name1";
    public static final String Total1 = "Total1";
    public static final String Name2 = "Name2";
    public static final String Total2 = "Total2";
    public static final String Name3 = "Name3";
    public static final String Total3 = "Total3";
    public static final String Name4 = "Name4";
    public static final String Total4 = "Total4";
    public static final String Name5 = "Name5";
    public static final String Total5 = "Total5";
    public static final String Name6 = "Name6";
    public static final String Total6 = "Total6";
    public static final String Name7 = "Name7";
    public static final String Total7 = "Total7";
    public static final String Name8 = "Name8";
    public static final String Total8 = "Total8";
    public static final String Name9 = "Name9";
    public static final String Total9 = "Total9";
    public static final String Total = "Total";
    public static final String Date = "Date";

    // when this constructor is called the databases will be created
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    // create a table when this method is called
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME  + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name1 TEXT, Total1 TEXT," +
                "Name2 TEXT, Total2 TEXT,Name3 TEXT, Total3 TEXT, Name4 TEXT, Total4 TEXT,Name5 TEXT, Total5 TEXT, " +
                "Name6 TEXT, Total6 TEXT,Name7 TEXT, Total7 TEXT, Name8 TEXT, Total8 TEXT,Name9 TEXT, Total9 TEXT,Total TEXT, Date TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db);
    }

    public boolean insert_Entery(String name1, String total1,String name2, String total2,String name3, String total3,String name4, String total4
            ,String name5, String total5,String name6, String total6,String name7, String total7,String name8, String total8,String name9, String total9
            ,String total, String date){

        SQLiteDatabase db = this.getWritableDatabase(); // create database and table

        ContentValues contentValues = new ContentValues();
        contentValues.put(Name1, name1);contentValues.put(Total1, total1);
        contentValues.put(Name2, name2);contentValues.put(Total2, total2);
        contentValues.put(Name3, name3);contentValues.put(Total3, total3);
        contentValues.put(Name4, name4);contentValues.put(Total4, total4);
        contentValues.put(Name5, name5);contentValues.put(Total5, total5);
        contentValues.put(Name6, name6);contentValues.put(Total6, total6);
        contentValues.put(Name7, name7);contentValues.put(Total7, total7);
        contentValues.put(Name8, name8);contentValues.put(Total8, total8);
        contentValues.put(Name9, name9);contentValues.put(Total9, total9);
        contentValues.put(Total, total);
        contentValues.put(Date, date);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)return false;
        else return true;
    }

    public Cursor getData(){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        return db.rawQuery(query,null);
    }
    public long numRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        long rows = DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return rows;
    }
}
