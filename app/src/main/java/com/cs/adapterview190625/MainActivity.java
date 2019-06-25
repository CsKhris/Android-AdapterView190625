package com.cs.adapterview190625;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //List View에 출력할 Data
    List<Map<String, String>> list = new ArrayList<>();
    //List View 출력을 위한 Adapter
    SimpleAdapter adapter;
    //화면에 출력할 ListView
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView에 출력할 Data 만들기
        Map<String, String> map = new HashMap<>();
        map.put("nation", "Republic of Korea");
        map.put("player", "차범근");
        list.add(map);

        map = new HashMap<>();
        map.put("nation", "Republic of Korea");
        map.put("player", "손흥민");
        list.add(map);

        map = new HashMap<>();
        map.put("nation", "Japan");
        map.put("player", "Nakata");
        list.add(map);

        //Adapter 만들기
        adapter = new SimpleAdapter(
                MainActivity.this,
                list,
                android.R.layout.simple_list_item_2,
                new String[]{"nation", "player"},
                new int[]{android.R.id.text1, android.R.id.text2});

        //ListView를 가져와서 연결하기
        listView = (ListView)findViewById(R.id.listview1);
        listView.setAdapter(adapter);
    }
}
