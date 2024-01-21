package com.example.myapp;

//import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DataBase_saver extends SQLiteOpenHelper {

    public SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase DB;
    private static  DataBase_saver instance;

    public DataBase_saver(Context context) {

        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(Id INTEGER primary key autoincrement, Gender TEXT, Type_of_alcohol TEXT, Quantity INTEGER, TS LONG, ethonol_content double);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata(String Gender, String Type_of_alcohol, int Quantity, Long TS ,double ethonol_content)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Gender",Gender);
        contentValues.put("Type_of_alcohol", Type_of_alcohol);
        contentValues.put("Quantity", Quantity);
        contentValues.put("TS", TS);
        contentValues.put("ethonol_content",ethonol_content);
        long result=DB.insert("Userdetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean insertdistrict(String districts, String name, String Adress, String Contacts,String extra)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("districts",districts);
        contentValues.put("name", name);
        contentValues.put("Adress", Adress);
        contentValues.put("Contacts", Contacts);
        contentValues.put("extra",extra);
        long result=DB.insert("Rehabs", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    /*public Boolean updateuserdata(String name, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where id = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}*/


    /*public Boolean deletedata (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }*/

    public void retrievedata(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("select * from Userdetails", null, null);
        /*while(cursor.moveToNext()){
            Log.e(TAG,"timestamp is:" + cursor.getString(4)+" ethanol content is:"+cursor.getString(5));
        }*/
        cursor.close();
    }
    public ArrayList<Double> average_ethonol(){
        ArrayList<Double> avg = new ArrayList<Double>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("select ethonol_content from Userdetails", null, null);
       /* for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            avg.add(cursor.getDouble(0));
        }
        cursor.close();*/
        try {
            while (cursor.moveToNext()) {
                avg.add(cursor.getDouble(0));
            }
        } finally {
            cursor.close();
        }
        return avg;
    }
    /*public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }*/

    public ArrayList<Long> queryXData(){
        ArrayList<Long> yNewData = new ArrayList<Long>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT ts FROM Userdetails";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            yNewData.add(cursor.getLong(4));
        }
        cursor.close();
        return yNewData;
    }

    public ArrayList<Double> queryYData(){
        ArrayList<Double> xNewData = new ArrayList<Double>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT ethonol_content FROM Userdetails";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            xNewData.add(cursor.getDouble(5));
        }
        cursor.close();
        return xNewData;
    }


}