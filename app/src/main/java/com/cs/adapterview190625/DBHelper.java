package com.cs.adapterview190625;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    //생성자
    public DBHelper(Context context){
        super(context, "soccer.db", null, 1);
    }

    //Database를 처름 사용할 때 호출되는 Method
    //Table을 생성하고 처음부터 존재해야 하는 Data를 생성
    public void onCreate(SQLiteDatabase db){
        //Table을 만드는 구문
        String tableSQL = "create table soccer(" + "_id integer primary key autoincrement," + "nation text, player text)";
        db.execSQL(tableSQL);
        db.execSQL("insert into soccer(nation, player) " + "values('Republic of Korea', '차범근')");
        db.execSQL("insert into soccer(nation, player) " + "values('Republic of Korea', '박지성')");
        db.execSQL("insert into soccer(nation, player) " + "values('Republic of Korea', '손흥민')");
    }

    //Database Version이 변경된 경우, 호출되는 Method
    //기존의 Data를 삭제하고 Data를 다시 생성하는 Code 작성
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table soccer");
        onCreate(db);
    }
}
