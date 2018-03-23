package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by 白 on 2018/3/21.
 */

public class PeopleChatOneActivity extends AppCompatActivity {

    private String TAG;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 1);

    }



}
