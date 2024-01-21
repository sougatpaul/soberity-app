package com.example.myapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAccess {

    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase db;
    private static  DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.sqLiteOpenHelper = new MyDatabase(context);
    }


    public static  DatabaseAccess getInstance(Context context){
        if (instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db =  sqLiteOpenHelper.getWritableDatabase();

    }


    public void close(){
        if (this.db != null) {
            this.db.close();
        }
    }

    public ArrayList<String> getHospitals(String district){
        c = db.rawQuery("select name from Rehabs where districts like '%"+district+"'",new String[]{});
//        StringBuffer buffer = new StringBuffer();
        ArrayList<String> hospitals = new ArrayList<>();
        while (c.moveToNext()){
            hospitals.add(c.getString(0));
        }
//        System.out.println(hospitals);
        return hospitals;
    }

    public ArrayList<String> getPhone(String district){
        c = db.rawQuery("select contacts from Rehabs where name like '%"+district+"'",new String[]{});
        ArrayList<String> hospNum = new ArrayList<>();
        while (c.moveToNext()){
            hospNum.add(c.getString(0));
        }
        return hospNum;
    }

    public  ArrayList<String> getAddress(String District){
        c = db.rawQuery("select Adress from Rehabs where name like '%"+District+"'",new String[]{});
        ArrayList<String> addr = new ArrayList<>();
        while (c.moveToNext()){
            addr.add(c.getString(0));
        }
        return addr;
    }


    }


