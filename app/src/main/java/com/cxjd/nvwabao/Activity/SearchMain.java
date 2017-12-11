package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.fragment.ManFFFragment;
import com.cxjd.nvwabao.fragment.ManFHFragment;
import com.cxjd.nvwabao.fragment.womenFHFragment;
import com.cxjd.nvwabao.fragment.womenFrontFragment;
import com.cxjd.nvwabao.utils.HttpUtil;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SearchMain extends AppCompatActivity {
    private Button button,btnRoom,btnAge;
    private ImageView   zhengmianbtn,beimianbtn,nanqianbtn,nanhoubtn,nvqianbtn,nvhoubtn;
    private com.cxjd.nvwabao.fragment.womenFrontFragment womenFrontFragment = new womenFrontFragment();
    private com.cxjd.nvwabao.fragment.womenFHFragment womenFHFragment = new womenFHFragment();
    private ManFFFragment manFFFragment = new ManFFFragment();
    private ManFHFragment manFHFragment = new ManFHFragment();

    private  Fragment xingbie = womenFrontFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);
        replaceFragment( womenFrontFragment);
        nanqianbtn = (ImageView) findViewById(R.id.nanqianbtn);
        nanhoubtn = (ImageView) findViewById(R.id.nanhoubtn);
        nvqianbtn = (ImageView) findViewById(R.id.nvqianbtn);
        nvhoubtn = (ImageView) findViewById(R.id.nvhoubtn);

        button = (Button) findViewById(R.id.bt_go);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setBackgroundColor(Color.parseColor("#1aaee1"));
                Intent intent = new Intent(SearchMain.this,People.class);
                startActivity(intent);
            }
        });
        btnRoom = (Button) findViewById(R.id.bt_goRoom);
        btnRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRoom.setBackgroundColor(Color.parseColor("#1aaee1"));
                Intent intent = new Intent(SearchMain.this,Room.class);
                startActivity(intent);
            }
        });
       btnAge = (Button) findViewById(R.id.bt_people);
        btnAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAge.setBackgroundColor(Color.parseColor("#1aaee1"));
                Intent intent = new Intent(SearchMain.this,People2.class);
                startActivity(intent);
            }
        });
        zhengmianbtn = (ImageView) findViewById(R.id.zhengmianbtn);
        zhengmianbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xingbie == womenFrontFragment){
                    replaceFragment(womenFrontFragment);
                }else {
                    replaceFragment(manFFFragment);
                }

                zhengmianbtn.setVisibility(View.GONE);
                beimianbtn.setVisibility(View.VISIBLE);
            }
        });

        beimianbtn = (ImageView) findViewById(R.id.beimianbtn);
        beimianbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xingbie == womenFrontFragment){
                    replaceFragment(womenFHFragment);
                }else {
                    replaceFragment(manFHFragment);
                }

                beimianbtn.setVisibility(View.GONE);
                zhengmianbtn.setVisibility(View.VISIBLE);
            }
        });
        nanqianbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nanqianbtn.setVisibility(View.GONE);
                nanhoubtn.setVisibility(View.VISIBLE);
                nvqianbtn.setVisibility(View.VISIBLE);
                nvhoubtn.setVisibility(View.GONE);
                replaceFragment(manFFFragment);
                xingbie=manFFFragment;
                beimianbtn.setVisibility(View.VISIBLE);
                zhengmianbtn.setVisibility(View.GONE);
            }
        });
        nvqianbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nanqianbtn.setVisibility(View.VISIBLE);
                nanhoubtn.setVisibility(View.INVISIBLE);
                nvqianbtn.setVisibility(View.GONE);
                nvhoubtn.setVisibility(View.VISIBLE);
                replaceFragment(womenFrontFragment);
                xingbie=womenFrontFragment;
                beimianbtn.setVisibility(View.VISIBLE);
                zhengmianbtn.setVisibility(View.GONE);
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

    @Override
    protected void onResume() {
        super.onResume();
        button.setBackgroundColor(Color.parseColor("#ffffff"));
        btnRoom.setBackgroundColor(Color.parseColor("#ffffff"));
        btnAge.setBackgroundColor(Color.parseColor("#ffffff"));
    }
    private  void  replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.women1,fragment);
        transaction.commit();
    }
}

