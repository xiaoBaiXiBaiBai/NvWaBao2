package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.PeopleChat;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 白 on 2018/3/27.
 * 圈子动态的 个人信息界面
 */

public class PeopleInfoActivity extends AppCompatActivity {

    private int peopleId;
    private PeopleChat peopleChat;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1_activity_people_info);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        peopleId = bundle.getInt("id");

        Log.i("i", "获取的id为 +++++++++" + peopleId);

        initData();

        initview();

    }

    private void initview() {
        TextView infoNam = (TextView) findViewById(R.id.people_info_name);
        infoNam.setText(peopleChat.getName());
        TextView infoInfo = (TextView) findViewById(R.id.people_info_info);
        ImageView imageView = (ImageView) findViewById(R.id.head_image);
        imageView.setImageResource(peopleChat.getImageId());
        infoInfo.setText(peopleChat.getInfo());
    }

    private void initData() {
        List<PeopleChat> peopleChatList = DataSupport.where("PeopleId = ?", peopleId + "").find(PeopleChat.class);
        peopleChat = peopleChatList.get(0);
        Log.i("i", "initData: 获取的信息为"+peopleChat);
    }


}
