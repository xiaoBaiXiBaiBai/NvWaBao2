package com.cxjd.nvwabao.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.cxjd.nvwabao.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 李超 on 2017/12/14.
 */

public class Physical extends AppCompatActivity {

    //竖直尺子
    private ScrollView ruler0;
    private TextView user_height_value;
    private LinearLayout rulerlayout0;
    private int height = 0;


    //体重尺子
    private HorizontalScrollView ruler;
    private LinearLayout rulerlayout, all_layout;
    private TextView user_birth_value;
    private int beginYear;
    private float weight;

    private String birthYear = "60";
    private long time = 0;
    private  int screenWidth;
    private boolean isFirst = true;

    //BMI指数
    private float bmi;

    //人体图片
    private ImageView imageView ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_physical);
        initView();
        imageView = findViewById(R.id.user);
        user_birth_value = findViewById(R.id.user_birth_value);
        user_birth_value.setText("160");
        ruler = findViewById(R.id.birthruler);
        rulerlayout = findViewById(R.id.ruler_layout);
        ruler.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction();
                weight = beginYear +  (int)Math.ceil((ruler.getScrollX())/20);
                user_birth_value.setText(String.valueOf(weight));
                initImage();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                weight = beginYear  +  (int)Math.ceil((ruler.getScrollX())/20);
                                user_birth_value.setText(String.valueOf(weight ));
                                initImage();
                                birthYear = String.valueOf((int)(beginYear +  Math.ceil((ruler.getScrollX())/20) ));
                                try {
                                    time = (new SimpleDateFormat("yyyy").parse(String.valueOf(birthYear))).getTime();
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        },1000);
                        break;
                }
                return false;
            }
        });
    }

    private void initImage() {
        bmi = weight/(float) (( height* 0.01)*(height* 0.01));
        if (bmi<18.5){
            imageView.setImageResource(R.drawable.physical_boy_jishou);
        }else if (bmi <= 23.9){
            imageView.setImageResource(R.drawable.physical_boy_zhengchang);
        }else if (bmi <= 27.9){
            imageView.setImageResource(R.drawable.physical_boy_pianpang);
        }else if(bmi >= 28) {
            imageView.setImageResource(R.drawable.physical_boy_jipang);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (isFirst){
            screenWidth = ruler.getWidth();
            constructRuler2();
            isFirst = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                scroll();
            }
        },1000);
    }

    private void scroll() {
        ruler.smoothScrollTo((0  -beginYear) * 20,0);
    }

    @SuppressWarnings("deprecation")
    private void constructRuler2() {
        int year = new Date().getYear();
        year = 300;
        beginYear = 0 ;
        View leftview = LayoutInflater.from(this).inflate(R.layout.blankhrulerunit,null);
        leftview.setLayoutParams(new LinearLayout.LayoutParams(screenWidth / 2, LinearLayout.LayoutParams.MATCH_PARENT));
        rulerlayout.addView(leftview);
        for(int i = 0; i < 16; i++){
            View view = (View) LayoutInflater.from(this).inflate(R.layout.hrulerunit,null);
            view.setLayoutParams(new LinearLayout.LayoutParams(200, LinearLayout.LayoutParams.MATCH_PARENT));
            TextView tv = view.findViewById(R.id.hrulerunit);
            tv.setText(String.valueOf(beginYear + i * 10));
            rulerlayout.addView(view);
        }
        View rightview = (View)LayoutInflater.from(this).inflate(R.layout.blankhrulerunit,null);
        rightview.setLayoutParams(new LinearLayout.LayoutParams(screenWidth / 2, LinearLayout.LayoutParams.MATCH_PARENT));
        rulerlayout.addView(rightview);
    }

    private void initView() {
        user_height_value = findViewById(R.id. user_height_value);
        user_height_value.setText("身高是： " +  height + "CM");
        initImage();
        ruler0 = findViewById(R.id.vruler);
        ruler0.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction();
                height = (int) Math.ceil((ruler0.getScrollY()) / 10);
                user_height_value.setText("身高是: "
                        + String.valueOf(height)
                        + " CM");
                initImage();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:

                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        new Handler().postDelayed(new Runnable(){                        @Override
                        public void run() {
                            height = (int) Math.ceil((ruler0
                                    .getScrollY()) / 10);
                            user_height_value.setText("身高是: "
                                    + String.valueOf(height) + " CM");
                            initImage();
                        }
                        }, 1000);
                        break;
                }

                return false;
            }
        });
        rulerlayout0 = findViewById(R.id.vruler_layout);
        new Handler().postDelayed((new Runnable() {
            @Override
            public void run() {
                constructRuler();
            }
        }),300);
    }

    private void constructRuler() {
        int rulerHeight = ruler0.getHeight();

        View topview = (View) LayoutInflater.from(this).inflate(
                R.layout.blankvrulerunit, null);
        topview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                rulerHeight / 2));
        rulerlayout0.addView(topview);
        for (int i = 0; i < 25; i++) {
            View view = (View) LayoutInflater.from(this).inflate(
                    R.layout.vrulerunit, null);
            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,                    100));
            TextView tv = (TextView) view.findViewById(R.id.vrulerunit);
            tv.setText(String.valueOf(i * 10));
            rulerlayout0.addView(view);
        }
        View bottomview = (View) LayoutInflater.from(this).inflate(
                R.layout.blankvrulerunit, null);
        bottomview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                rulerHeight / 2));
        rulerlayout0.addView(bottomview);

    }
}
