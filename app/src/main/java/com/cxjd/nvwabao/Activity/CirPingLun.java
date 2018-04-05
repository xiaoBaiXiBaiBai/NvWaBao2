package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.PingLunPeople;
import com.cxjd.nvwabao.bean.User;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 项目名： NvWaBao2
 * 包名：   com.cxjd.nvwabao.Activity
 * 文件名： CirPingLun
 * 创建者： LC
 * 创建时间： 2018/4/3 16:54
 * 描述：   TODO
 */
public class CirPingLun extends AppCompatActivity {
    //发送按钮
    private Button sendButton;
    //编辑框
    private EditText ed;

    private String content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cir_pinglun);
        initView();
    }

    private void initView() {
        TextView tvTitle = findViewById(R.id.fragment_title);
        tvTitle.setText("评论帖子");

        //获取发送按钮
        sendButton = findViewById(R.id.cir_send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取编辑
                ed = findViewById(R.id.pinglun_say_text);
                //获取内容
                 content = ed.getText().toString();
                    if (content.isEmpty()){
                        Toast.makeText(CirPingLun.this,"评论不能为空",Toast.LENGTH_SHORT).show();
                    }else {
                        List<User> users = DataSupport.findAll(User.class);
                        PingLunPeople pingLunPeople = new PingLunPeople();
                        if (!users.isEmpty()) {
                            pingLunPeople.setName(users.get(0).getmName());
                            pingLunPeople.setData("刚刚");
                            pingLunPeople.setPingLun(content);
                            pingLunPeople.save();
                        }  else {
                            pingLunPeople.setName("游客");
                            pingLunPeople.setData("刚刚");
                            pingLunPeople.setPingLun(content);
                            pingLunPeople.save();
                        }
                        finish();
                    }

            }
        });
    }

}
