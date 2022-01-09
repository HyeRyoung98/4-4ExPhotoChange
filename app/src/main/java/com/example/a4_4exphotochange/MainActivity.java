package com.example.a4_4exphotochange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Switch Swi;
    private RadioGroup rg;
    private ImageView img;
    private Button btnExit, btnReset;
    private LinearLayout LLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Swi = findViewById(R.id.Swi);

        rg = findViewById(R.id.rg);


        img = findViewById(R.id.img);
        btnExit = findViewById(R.id.exit);
        btnReset = findViewById(R.id.reset);

        LLayout = findViewById(R.id.LLayout);

        Swi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    rg.setVisibility(View.VISIBLE);
                    LLayout.setVisibility(View.VISIBLE);
                } else{
                  rg.setVisibility(View.INVISIBLE);
                  LLayout.setVisibility(View.INVISIBLE);
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.rbOreo:
                            img.setImageResource(R.drawable.oreo);
                        break;
                    case R.id.rbPie:
                        img.setImageResource(R.drawable.pie);
                        break;
                    case R.id.rbQ:
                        img.setImageResource(R.drawable.q);
                        break;
                    default:
                        img.setImageResource(R.drawable.ic_launcher_foreground);
                        

                }
            }
        });

        btnExit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                moveTaskToBack(true); // 태스크를 백그라운드로 이동
                finishAndRemoveTask(); // 액티비티 종료 + 태스크 리스트에서 지우기
                System.exit(0);
                return false;
            }
        });

        btnReset.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                rg.clearCheck();
                Swi.setChecked(false);
                return false;
            }
        });



    }
}