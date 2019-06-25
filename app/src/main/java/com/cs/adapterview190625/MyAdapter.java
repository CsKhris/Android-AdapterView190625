package com.cs.adapterview190625;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    //View를 전개하기 위하여 필요한 Context
    Context context;

    //전개할 View(Layout)의 id
    int layout;

    //출력할 Data
    List<VO> data;

    //생성자에서 위의 3개를 주입
    public MyAdapter(Context context, int layout, List<VO>data){
        this.context = context;
        this.layout = layout;
        this.data = data;
    }

    @Override
    //Table의 행의 개수를 설정하는 Method
    public int getCount(){
        return  data.size();
    }

    @Override
    //행의 문자열을 설정하는 Method
    public Object getItem(int position){
        return data.get(position).name;
    }

    @Override
    //행의 ID를 설정하는 Method
    public long getItemId(int position){
        return position;
    }

    @Override
    //항목 View를 만들어주는 Method
    //position은 View가 출력되는 Index
    //convertView는 앞에 사용한 View
    //parent는 항목 View가 놓이게 될 ListView
    public View getView(int position, View convertView, ViewGroup parant){
        //XML로 만든 View를 전개하기 위한 객체 생성
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //재사용할 View가 없으면 생성 합니다.
        if(convertView == null){
            convertView = inflater.inflate(layout, parant, false);
        }
        //위치에 따라 배경색을 다르게 지정
        if(position % 2 == 0)
            convertView.setBackgroundColor(Color.RED);
        else
            convertView.setBackgroundColor(Color.BLUE);

        //Layout File에 Design한 Image View 가져오기
        ImageView imageView = (ImageView)convertView.findViewById(R.id.img);
        //Image 출력
        imageView.setImageResource(data.get(position).icon);

        //Text View에 Text 출력하기
        TextView textView = (TextView)convertView.findViewById(R.id.text);
        textView.setText(data.get(position).name);

        //Button
        //Button의 Event 처리를 익명객체로 하는 경우,
        //익명객체는 자신이 포함된 Method의 지역변수를 사용할 수 없으므로 final로 변환하여 사용 합니다.
        final int pos = position;
        Button btn = (Button)convertView.findViewById(R.id.btn);
        btn.setOnClickListener(view->{
            //Log.e("Event", "Button Click");
            VO vo = data.get(position);
            Toast.makeText(context, vo.name, Toast.LENGTH_LONG).show();
        });

        return convertView;
    }
}
