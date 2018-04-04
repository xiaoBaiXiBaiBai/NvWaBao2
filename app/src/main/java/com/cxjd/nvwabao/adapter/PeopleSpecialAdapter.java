package com.cxjd.nvwabao.adapter;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxjd.nvwabao.Activity.PeopleSendTestActivity;
import com.cxjd.nvwabao.R;

import tyrantgit.explosionfield.ExplosionField;

/**
 * Created by 白 on 2018/3/29.
 */

public class PeopleSpecialAdapter extends AppCompatActivity implements View.OnClickListener {
    private Intent mIntent;

    private ImageView imageView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specialpeople_flower);
        findViewById(R.id.tv_reveal).setOnClickListener(this);
        initview();
        mIntent = new Intent();
        getWindow().setExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.slide));

    }

    private void initview() {
        imageView = (ImageView) findViewById(R.id.flower);
        TextView textView = (TextView) findViewById(R.id.fragment_title);
        textView.setText("(=￣ω￣=)");

        com.cxjd.nvwabao.bean.ExplosionField explosionField = new com.cxjd.nvwabao.bean.ExplosionField(this);

        explosionField.addListener(findViewById(R.id.root));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_reveal:
                mIntent.setClass(this, PeopleSendTestActivity.class);
                ActivityOptions transitionActivityOptions2 = ActivityOptions.makeSceneTransitionAnimation(PeopleSpecialAdapter.this, findViewById(R.id.img_reveal_share), "share");
                //5.0以下兼容
                //ActivityOptionsCompat activityOptionsCompat2 = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, findViewById(R.id.img_reveal_share), "share");
                startActivity(mIntent, transitionActivityOptions2.toBundle());
                break;
        }

    }
}
