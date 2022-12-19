package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
//Create a new java class DBhelper for Database functions
public class Dbhelper extends SQLiteOpenHelper {
    public static final String DBNAME = "login.db";
    public Dbhelper(Context context) {super(context, "login.db", null, 1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users (inputUsername TEXT primary key,inputPassword TEXT)");
        db.execSQL("create table shoes (id INTEGER PRIMARY KEY,name TEXT ,description TEXT,price DOUBLE)");}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldeVersion, int newVersion) {
        db.execSQL("drop table if exists users ");}// insert data functions
    public Boolean insertData(String inputUsername, String inputPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", inputUsername);
        values.put("password", inputPassword);
        long result = db.insert("users", null, values);
        if (result == -1) return false;
        else
            return true;}
        //CheckUsername function
    public  Boolean checkusername(String inputUsername) {SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where inputUsername=?", new String[]{inputUsername});
        if (cursor.getCount() > 0) return true;else return false;}
    ////CheckPassword function
    public  Boolean checkPassword(String inputUsername ,String inputPassword) {SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where inputUsername=? and inputPassword=? ", new String[]{inputUsername,inputPassword});
        if (cursor.getCount() > 0) return true;
        else return false;}}