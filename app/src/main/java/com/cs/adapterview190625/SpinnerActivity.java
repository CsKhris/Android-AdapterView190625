package com.cs.adapterview190625;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {

    String [] ar;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    TextView nation;

    //시작할 때 Event가 발생한 것인지 확인하기 위한 변수
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        //Spinner 출력
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setPrompt("가고 싶은 나라를 선택하세요.");

        adapter = ArrayAdapter.createFromResource(SpinnerActivity.this, R.array.nations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //arrays.xml에 만든 배열을 가져오기
        ar = getResources().getStringArray(R.array.nations);

        //Spinner에서 선택을 했을 때 Event 처리
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            //선택하였을 때 호출되는 Method
            public void  onItemSelected(
                    AdapterView parent, View view,
                    int position, long id){
                if(flag == false){
                    flag = true;
                    return;
                }
                Toast.makeText(SpinnerActivity.this, ar[position], Toast.LENGTH_LONG).show();

                nation = (TextView)findViewById(R.id.nation);
                nation.setText(ar[position]);
            }
            @Override
            public void onNothingSelected(AdapterView parent){
            }
        });

        final ProgressBar lect = (ProgressBar)findViewById(R.id.progressbar);
        final ProgressBar indicator = (ProgressBar)findViewById(R.id.indicator);

        Button strbtn = (Button)findViewById(R.id.strbtn);
        Button stpbtn = (Button)findViewById(R.id.stpbtn);

        strbtn.setOnClickListener(view -> {
            lect.setProgress(75);
            lect.setSecondaryProgress(99);
            indicator.setVisibility(View.VISIBLE);
        });

        stpbtn.setOnClickListener(view -> {
            indicator.setVisibility(View.GONE);
        });
    }
}
