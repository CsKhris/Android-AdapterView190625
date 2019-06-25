package com.cs.adapterview190625;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        //ListView에 출력할 Data 생성
        List<VO> list = new ArrayList<>();

        VO vo = new VO();
        vo.icon = R.drawable.ic_launcher_foreground;
        vo.name = "Apple";
        list.add(vo);

        vo = new VO();
        vo.icon = R.drawable.ic_launcher_background;
        vo.name = "Google";
        list.add(vo);

        MyAdapter adapter = new MyAdapter(
                CustomListViewActivity.this,
                R.layout.icontext, list);

        ListView listView = (ListView)findViewById(R.id.customlistview);
        listView.setAdapter(adapter);

        //여러개의 Animation을 적용하기 위한 객체 생성
        AnimationSet set = new AnimationSet(true);

        //위치 이동 Animation
        Animation action = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f
        );
        action.setDuration(1700);
        //Animation 집합에 추가
        set.addAnimation(action);

        //Alpha Animation
        Animation alpha = new AlphaAnimation(0.0f, 1.0f);
        alpha.setDuration(1700);
        //Animation 집합에 추가
        set.addAnimation(alpha);

        //Layout Animation 객체 생성
        LayoutAnimationController controller = new LayoutAnimationController(set);
        listView.setLayoutAnimation(controller);




    }
}
