package com.cxjd.nvwabao.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class Disease extends AppCompatActivity {
   // private TextView zhengzhuang,bingyin,yufang,zhiliao;
  //  private TextView zhengzhuangbtn,bingyinbtn,yufangbtn,zhiliaobtn;
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

    }

    private void init() {
        ExpandableTextView ZZexpTv1 = (ExpandableTextView) findViewById(R.id.zhengzhuang)
                .findViewById(R.id.expand_text_view);
        ExpandableTextView BYexpTv2 = (ExpandableTextView) findViewById(R.id.bingyin)
                .findViewById(R.id.expand_text_view);
        ExpandableTextView YFexpTv1 = (ExpandableTextView) findViewById(R.id.yufang)
                .findViewById(R.id.expand_text_view);
        ExpandableTextView ZLexpTv2 = (ExpandableTextView) findViewById(R.id.zhiliao)
                .findViewById(R.id.expand_text_view);

        ZZexpTv1.setText(getString(R.string.dummy_text1));
        BYexpTv2.setText(getString(R.string.dummy_text2));
        YFexpTv1.setText(getString(R.string.dummy_text1));
        ZLexpTv2.setText(getString(R.string.dummy_text2));

    }
}
