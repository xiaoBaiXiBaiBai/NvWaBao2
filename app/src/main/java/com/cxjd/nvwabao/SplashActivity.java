package com.cxjd.nvwabao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cxjd.nvwabao.mainActivity.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Intent intent=new Intent(SplashActivity.this, MainActivity.class);
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {

            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(task, 1000*2);
    }
}
