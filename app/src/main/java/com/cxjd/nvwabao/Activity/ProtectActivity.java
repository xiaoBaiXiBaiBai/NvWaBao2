package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cxjd.nvwabao.R;

public class ProtectActivity extends AppCompatActivity {
    private ImageView  guwu,dounairu,gandou,qinshou,shucai,shuichan,shuiguoganguo,yaocai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protect);
        init();
        guwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProtectActivity.this,FoodListActivity.class);
                intent.putExtra("leixing",4);
                startActivity(intent);
            }
        });
        qinshou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProtectActivity.this,FoodListActivity.class);
                intent.putExtra("leixing",1);
                startActivity(intent);
            }
        });
        dounairu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProtectActivity.this,FoodListActivity.class);
                intent.putExtra("leixing",3);
                startActivity(intent);
            }
        });
        gandou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProtectActivity.this,FoodListActivity.class);
                intent.putExtra("leixing",2);
                startActivity(intent);
            }
        });
        shucai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProtectActivity.this,FoodListActivity.class);
                intent.putExtra("leixing",0);
                startActivity(intent);
            }
        });
        shuichan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProtectActivity.this,FoodListActivity.class);
                intent.putExtra("leixing",5);
                startActivity(intent);
            }
        });
        shuiguoganguo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProtectActivity.this,FoodListActivity.class);
                intent.putExtra("leixing",6);
                startActivity(intent);
            }
        });
        yaocai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProtectActivity.this,FoodListActivity.class);
                intent.putExtra("leixing",7);
                startActivity(intent);
            }
        });
    }

    private void init() {
        guwu = (ImageView) findViewById(R.id.guwu);
        dounairu = (ImageView) findViewById(R.id.dounairu);
        gandou = (ImageView) findViewById(R.id.gandou);
        qinshou = (ImageView) findViewById(R.id.qinshou);
        shucai = (ImageView) findViewById(R.id.shucai);
        shuichan = (ImageView) findViewById(R.id.shuichan);
        shuiguoganguo = (ImageView) findViewById(R.id.shuiguoganguo);
        yaocai = (ImageView) findViewById(R.id.yaocai);

    }
}
