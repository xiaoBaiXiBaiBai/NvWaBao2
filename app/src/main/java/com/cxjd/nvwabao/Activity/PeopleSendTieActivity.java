package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.PeopleSpecialAdapter;
import com.cxjd.nvwabao.bean.PeopleChat;
import com.cxjd.nvwabao.bean.User;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 白 on 2018/3/28.
 * 在动态页面进行发帖
 */

public class PeopleSendTieActivity extends AppCompatActivity implements View.OnClickListener {
    private int peopleId;
    private String username;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1_say);

        TextView send_text = (TextView) findViewById(R.id.send_text);
        initDate();
        send_text.setOnClickListener(this);

    }



    // peopleId 实际上默认为 帖子主键  同一个用户可以有多个 帖子peopleId
    private void initDate() {
        List<User> users= DataSupport.findAll(User.class);
        username=users.get(0).getmName();
        Log.i("i", "用户名 "+username);

        List<PeopleChat> peopleChatList = null;
        try {
            peopleChatList = DataSupport.where("peopleName = ?",username).find(PeopleChat.class);
            int id  = peopleChatList.get(peopleChatList.size() - 1).getPeopleId();
            peopleId = id + 1;
        } catch (Exception e) {
            peopleId = 100;
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.send_text:

                EditText editText = (EditText) findViewById(R.id.say_text);
                String chat = editText.getText().toString().trim();

                if (TextUtils.isEmpty(chat)) {
                    Toast.makeText(this, "不可为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (chat.equals("aeisall")) {
                        forever();
                    }
                    PeopleChat peopleChat = new PeopleChat();
                    peopleChat.setPeopleId(peopleId);
                    peopleChat.setName(username);
                    peopleChat.setChat(chat);
                    peopleChat.setImageId(R.drawable.a1_people);
                    peopleChat.setInfo("这个人很懒，什么也没写 ԾㅂԾ");
                    peopleChat.setAddress("哈尔滨市");
                    peopleChat.save();

                    Toast.makeText(this, "发帖成功！", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }

    private void forever() {
        Intent intent = new Intent(this, PeopleSpecialAdapter.class);
        startActivity(intent);
    }
}
