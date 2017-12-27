package com.cxjd.nvwabao.Activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.Tab;

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

    //bmi数值
    private TextView bmi_value;

    //网格布局
    GridLayout gridLayout01 ;
    GridLayout gridLayout02 ;

    //fat表格
    String[] fat = {"分类","男性","女性","正常范围","10%~20%","18%~28%"};
    //臀围表格
    String[] tunWei = {"分类","男性","女性","正常范围","0.75~0.85","0.70~0.80","腹部肥胖",">0.90",">0.85"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_physical);
        initView();

        gridLayout01 = findViewById(R.id.physical_gridlayout01);
        gridLayout02 = findViewById(R.id.physical_gridlayout02);

        //设置TabHost组件
        final TabHost tabHost = findViewById(R.id.physical_tabhost);
        //初始化TabHost容器
        tabHost.setup();

        //创建第一个Tab页面
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1").setIndicator("体制指数").setContent(R.id.tab_01);
        //添加第一个标签页
        tabHost.addTab(tab1);
        //创建第二个Tab页面
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2").setIndicator("脂肪比例").setContent(R.id.tab_02);
        //添加第二个Tab页面
        tabHost.addTab(tab2);
        //创建第三个Tab页面
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3").setIndicator("腰臀围比").setContent(R.id.tab_03);
        //添加第三个Tab页面
        tabHost.addTab(tab3);

        //表格的初始化
        initGridLayout();

        //选择监听
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                for(int i = 0; i < tabHost.getTabWidget().getChildCount(); i++){
                    //获得当选中的选项卡对象
                    View view = tabHost.getTabWidget().getChildAt(i);
                    TextView tv = view.findViewById(android.R.id.title);
                    //选中
                    if(tabHost.getCurrentTab() == i){
                        tv.setTextSize(18);
                        //设置字体和风格
                        tv.setTypeface(Typeface.SANS_SERIF,5);
                        tv.setTextColor(getResources().getColor(R.color.colorPrimary));
                    }else {
                        //不选中
                        tv.setTextSize(15);
                        //设置字体和风格
                        tv.setTypeface(Typeface.DEFAULT);
                        tv.setTextColor(getResources().getColor(R.color.black));
                    }
                }
            }
        });

        imageView = findViewById(R.id.user);
        bmi_value = findViewById(R.id.bmi_value);
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
                bmi_value.setText(String.format("%.1f",bmi));
                initImage();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                weight = beginYear  +  (int)Math.ceil((ruler.getScrollX())/20);
                                user_birth_value.setText(String.valueOf(weight ));
                                bmi_value.setText(String.format("%.1f",bmi));
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

    private void initGridLayout() {
        for(int i = 0; i < fat.length; i++){
            TextView textView = new TextView(this);
            if(i==0||i==1||i==2){
                textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                textView.setTypeface(Typeface.SANS_SERIF,5);
            }
            textView.setBackground(getResources().getDrawable(R.drawable.textview_fourandfive_background));
            //居中显示
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(65,35,65,35);
            textView.setText(fat[i]);
            //指定该组件所在的行
            GridLayout.Spec rowSpec = GridLayout.spec(i/3);
            //指定该组件所在的列
            GridLayout.Spec columnSpec = GridLayout.spec(i%3);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,columnSpec);
            //指定该组件占满父容器
            params.setGravity(Gravity.FILL);
            gridLayout01.addView(textView, params);
        }

        for(int i = 0; i < tunWei.length; i++){
            TextView textView = new TextView(this);
            if(i==0||i==1||i==2){
                textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                textView.setTypeface(Typeface.SANS_SERIF,5);
            }
            textView.setText(tunWei[i]);
            textView.setBackground(getResources().getDrawable(R.drawable.textview_fourandfive_background));
            //居中显示
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(65,35,65,35);
            //指定该组件所在的行
            GridLayout.Spec rowSpec = GridLayout.spec(i/3);
            //指定该组件所在的列
            GridLayout.Spec columnSpec = GridLayout.spec(i%3);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,columnSpec);
            //指定该组件占满父容器
            params.setGravity(Gravity.FILL);
            gridLayout02.addView(textView, params);
        }
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
        new android.os.Handler().postDelayed(new Runnable() {
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
                bmi_value.setText(String.format("%.1f",bmi));
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
                            bmi_value.setText(String.format("%.1f",bmi));
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