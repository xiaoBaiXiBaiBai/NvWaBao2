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
import com.cxjd.nvwabao.bean.PeopleReturn;
import com.cxjd.nvwabao.bean.User;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 白 on 2018/3/21.
 *  用于 进行回帖 编辑页面
 */

public class PeopleChatOneActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG;

    private String returnChat;

    //接收的 需要回复的用户id
    private int peopleId;

    //
    private Boolean isPause;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1_say);

        Intent intent = getIntent();

        peopleId = intent.getIntExtra("id", 0);
        System.out.println("id为---------"+peopleId);



        TextView send_text = (TextView) findViewById(R.id.send_text);
        send_text.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.send_text:
                EditText editText = (EditText) findViewById(R.id.say_text);
                returnChat = editText.getText().toString().trim();
                if (TextUtils.isEmpty(returnChat)) {
                    Toast.makeText(this, "不可为空", Toast.LENGTH_SHORT).show();
                } else {
                    List<User> users= DataSupport.findAll(User.class);
                    String username=users.get(0).getmName();

                    PeopleReturn peopleReturn = new PeopleReturn();
                    peopleReturn.setPeopleId(peopleId);
                    peopleReturn.setReturnChat(returnChat);

                    peopleReturn.setReturnName(username);
                    peopleReturn.setImageId(R.drawable.a1_people);
                    peopleReturn.save();

                    /*Intent intent = new Intent(this, PeopleChatActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("id",peopleId+"");
                    intent.putExtras(bundle);*/

                    Toast.makeText(this, "回复成功！", Toast.LENGTH_SHORT).show();

                    //startActivity(intent);
                    finish();
                }
                break;
        }
    }



}
