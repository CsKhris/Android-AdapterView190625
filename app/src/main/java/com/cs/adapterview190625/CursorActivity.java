package com.cs.adapterview190625;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CursorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor);

        //List View 찾아오기
        ListView listView = (ListView)findViewById(R.id.listview2);

        //Data 찾아오기
        DBHelper dbHelper = new DBHelper(CursorActivity.this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from soccer", null);

        List<Map<String, String>> list = new ArrayList<>();

        while(cursor.moveToNext()){
            Map<String, String> map = new HashMap<>();
            map.put("nation", cursor.getString(1));
            map.put("player", cursor.getString(2));
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(
                CursorActivity.this,
                list,
                android.R.layout.simple_list_item_2,
                new String[]{"nation", "player"},
                new int[]{android.R.id.text1, android.R.id.text2});
        listView.setAdapter(adapter);

        /*
        //Database의 Select 결과를 바로 출력할 수 있는 CursorAdapter 객체 생성
        CursorAdapter adapter = new SimpleCursorAdapter(
                CursorActivity.this,
                android.R.layout.simple_list_item_2,
                cursor,
                new String[]{"nation", "player"},
                new int[]{android.R.id.text1, android.R.id.text2},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(adapter);
        */

    }
}
