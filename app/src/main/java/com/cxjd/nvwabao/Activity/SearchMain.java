package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.utils.HttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SearchMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);
        Button back = (Button) findViewById(R.id.nav_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button button = (Button) findViewById(R.id.bt_go);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchMain.this,People.class);
                startActivity(intent);
            }
        });
        Button btnRoom = (Button) findViewById(R.id.bt_goRoom);
        btnRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchMain.this,Room.class);
                startActivity(intent);
            }
        });
        Button btnAge = (Button) findViewById(R.id.bt_people);
        btnAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchMain.this,AgePo.class);
                startActivity(intent);
            }
        });
        HttpUtil.sendOkHttpRequest("http://192.168.31.227/user/getDepartments/", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
        HttpUtil.sendOkHttpRequest("http://192.168.31.227/user/getDepartments/0", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
        HttpUtil.sendOkHttpRequest("http://192.168.31.227/user/getCrowdSick/", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
        HttpUtil.sendOkHttpRequest("http://192.168.31.227/user/getDepartments/", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

    }
}

