package com.cxjd.nvwabao.ActivityNews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.NewsTitleBean;

public class DetailActivity extends AppCompatActivity {
    TextView title;
    TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title= (TextView) findViewById(R.id.content_title);
        content= (TextView) findViewById(R.id.content);
        NewsTitleBean titleBeann= (NewsTitleBean) getIntent().getSerializableExtra("content");
        title.setText(titleBeann.getTitleName());
        content.setText(titleBeann.getTitleName());
    }
}
