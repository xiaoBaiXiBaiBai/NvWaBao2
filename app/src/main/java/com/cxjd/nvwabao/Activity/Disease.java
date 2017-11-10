package com.cxjd.nvwabao.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cxjd.nvwabao.R;

public class Disease extends AppCompatActivity {
    private TextView zhengzhuang,bingyin,yufang,zhiliao;
    private TextView zhengzhuangbtn,bingyinbtn,yufangbtn,zhiliaobtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        Button back = (Button) findViewById(R.id.nav_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        init();
    zhengzhuangbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            zhengzhuangbtn.setTextColor(Color.RED);

        }
    });
    }

    private void init() {
        zhengzhuang = (TextView) findViewById(R.id.zhengzhuang);
        bingyin = (TextView) findViewById(R.id.bingyin);
        yufang = (TextView) findViewById(R.id.yufang);
        zhiliao = (TextView) findViewById(R.id.zhiliao);
        zhengzhuangbtn = (TextView) findViewById(R.id.zhengzhuangbtn);
        bingyinbtn = (TextView) findViewById(R.id.bingyinbtn);
        yufangbtn = (TextView) findViewById(R.id.yufangbtn);
        zhiliaobtn = (TextView) findViewById(R.id.zhiliaobtn);
    }
}
