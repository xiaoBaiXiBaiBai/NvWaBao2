package com.cxjd.nvwabao.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.AidAdapter;
import com.cxjd.nvwabao.bean.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里是急救手册
 * Created by 李超 on 2017/12/4.
 */

public class FirstAid extends AppCompatActivity {

    private List<ListView> list = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);

        //初始化选项中的数据
        if(list.isEmpty()==true){
            initItems();
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.aid_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(layoutManager);
        AidAdapter aidAdapter = new AidAdapter(list);
        recyclerView.setAdapter(aidAdapter);

    }

    private void initItems() {
        ListView item0 = new ListView("烫伤");
        list.add(item0);
        ListView item1 = new ListView("发烧");
        list.add(item1);
        ListView item2 = new ListView("牙痛");
        list.add(item2);
        ListView item3 = new ListView("扭伤");
        list.add(item3);
        ListView item4 = new ListView("食物中毒");
        list.add(item4);
        ListView item5 = new ListView("煤气中毒");
        list.add(item5);
        ListView item6 = new ListView("酒精中毒");
        list.add(item6);
        ListView item7 = new ListView("鱼骨刺喉");
        list.add(item7);
        ListView item8 = new ListView("中暑");
        list.add(item8);
        ListView item9 = new ListView("腹痛");
        list.add(item9);
        ListView item10 = new ListView("流鼻血");
        list.add(item10);
        ListView item11 = new ListView("头痛");
        list.add(item11);
        ListView item12 = new ListView("癫痫");
        list.add(item12);
        ListView item13 = new ListView("神经衰弱");
        list.add(item13);
        ListView item14 = new ListView("呼吸困难");
        list.add(item14);
        ListView item15 = new ListView("急性肺炎");
        list.add(item15);
        ListView item16 = new ListView("胃痉挛");
        list.add(item16);
        ListView item17 = new ListView("心绞痛");
        list.add(item17);
        ListView item18 = new ListView("脑溢血");
        list.add(item18);
        ListView item19 = new ListView("昏迷");
        list.add(item19);
        ListView item20 = new ListView("窒息");
        list.add(item20);
        ListView item21 = new ListView("蜜蜂蛰伤");
        list.add(item21);
        ListView item22 = new ListView("抽筋");
        list.add(item22);
        ListView item23 = new ListView("中风");
        list.add(item23);
        ListView item24 = new ListView("触电");
        list.add(item24);
        ListView item25 = new ListView("宠物咬伤");
        list.add(item25);
        ListView item26 = new ListView("出血");
        list.add(item26);
        ListView item27 = new ListView("头部受伤");
        list.add(item27);
        ListView item28 = new ListView("突发耳聋");
        list.add(item28);
        ListView item29 = new ListView("心脏骤停");
        list.add(item29);
        ListView item30 = new ListView("人工呼吸");
        list.add(item30);
        ListView item31 = new ListView("爆炸伤");
        list.add(item31);
        ListView item32 = new ListView("服错药");
        list.add(item32);
        ListView item33 = new ListView("骨折");
        list.add(item33);
        ListView item34 = new ListView("溺水");
        list.add(item34);
        ListView item35 = new ListView("手指切断");
        list.add(item35);
        ListView item36 = new ListView("异物卡喉");
        list.add(item36);
        ListView item37 = new ListView("木刺");
        list.add(item37);
        ListView item38 = new ListView("烧伤");
        list.add(item38);
        ListView item39 = new ListView("手指切伤");
        list.add(item39);
        ListView item40 = new ListView("失血休克");
        list.add(item40);
        ListView item41 = new ListView("异物入眼");
        list.add(item41);
        ListView item42 = new ListView("胃穿孔");
        list.add(item42);
        ListView item43 = new ListView("指甲受挫");
        list.add(item43);
    }
}
