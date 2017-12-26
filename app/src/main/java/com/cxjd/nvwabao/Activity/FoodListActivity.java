package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.Fruit2Adapter;
import com.cxjd.nvwabao.adapter.FruitAdapter;
import com.cxjd.nvwabao.bean.Fruit;
import com.cxjd.nvwabao.bean.Fruit2;
import com.cxjd.nvwabao.mainActivity.MainActivity;
import com.cxjd.nvwabao.utils.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FoodListActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    private List<Fruit2> fruitList2 = new ArrayList<>();
    private FruitAdapter adapter;
    private Fruit2Adapter adapter2;
    private String UrlBase = "http://47.94.145.225/user/getKey/";
    private String listName,Url;
    private ImageView fruit_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        fruit_image = findViewById(R.id.fruit_image);
        int  leixingINT =getIntent().getIntExtra("leixing",8);
        listName = getIntent().getStringExtra("listName");
        Url = UrlBase+listName;

        switch (leixingINT){
            case 0:initshucai();
                adapter = new FruitAdapter(FoodListActivity.this,R.layout.foot_list,fruitList);
                ListView listView = (ListView) findViewById(R.id.list_view);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Log.e("Url","蔬菜/"+position);
                        Intent intent = new Intent(FoodListActivity.this,FoodInfoActivity.class);
                        intent.putExtra("address","蔬菜/"+position);
                        startActivity(intent);
                    }
                });
                break;
            case 1:initqinchu();
                adapter = new FruitAdapter(FoodListActivity.this,R.layout.foot_list,fruitList);
                ListView listView1 = (ListView) findViewById(R.id.list_view);
                listView1.setAdapter(adapter);
                listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       Intent intent = new Intent(FoodListActivity.this,FoodInfoActivity.class);
                        intent.putExtra("address","畜禽/"+position);
                        startActivity(intent);
                    }
                });
                break;
            case 2: initgandou();
                adapter = new FruitAdapter(FoodListActivity.this,R.layout.foot_list,fruitList);
                ListView listView2 = (ListView) findViewById(R.id.list_view);
                listView2.setAdapter(adapter);
                listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       Intent intent = new Intent(FoodListActivity.this,FoodInfoActivity.class);
                        intent.putExtra("address","干豆/"+position);
                        startActivity(intent);
                    }
                });
                break;
            case 3:  initdounairu();
                adapter = new FruitAdapter(FoodListActivity.this,R.layout.foot_list,fruitList);
                ListView listView3 = (ListView) findViewById(R.id.list_view);
                listView3.setAdapter(adapter);
                listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(FoodListActivity.this,FoodInfoActivity.class);
                        intent.putExtra("address","蛋奶乳/"+position);
                        startActivity(intent);
                    }
                });
                break;
            case 4: initguwu();
                adapter = new FruitAdapter(FoodListActivity.this,R.layout.foot_list,fruitList);
                ListView listView4 = (ListView) findViewById(R.id.list_view);
                listView4.setAdapter(adapter);
                listView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(FoodListActivity.this,FoodInfoActivity.class);
                        intent.putExtra("address","谷物/"+position);
                        startActivity(intent);
                    }
                });
                break;
            case 5:initshuichan();
                adapter = new FruitAdapter(FoodListActivity.this,R.layout.foot_list,fruitList);
                ListView listView5 = (ListView) findViewById(R.id.list_view);
                listView5.setAdapter(adapter);
                listView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(FoodListActivity.this,FoodInfoActivity.class);
                        intent.putExtra("address","水产/"+position);
                        startActivity(intent);

                    }
                });
                break;
            case 6:initshuoguoganguo();
                adapter = new FruitAdapter(FoodListActivity.this,R.layout.foot_list,fruitList);
                ListView listView6 = (ListView) findViewById(R.id.list_view);
                listView6.setAdapter(adapter);
                listView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                         Intent intent = new Intent(FoodListActivity.this,FoodInfoActivity.class);
                        intent.putExtra("address","水果干果/"+position);
                        startActivity(intent);
                    }
                });
                break;
            case 7: inityaocai();
                adapter = new FruitAdapter(FoodListActivity.this,R.layout.foot_list,fruitList);
                ListView listView7 = (ListView) findViewById(R.id.list_view);
                listView7.setAdapter(adapter);
                listView7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(FoodListActivity.this,FoodInfoActivity.class);
                        intent.putExtra("address","药材/"+position);
                        startActivity(intent);
                    }
                });
                break;
            case 8: inittiaoweipin();
                adapter = new FruitAdapter(FoodListActivity.this,R.layout.foot_list,fruitList);
                ListView listView8 = (ListView) findViewById(R.id.list_view);
                listView8.setAdapter(adapter);
                listView8.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(FoodListActivity.this,FoodInfoActivity.class);
                        intent.putExtra("address","调味品/"+position);
                        startActivity(intent);
                    }
                });
                break;
            case 9: inithuahui();
                adapter = new FruitAdapter(FoodListActivity.this,R.layout.foot_list,fruitList);
                ListView listView9 = (ListView) findViewById(R.id.list_view);
                listView9.setAdapter(adapter);
                listView9.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(FoodListActivity.this,FoodInfoActivity.class);
                        intent.putExtra("address","花卉/"+position);
                        startActivity(intent);
                    }
                });
                break;
            case 10: initchalei();
                adapter = new FruitAdapter(FoodListActivity.this,R.layout.foot_list,fruitList);
                ListView listView10 = (ListView) findViewById(R.id.list_view);
                listView10.setAdapter(adapter);
                listView10.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(FoodListActivity.this,FoodInfoActivity.class);
                        intent.putExtra("address","茶类/"+position);
                        startActivity(intent);
                    }
                });
                break;
            default:Data(Url);
                Log.e("aaaaaa", "=================");
                adapter2 = new Fruit2Adapter(FoodListActivity.this,R.layout.foot_list,fruitList2);
                ListView listView11 = (ListView) findViewById(R.id.list_view);
                listView11.setAdapter(adapter2);
                //Data(Url);
                listView11.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(FoodListActivity.this,FoodInfoActivity.class);
                        intent.putExtra("content_url",fruitList2.get(position).getIconUrl());
                        //intent.putExtra("address","药材/"+position);
                        startActivity(intent);
                    }
                });
                break;
        }

        Log.e("leixing",leixingINT+"");

    }

    private void inittiaoweipin() {
        Fruit bajiaohuixiang = new Fruit("八角茴香",R.drawable.tiaoweipin);
        fruitList.add(bajiaohuixiang);
        Fruit 白糖 = new Fruit("白糖",R.drawable.tiaoweipin);
        fruitList.add(白糖);
        Fruit 菜籽油 = new Fruit("菜籽油",R.drawable.tiaoweipin);
        fruitList.add(菜籽油);
        Fruit 醋 = new Fruit("醋",R.drawable.tiaoweipin);
        fruitList.add(醋);
        Fruit 大蒜 = new Fruit("大蒜",R.drawable.tiaoweipin);
        fruitList.add(大蒜);
        Fruit 红糖 = new Fruit("红糖",R.drawable.tiaoweipin);
        fruitList.add(红糖);
        Fruit 胡椒 = new Fruit("胡椒",R.drawable.tiaoweipin);
        fruitList.add(胡椒);
        Fruit 花椒 = new Fruit("花椒",R.drawable.tiaoweipin);
        fruitList.add(花椒);
        Fruit 酱油 = new Fruit("酱油",R.drawable.tiaoweipin);
        fruitList.add(酱油);
        Fruit 芥末 = new Fruit("芥末",R.drawable.tiaoweipin);
        fruitList.add(芥末);
        Fruit 咖喱 = new Fruit("咖喱",R.drawable.tiaoweipin);
        fruitList.add(咖喱);
        Fruit 生姜 = new Fruit("生姜",R.drawable.tiaoweipin);
        fruitList.add(生姜);
        Fruit 食盐 = new Fruit("食盐",R.drawable.tiaoweipin);
        fruitList.add(食盐);
        Fruit 小茴香 = new Fruit("小茴香",R.drawable.tiaoweipin);
        fruitList.add(小茴香);
        Fruit 枣花蜜 = new Fruit("枣花蜜",R.drawable.tiaoweipin);
        fruitList.add(枣花蜜);


    }

    private void inithuahui() {
        Fruit 百合 = new Fruit("百合",R.drawable.huahuilei);
        fruitList.add(百合);
        Fruit 菜花 = new Fruit("菜花",R.drawable.huahuilei);
        fruitList.add(菜花);

        Fruit 桂花 = new Fruit("桂花",R.drawable.huahuilei);
        fruitList.add(桂花);

        Fruit 槐花 = new Fruit("槐花",R.drawable.huahuilei);
        fruitList.add(槐花);

        Fruit 金针菜 = new Fruit("金针菜",R.drawable.huahuilei);
        fruitList.add(金针菜);

        Fruit 菊花 = new Fruit("菊花",R.drawable.huahuilei);
        fruitList.add(菊花);
        Fruit 玫瑰花 = new Fruit("玫瑰花",R.drawable.huahuilei);
        fruitList.add(玫瑰花);
        Fruit 茉莉花 = new Fruit("茉莉花",R.drawable.huahuilei);
        fruitList.add(茉莉花);
        Fruit 木槿花 = new Fruit("木槿花",R.drawable.huahuilei);
        fruitList.add(木槿花);
        Fruit 栀子花 = new Fruit("栀子花",R.drawable.huahuilei);
        fruitList.add(栀子花);

    }

    private void initchalei() {
        Fruit 碧螺春 = new Fruit("碧螺春",R.drawable.chalei);
        fruitList.add(碧螺春);
        Fruit 茶叶 = new Fruit("茶叶",R.drawable.chalei);
        fruitList.add(茶叶);
        Fruit 铁观音 = new Fruit("铁观音",R.drawable.chalei);
        fruitList.add(铁观音);
    }

    private void inityaocai() {
        Fruit baishao = new Fruit("白芍",R.drawable.baishao);
        fruitList.add(baishao);
        Fruit baishu = new Fruit("白术",R.drawable.baishu);
        fruitList.add(baishu);
        Fruit binglang = new Fruit("槟榔",R.drawable.binglang);
        fruitList.add(binglang);
        Fruit chaihu = new Fruit("柴胡",R.drawable.chaihu);
        fruitList.add(chaihu);
        Fruit cheqianzi = new Fruit("车前子",R.drawable.cheqianzi);
        fruitList.add(cheqianzi);
        Fruit chenpi = new Fruit("陈皮",R.drawable.chenpi);
        fruitList.add(chenpi);

        Fruit chuanbei = new Fruit("川贝",R.drawable.chuanbei);
        fruitList.add(chuanbei);

        Fruit chuanchenzi = new Fruit("川楝子",R.drawable.chuanchenzi);
        fruitList.add(chuanchenzi);
        Fruit chuanniuxi = new Fruit("川牛膝",R.drawable.chuanniuxi);
        fruitList.add(chuanniuxi);
        Fruit chuanwu = new Fruit("川乌",R.drawable.chuanwu);
        fruitList.add(chuanwu);
        Fruit chuanqiong = new Fruit("川芎",R.drawable.chuanqiong);
        fruitList.add(chuanqiong);
        Fruit daji = new Fruit("大戟",R.drawable.daji);
        fruitList.add(daji);
        Fruit danshen = new Fruit("丹参",R.drawable.danshen);
        fruitList.add(danshen);
        Fruit danggui = new Fruit("当归",R.drawable.danggui);
        fruitList.add(danggui);
        Fruit dangshen = new Fruit("党参",R.drawable.dangshen);
        fruitList.add(dangshen);
        Fruit dongchongxiacao = new Fruit("冬虫夏草",R.drawable.dongchongxiacao);
        fruitList.add(dongchongxiacao);
        Fruit duhuo = new Fruit("独活",R.drawable.duhuo);
        fruitList.add(duhuo);
        Fruit duzhong = new Fruit("杜仲",R.drawable.duzhong);
        fruitList.add(duzhong);
        Fruit fangfeng = new Fruit("防风",R.drawable.fangfeng);
        fruitList.add(fangfeng);
        Fruit gancao = new Fruit("甘草",R.drawable.gancao);
        fruitList.add(gancao);
        Fruit gansui = new Fruit("甘遂",R.drawable.gansui);
        fruitList.add(gansui);
        Fruit guizhi = new Fruit("桂枝",R.drawable.guizhi);
        fruitList.add(guizhi);
        Fruit hongshen = new Fruit("红参",R.drawable.hongshen);
        fruitList.add(hongshen);
        Fruit huaqishen = new Fruit("花旗参",R.drawable.huaqishen);
        fruitList.add(huaqishen);
        Fruit huaishan = new Fruit("淮山",R.drawable.huaishan);
        fruitList.add(huaishan);
        Fruit huangjing = new Fruit("黄精",R.drawable.huangjing);
        fruitList.add(huangjing);
        Fruit huangshi = new Fruit("黄芪",R.drawable.huangshi);
        fruitList.add(huangshi);
        Fruit jiegeng = new Fruit("桔梗",R.drawable.jiegeng);
        fruitList.add(jiegeng);
         Fruit kushen = new Fruit("苦参",R.drawable.kushen);
        fruitList.add(kushen);
        Fruit luohanguo = new Fruit("罗汉果",R.drawable.luohanguo);
        fruitList.add(luohanguo);
        Fruit maidong = new Fruit("麦冬",R.drawable.maidong);
        fruitList.add(maidong);
        Fruit niuxi = new Fruit("牛膝",R.drawable.niuxi);
        fruitList.add(niuxi);
        Fruit qianghuo = new Fruit("羌活",R.drawable.qianghuo);
        fruitList.add(qianghuo);
        Fruit renshen = new Fruit("人参",R.drawable.renshen);
        fruitList.add(renshen);
        Fruit shashen = new Fruit("沙参",R.drawable.shashen);
        fruitList.add(shashen);
        Fruit shanyao = new Fruit("山药",R.drawable.shanyao);
        fruitList.add(shanyao);
        Fruit shengdi = new Fruit("生地",R.drawable.shengdi);
        fruitList.add(shengdi);
        Fruit taizishen = new Fruit("太子参",R.drawable.taizishen);
        fruitList.add(taizishen);
        Fruit tianma = new Fruit("天麻",R.drawable.tianma);
        fruitList.add(tianma);
        Fruit tianqi = new Fruit("田七",R.drawable.tianqi);
        fruitList.add(tianqi);
        Fruit tudangshen = new Fruit("土党参",R.drawable.tudangshen);
        fruitList.add(tudangshen);
        Fruit weilingxian = new Fruit("威灵仙",R.drawable.weilingxian);
        fruitList.add(weilingxian);
        Fruit wulingzhi = new Fruit("五灵脂",R.drawable.wulingzhi);
        fruitList.add(wulingzhi);
        Fruit wuweizi = new Fruit("五味子",R.drawable.wuweizi);
        fruitList.add(wuweizi);
        Fruit xiyangshen = new Fruit("西洋参",R.drawable.xiyangshen);
        fruitList.add(xiyangshen);
        Fruit xixin = new Fruit("细辛",R.drawable.xixin);
        fruitList.add(xixin);
        Fruit chunfu = new Fruit("春附",R.drawable.chunfu);
        fruitList.add(chunfu);
        Fruit xuanshen = new Fruit("玄参",R.drawable.xuanshen);
        fruitList.add(xuanshen);
        Fruit yimucao = new Fruit("益母草",R.drawable.yimucao);
        fruitList.add(yimucao);
        Fruit yuzhu = new Fruit("玉竹",R.drawable.yuzhu);
        fruitList.add(yuzhu);
        Fruit yujin = new Fruit("郁金",R.drawable.yujin);
        fruitList.add(yujin);
        Fruit zhike = new Fruit("枳壳",R.drawable.zhike);
        fruitList.add(zhike);




    }

    private void initshuoguoganguo() {
        Fruit baixiangguo = new Fruit("百香果",R.drawable.baixiangguo);
        fruitList.add(baixiangguo);
        Fruit biqi = new Fruit("荸荠",R.drawable.biqi);
        fruitList.add(biqi);
        Fruit bigenguo = new Fruit("碧根果",R.drawable.bigenguo);
        fruitList.add(bigenguo);
        Fruit boluo = new Fruit("菠萝",R.drawable.boluo);
        fruitList.add(boluo);
        Fruit boluomi = new Fruit("菠萝蜜",R.drawable.boluomi);
        fruitList.add(boluomi);
        Fruit caigua = new Fruit("菜瓜",R.drawable.caigua);
        fruitList.add(caigua);
        Fruit caomei = new Fruit("草莓",R.drawable.caomei);
        fruitList.add(caomei);
        Fruit chengzi = new Fruit("橙子",R.drawable.chengzi);
        fruitList.add(chengzi);
        Fruit cili = new Fruit("刺梨",R.drawable.cili);
        fruitList.add(cili);
        Fruit dongzao = new Fruit("冬枣",R.drawable.dongzao);
        fruitList.add(dongzao);
        Fruit fanshiliu = new Fruit("番石榴",R.drawable.fanshiliu);
        fruitList.add(fanshiliu);
        Fruit feizi = new Fruit("榧子",R.drawable.feizi);
        fruitList.add(feizi);
        Fruit ganzhe = new Fruit("甘蔗",R.drawable.ganzhe);
        fruitList.add(ganzhe);
        /*
        Fruit ganlan = new Fruit("橄榄",R.drawable.ganlan);
        fruitList.add(ganlan);
        */
        Fruit gouqi = new Fruit("枸杞",R.drawable.gouqi);
        fruitList.add(gouqi);
        Fruit guniangguo = new Fruit("姑娘果",R.drawable.guniangguo);
        fruitList.add(guniangguo);

        Fruit ganlan = new Fruit("龙眼",R.drawable.longyan);
        fruitList.add(ganlan);

        Fruit hamigua = new Fruit("哈密瓜",R.drawable.hamigua);
        fruitList.add(hamigua);
        Fruit haitangguo = new Fruit("海棠果",R.drawable.haitangguo);
        fruitList.add(haitangguo);

        Fruit hetao = new Fruit("核桃",R.drawable.hetao);
        fruitList.add(hetao);
        Fruit heibulin = new Fruit("黑布林",R.drawable.heibulin);
        fruitList.add(heibulin);
        Fruit heigouqi = new Fruit("黑枸杞",R.drawable.heigouqi);
        fruitList.add(heigouqi);
        Fruit heizao = new Fruit("黑枣",R.drawable.heizao);
        fruitList.add(heizao);
        Fruit heizhima = new Fruit("黑芝麻",R.drawable.heizhima);
        fruitList.add(heizhima);

        Fruit hongzao = new Fruit("红枣",R.drawable.hongzao);
        fruitList.add(hongzao);

        Fruit huasheng = new Fruit("花生",R.drawable.huasheng);
        fruitList.add(huasheng);
        Fruit huangtao = new Fruit("黄桃",R.drawable.huangtao);
        fruitList.add(huangtao);
        Fruit huolongguo = new Fruit("火龙果",R.drawable.huolongguo);
        fruitList.add(huolongguo);
        Fruit huomaren = new Fruit("火麻仁",R.drawable.huomaren);
        fruitList.add(huomaren);
        Fruit jinju = new Fruit("金桔",R.drawable.jinju);
        fruitList.add(jinju);
        Fruit juzi = new Fruit("橘子",R.drawable.juzi);
        fruitList.add(juzi);
        Fruit kafeidou = new Fruit("咖啡豆",R.drawable.kafeidou);
        fruitList.add(kafeidou);
        Fruit kaixinguo = new Fruit("开心果",R.drawable.kaixinguo);
        fruitList.add(kaixinguo);
        Fruit kuihuazi = new Fruit("葵花子",R.drawable.kuihuazi);
        fruitList.add(kuihuazi);
        Fruit lanmei = new Fruit("蓝莓",R.drawable.lanmei);
        fruitList.add(lanmei);
        Fruit li = new Fruit("梨",R.drawable.li);
        fruitList.add(li);
        Fruit lizi = new Fruit("李子",R.drawable.lizi);
        fruitList.add(lizi);
        Fruit lizhi = new Fruit("荔枝",R.drawable.lizhi);
        fruitList.add(lizhi);
        Fruit lizi1 = new Fruit("栗子",R.drawable.lizi1);
        fruitList.add(lizi1);
        Fruit lianzi = new Fruit("莲子",R.drawable.lianzi);
        fruitList.add(lianzi);
        Fruit lingjiao = new Fruit("菱角",R.drawable.lingjiao);
        fruitList.add(lingjiao);
        Fruit liulian = new Fruit("榴莲",R.drawable.liulian);
        fruitList.add(liulian);
       /* Fruit longyan = new Fruit("龙眼",R.drawable.longyan);
        fruitList.add(longyan);*/
        Fruit luohanguo = new Fruit("罗汉果",R.drawable.luohanguo);
        fruitList.add(luohanguo);
        Fruit mangguo = new Fruit("芒果",R.drawable.mangguo);
        fruitList.add(mangguo);
        Fruit maotao = new Fruit("毛桃",R.drawable.maotao);
        fruitList.add(maotao);
        Fruit mihoutao = new Fruit("猕猴桃",R.drawable.mihoutao);
        fruitList.add(mihoutao);
        Fruit mugua = new Fruit("木瓜",R.drawable.mugua);
        fruitList.add(mugua);
        Fruit nanguazi = new Fruit("南瓜子",R.drawable.nanguazi);
        fruitList.add(nanguazi);
        Fruit ningmeng = new Fruit("柠檬",R.drawable.ningmeng);
        fruitList.add(ningmeng);
        Fruit niuyouguo = new Fruit("牛油果",R.drawable.niuyouguo);
        fruitList.add(niuyouguo);
       /* Fruit panlizhi = new Fruit("盘荔枝",R.drawable.panlizhi);
        fruitList.add(panlizhi);*/
        Fruit pipa = new Fruit("枇杷",R.drawable.pipa);
        fruitList.add(pipa);
        Fruit pingguo = new Fruit("苹果",R.drawable.pingguo);
        fruitList.add(pingguo);
        Fruit putao = new Fruit("葡萄",R.drawable.putao);
        fruitList.add(putao);
        Fruit putaogan = new Fruit("葡萄干",R.drawable.putaogan);
        fruitList.add(putaogan);
        Fruit putaopi = new Fruit("葡萄皮",R.drawable.putaopi);
        fruitList.add(putaopi);
        Fruit putaoyou = new Fruit("葡萄柚",R.drawable.putaoyou);
        fruitList.add(putaoyou);
        Fruit putaozi = new Fruit("葡萄籽",R.drawable.putaozi);
        fruitList.add(putaozi);
        Fruit qianshi = new Fruit("芡实",R.drawable.qianshi);
        fruitList.add(qianshi);

        Fruit qingguo = new Fruit("橄榄",R.drawable.ganlan);
        fruitList.add(qingguo);

        Fruit qingmei = new Fruit("青梅",R.drawable.qingmei);
        fruitList.add(qingmei);
        Fruit renshenguo = new Fruit("人参果",R.drawable.renshenguo);
        fruitList.add(renshenguo);

        Fruit sangshen = new Fruit("桑葚",R.drawable.sangshen);
        fruitList.add(sangshen);

        Fruit shaguo = new Fruit("沙果",R.drawable.shaguo);
        fruitList.add(shaguo);
        Fruit shanmei = new Fruit("山梅",R.drawable.shanmei);
        fruitList.add(shanmei);
        Fruit shanzha = new Fruit("山楂",R.drawable.shanzha);
        fruitList.add(shanzha);
        Fruit shanzhu = new Fruit("山竹",R.drawable.shanzhu);
        fruitList.add(shanzhu);
        Fruit sheguo = new Fruit("蛇果",R.drawable.sheguo);
        fruitList.add(sheguo);
        Fruit shengnvguo = new Fruit("圣女果",R.drawable.shengnvguo);
        fruitList.add(shengnvguo);
        Fruit shiliu = new Fruit("石榴",R.drawable.shiliu);
        fruitList.add(shiliu);
        Fruit shizi = new Fruit("柿子",R.drawable.shizi);
        fruitList.add(shizi);

        Fruit songzi = new Fruit("松子",R.drawable.songzi);
        fruitList.add(songzi);
        Fruit taoren = new Fruit("桃仁",R.drawable.taoren);
        fruitList.add(taoren);
        Fruit taozi = new Fruit("桃子",R.drawable.taozi);
        fruitList.add(taozi);
        Fruit tiangua = new Fruit("甜瓜",R.drawable.tiangua);
        fruitList.add(tiangua);
        Fruit wumei = new Fruit("乌梅",R.drawable.wumei);
        fruitList.add(wumei);
        Fruit wuhuaguo = new Fruit("无花果",R.drawable.wuhuaguo);
        fruitList.add(wuhuaguo);
        Fruit xigua = new Fruit("西瓜",R.drawable.xigua);
        fruitList.add(xigua);
        Fruit xiguazi = new Fruit("西瓜子",R.drawable.xiguazi);
        fruitList.add(xiguazi);
        Fruit ximei = new Fruit("西梅",R.drawable.ximei);
        fruitList.add(ximei);
        Fruit xiangjiao = new Fruit("香蕉",R.drawable.xiangjiao);
        fruitList.add(xiangjiao);
        Fruit xingren = new Fruit("杏仁",R.drawable.xingren);
        fruitList.add(xingren);
        Fruit xing = new Fruit("杏",R.drawable.xing);
        fruitList.add(xing);
        Fruit yangmei = new Fruit("杨梅",R.drawable.yangmei);
        fruitList.add(yangmei);
        Fruit yaoguo = new Fruit("腰果",R.drawable.yaoguo);
        fruitList.add(yaoguo);
        Fruit yezi = new Fruit("椰子",R.drawable.yezi);
        fruitList.add(yezi);
        Fruit yizhi = new Fruit("益智",R.drawable.yizhi);
        fruitList.add(yizhi);
        Fruit yinxingren = new Fruit("银杏仁",R.drawable.yinxingren);
        fruitList.add(yinxingren);
        Fruit yingtao = new Fruit("樱桃",R.drawable.yingtao);
        fruitList.add(yingtao);
        Fruit youtao = new Fruit("油桃",R.drawable.youtao);
        fruitList.add(youtao);
        Fruit youzi = new Fruit("柚子",R.drawable.youzi);
        fruitList.add(youzi);
    /*    */
        Fruit zhenzi = new Fruit("榛子",R.drawable.zhenzi);
        fruitList.add(zhenzi);
    }

    private void initshuichan() {
        Fruit bayu = new Fruit("鲅鱼",R.drawable.bayu);
        fruitList.add(bayu);
        Fruit baoyu = new Fruit("鲍鱼",R.drawable.baoyu);
        fruitList.add(baoyu);
        Fruit bianyu = new Fruit("鳊鱼",R.drawable.bianyu);
        fruitList.add(bianyu);
        Fruit canyong = new Fruit("蚕蛹",R.drawable.canyong);
        fruitList.add(canyong);
        Fruit caoyu = new Fruit("草鱼",R.drawable.caoyu);
        fruitList.add(caoyu);
        Fruit caozi = new Fruit("蛏子",R.drawable.caozi);
        fruitList.add(caozi);
        Fruit chuanbei = new Fruit("川贝",R.drawable.chuanbei);
        fruitList.add(chuanbei);
        Fruit dazhaxie = new Fruit("大闸蟹",R.drawable.dazhaxie);
        fruitList.add(dazhaxie);
        Fruit daiyu = new Fruit("带鱼",R.drawable.daiyu);
        fruitList.add(daiyu);
        Fruit dancai = new Fruit("淡菜",R.drawable.dancai);
        fruitList.add(dancai);
        Fruit daoyu = new Fruit("刀鱼",R.drawable.daoyu);
        fruitList.add(daoyu);
        Fruit diwangxie = new Fruit("帝王蟹 ",R.drawable.diwangxie);
        fruitList.add(diwangxie);
        Fruit duobaoyu = new Fruit("多宝鱼",R.drawable.duobaoyu);
        fruitList.add(duobaoyu);
        Fruit fengweiyu = new Fruit("凤尾鱼",R.drawable.fengweiyu);
        fruitList.add(fengweiyu);
        Fruit ganbei = new Fruit("干贝",R.drawable.ganbei);
        fruitList.add(ganbei);
        Fruit geli = new Fruit("蛤蛎",R.drawable.geli);
        fruitList.add(geli);
        Fruit guiyu = new Fruit("桂鱼",R.drawable.guiyu);
        fruitList.add(guiyu);
        Fruit haishen = new Fruit("海参",R.drawable.haishen);
        fruitList.add(haishen);
        Fruit haidai = new Fruit("海带",R.drawable.haidai);
        fruitList.add(haidai);
        Fruit haidan = new Fruit("海胆",R.drawable.haidan);
        fruitList.add(haidan);
        Fruit haijinsha = new Fruit("海金沙",R.drawable.haijinsha);
        fruitList.add(haijinsha);
        Fruit hailong = new Fruit("海龙",R.drawable.hailong);
        fruitList.add(hailong);
        Fruit haima = new Fruit("海马",R.drawable.haima);
        fruitList.add(haima);
        Fruit haibiaoqiao = new Fruit("海螵蛸",R.drawable.haibiaoqiao);
        fruitList.add(haibiaoqiao);
        Fruit haitai = new Fruit("海苔",R.drawable.haitai);
        fruitList.add(haitai);
       /* Fruit haixia = new Fruit("海虾",R.drawable.haixia);
        fruitList.add(haixia);
        Fruit haixie = new Fruit("海蟹",R.drawable.haixie);
        fruitList.add(haixie);*/
        Fruit haixing = new Fruit("海星",R.drawable.haixing);
        fruitList.add(haixing);
        Fruit haizao = new Fruit("海藻",R.drawable.haizao);
        fruitList.add(haizao);
        Fruit haizhe = new Fruit("海蜇 ",R.drawable.haizhe);
        fruitList.add(haizhe);
        Fruit hebang = new Fruit("河蚌",R.drawable.hebang);
        fruitList.add(hebang);
        Fruit hexia = new Fruit("河虾",R.drawable.hexia);
        fruitList.add(hexia);
        Fruit hexian = new Fruit("河蚬",R.drawable.hexian);
        fruitList.add(hexian);
        Fruit heiyu = new Fruit("黑鱼",R.drawable.heiyu);
        fruitList.add(heiyu);
        Fruit hongzunyu = new Fruit("虹鳟鱼",R.drawable.hongzunyu);
        fruitList.add(hongzunyu);
        Fruit huangshan = new Fruit("黄鳝",R.drawable.huangshan);
        fruitList.add(huangshan);
        Fruit jiyu = new Fruit("鲫鱼",R.drawable.jiyu);
        fruitList.add(jiyu);
        Fruit jiayu = new Fruit("甲鱼",R.drawable.jiayu);
        fruitList.add(jiayu);

        Fruit haixia = new Fruit("皮皮虾",R.drawable.pipixia);
        fruitList.add(haixia);

        Fruit liyu = new Fruit("鲤鱼",R.drawable.liyu);
        fruitList.add(liyu);
        Fruit lianyu = new Fruit("鲢鱼",R.drawable.lianyu);
        fruitList.add(lianyu);
        Fruit longxia = new Fruit("龙虾",R.drawable.longxia);
        fruitList.add(longxia);
        Fruit luyu = new Fruit("鲈鱼",R.drawable.luyu);
        fruitList.add(luyu);
        Fruit luofeiyu = new Fruit("罗非鱼",R.drawable.luofeiyu);
        fruitList.add(luofeiyu);
        Fruit manyu = new Fruit("鳗鱼",R.drawable.manyu);
        fruitList.add(manyu);
        Fruit moyu = new Fruit("墨鱼",R.drawable.moyu);
        fruitList.add(moyu);
        Fruit muli = new Fruit("牡蛎",R.drawable.muli);
        fruitList.add(muli);
        Fruit niqiu = new Fruit("泥鳅",R.drawable.niqiu);
        fruitList.add(niqiu);
        Fruit nianyu = new Fruit("鲶鱼",R.drawable.nianyu);
        fruitList.add(nianyu);
        Fruit pangxie = new Fruit("螃蟹",R.drawable.pangxie);
        fruitList.add(pangxie);
        Fruit qingyu = new Fruit("青鱼",R.drawable.qingyu);
        fruitList.add(qingyu);
       /* Fruit pipixia = new Fruit("皮皮虾",R.drawable.pipixia);
        fruitList.add(pipixia);
        */
        Fruit qiudaoyu = new Fruit("秋刀鱼",R.drawable.qiudaoyu);
        fruitList.add(qiudaoyu);
        Fruit sanwenyu = new Fruit("三文鱼",R.drawable.sanwenyu);
        fruitList.add(sanwenyu);
        Fruit shadingyu = new Fruit("沙丁鱼",R.drawable.shadingyu);
        fruitList.add(shadingyu);

       Fruit haixie = new Fruit("梭子蟹",R.drawable.suozixie);
        fruitList.add(haixie);

        Fruit wawayu = new Fruit("娃娃鱼",R.drawable.wawayu);
        fruitList.add(wawayu);
        Fruit xia = new Fruit("虾",R.drawable.xia);
        fruitList.add(xia);
        Fruit xiapi = new Fruit("虾皮",R.drawable.xiapi);
        fruitList.add(xiapi);
        Fruit xiaren = new Fruit("虾仁 ",R.drawable.xiaren);
        fruitList.add(xiaren);
        Fruit xueyu = new Fruit("鳕鱼",R.drawable.xueyu);
        fruitList.add(xueyu);
        Fruit xunyu = new Fruit("鲟鱼",R.drawable.xunyu);
        fruitList.add(xunyu);
        Fruit yinyu = new Fruit("银鱼",R.drawable.yinyu);
        fruitList.add(yinyu);
        Fruit  youyu = new Fruit("鱿鱼",R.drawable.youyu);
        fruitList.add( youyu);
        Fruit yuzi = new Fruit("鱼籽",R.drawable.yuzi);
        fruitList.add(yuzi);
        Fruit zhangyu = new Fruit("章鱼",R.drawable.zhangyu);
        fruitList.add(zhangyu);
        Fruit zhebei = new Fruit("浙贝",R.drawable.zhebei);
        fruitList.add(zhebei);
        Fruit zicai = new Fruit("紫菜",R.drawable.zicai);
        fruitList.add(zicai);

    }

    private void initdounairu() {
        Fruit anchundan = new Fruit("鹌鹑蛋",R.drawable.anchundan);
        fruitList.add(anchundan);
        Fruit cudanye = new Fruit("醋蛋液",R.drawable.cudanye);
        fruitList.add(cudanye);
        Fruit doujiang = new Fruit("豆浆",R.drawable.doujiang);
        fruitList.add(doujiang);
        Fruit edan = new Fruit("鹅蛋",R.drawable.edan);
        fruitList.add(edan);
        Fruit jidan = new Fruit("鸡蛋",R.drawable.jidan);
        fruitList.add(jidan);
        Fruit jidanhuang = new Fruit("鸡蛋黄",R.drawable.jidanhuang);
        fruitList.add(jidanhuang);
        Fruit niunai = new Fruit("牛奶",R.drawable.niunai);
        fruitList.add(niunai);
        Fruit pidan = new Fruit("皮蛋",R.drawable.pidan);
        fruitList.add(pidan);
        Fruit suannai = new Fruit("酸奶",R.drawable.suannai);
        fruitList.add(suannai);
        Fruit xianyadan = new Fruit("咸鸭蛋",R.drawable.xianyadan);
        fruitList.add(xianyadan);
        Fruit yadan = new Fruit("鸭蛋",R.drawable.yadan);
        fruitList.add(yadan);
        Fruit yangdan = new Fruit("羊蛋",R.drawable.yangdan);
        fruitList.add(yangdan);
        Fruit yangnai = new Fruit("羊奶",R.drawable.yangnai);
        fruitList.add(yangnai);

    }

    private void initgandou() {
      /*  Fruit biandou = new Fruit("扁豆", R.drawable.biandou);
        fruitList.add(biandou);*/
        Fruit candou = new Fruit("蚕豆", R.drawable.candou);
        fruitList.add(candou);
        Fruit daodou = new Fruit("刀豆", R.drawable.daodou);
        fruitList.add(daodou);
        Fruit doufu = new Fruit("豆腐", R.drawable.doufu);
        fruitList.add(doufu);
        Fruit fuzhu = new Fruit("腐竹", R.drawable.fuzhu);
        fruitList.add(fuzhu);
        Fruit heidou = new Fruit("黑豆", R.drawable.heidou);
        fruitList.add(heidou);
        Fruit honhdou = new Fruit("红豆", R.drawable.honhdou);
        fruitList.add(honhdou);
        Fruit huangdou = new Fruit("黄豆", R.drawable.huangdou);
        fruitList.add(huangdou);
        Fruit huangdoufen = new Fruit("黄豆粉", R.drawable.huangdoufen);
        fruitList.add(huangdoufen);
        Fruit lvdou = new Fruit("绿豆", R.drawable.lvdou);
        fruitList.add(lvdou);
        Fruit maodou = new Fruit("毛豆", R.drawable.maodou);
        fruitList.add(maodou);
        Fruit meidou = new Fruit("眉豆", R.drawable.meidou);
        fruitList.add(meidou);
        Fruit nadou = new Fruit("纳豆", R.drawable.nadou);
        fruitList.add(nadou);
        Fruit wandou = new Fruit("豌豆", R.drawable.wandou);
        fruitList.add(wandou);
       /* Fruit yundou = new Fruit("芸豆", R.drawable.yundou);
        fruitList.add(yundou);*/
    }

    private void initshucai() {
       /* */
        Fruit bocai = new Fruit("菠菜",R.drawable.bocai);
        fruitList.add(bocai);
        Fruit caihua = new Fruit("菜花",R.drawable.caihua);
        fruitList.add(caihua);
        Fruit caogu = new Fruit("草菇",R.drawable.caogu);
        fruitList.add(caogu);
        Fruit chashugu = new Fruit("茶树菇",R.drawable.chashugu);
        fruitList.add(chashugu);
        Fruit chuncai = new Fruit("莼菜",R.drawable.chuncai);
        fruitList.add(chuncai);
        Fruit cigu = new Fruit("慈菇",R.drawable.cigu);
        fruitList.add(cigu);
        Fruit baicai = new Fruit("白菜",R.drawable.baicai);
        fruitList.add(baicai);
        Fruit donggua = new Fruit("冬瓜",R.drawable.donggua);
        fruitList.add(donggua);
        Fruit donghancai = new Fruit("冬寒菜",R.drawable.donghancai);
        fruitList.add(donghancai);
        Fruit douya = new Fruit("豆芽",R.drawable.douya);
        fruitList.add(douya);
        Fruit facai = new Fruit("发菜",R.drawable.facai);
        fruitList.add(facai);
        Fruit fanqie = new Fruit("番茄 ",R.drawable.fanqie);
        fruitList.add(fanqie);
        Fruit fenge = new Fruit("粉葛",R.drawable.fenge);
        fruitList.add(fenge);
        Fruit foshougua = new Fruit("佛手瓜",R.drawable.foshougua);
        fruitList.add(foshougua);
        Fruit fuling = new Fruit("茯苓",R.drawable.fuling);
        fruitList.add(fuling);
        Fruit heshouwu = new Fruit("何首乌",R.drawable.heshouwu);
        fruitList.add(heshouwu);
        Fruit honggu = new Fruit("红菇",R.drawable.honggu);
        fruitList.add(honggu);
        Fruit hongshu = new Fruit("红薯",R.drawable.hongshu);
        fruitList.add(hongshu);
        Fruit houtougu = new Fruit("猴头菇",R.drawable.houtougu);
        fruitList.add(houtougu);
        Fruit huluobo = new Fruit("胡萝卜",R.drawable.huluobo);
        fruitList.add(huluobo);
        Fruit huanggua = new Fruit("黄瓜",R.drawable.huanggua);
        fruitList.add(huanggua);
        Fruit huanghuacai = new Fruit("黄花菜",R.drawable.huanghuacai);
        fruitList.add(huanghuacai);
        Fruit huixiang = new Fruit("茴香",R.drawable.huixiang);
        fruitList.add(huixiang);
        Fruit huoxiang = new Fruit("藿香",R.drawable.huoxiang);
        fruitList.add(huoxiang);
        Fruit jizongjun = new Fruit("鸡枞菌",R.drawable.jizongjun);
        fruitList.add(jizongjun);

        Fruit jimaocai = new Fruit("鸡毛菜",R.drawable.jimaocai);
        fruitList.add(jimaocai);

        Fruit jiaobai = new Fruit("茭白",R.drawable.jiaobai);
        fruitList.add(jiaobai);
        Fruit jinzhengu = new Fruit("金针菇",R.drawable.jinzhengu);
        fruitList.add(jinzhengu);
        Fruit jiucai = new Fruit("韭菜",R.drawable.jiucai);
        fruitList.add(jiucai);
        Fruit juecai = new Fruit("蕨菜",R.drawable.juecai);
        fruitList.add(juecai);
        Fruit kongxincai = new Fruit("空心菜 ",R.drawable.kongxincai);
        fruitList.add(kongxincai);
        Fruit kucai = new Fruit("苦菜",R.drawable.kucai);
        fruitList.add(kucai);
        Fruit kugua = new Fruit("苦瓜",R.drawable.kugua);
        fruitList.add(kugua);
        Fruit lajiao = new Fruit("辣椒",R.drawable.lajiao);
        fruitList.add(lajiao);
        Fruit lianou = new Fruit("莲藕",R.drawable.lianou);
        fruitList.add(lianou);
        Fruit liangshu = new Fruit("凉薯",R.drawable.liangshu);
        fruitList.add(liangshu);
        Fruit luhao = new Fruit("芦蒿",R.drawable.luhao);
        fruitList.add(luhao);
        Fruit lusun = new Fruit("芦笋",R.drawable.lusun);
        fruitList.add(lusun);
        Fruit luobo = new Fruit("萝卜",R.drawable.luobo);
        fruitList.add(luobo);
        Fruit luoboye = new Fruit("萝卜叶",R.drawable.luoboye);
        fruitList.add(luoboye);
        Fruit luoxuanzao = new Fruit("螺旋藻",R.drawable.luoxuanzao);
        fruitList.add(luoxuanzao);
        Fruit machimi = new Fruit("马齿觅",R.drawable.machimi);
        fruitList.add(machimi);
       /* */
        Fruit mogu = new Fruit("蘑菇 ",R.drawable.mogu);
        fruitList.add(mogu);
        Fruit muer = new Fruit("木耳",R.drawable.muer);
        fruitList.add(muer);
        Fruit mushu = new Fruit("木薯",R.drawable.mushu);
        fruitList.add(mushu);
        Fruit muxu = new Fruit("苜蓿",R.drawable.muxu);
        fruitList.add(muxu);
        Fruit nangua = new Fruit("南瓜",R.drawable.nangua);
        fruitList.add(nangua);
        Fruit pinggu = new Fruit("平菇",R.drawable.pinggu);
        fruitList.add(pinggu);
        Fruit pucai = new Fruit("浦菜",R.drawable.pucai);
        fruitList.add(pucai);
        Fruit pugongying = new Fruit("蒲公英",R.drawable.pugongying);
        fruitList.add(pugongying);
        Fruit jiecai = new Fruit("芥菜",R.drawable.jiecai);
        fruitList.add(jiecai);
        Fruit qiezi = new Fruit("茄子",R.drawable.qiezi);
        fruitList.add(qiezi);
       /* Fruit qiudaoyu = new Fruit("秋刀鱼",R.drawable.qiudaoyu);
        fruitList.add(qiudaoyu);
        */
        Fruit qincai = new Fruit("芹菜",R.drawable.qincai);
        fruitList.add(qincai);
        Fruit qingjiao = new Fruit("青椒",R.drawable.qingjiao);
        fruitList.add(qingjiao);
        Fruit shanyao = new Fruit("山药",R.drawable.shanyao);
        fruitList.add(shanyao);
        Fruit shengcai = new Fruit("生菜",R.drawable.shengcai);
        fruitList.add(shengcai);
        Fruit shier = new Fruit("石耳 ",R.drawable.shier);
        fruitList.add(shier);
        Fruit shihuacai = new Fruit("石花菜",R.drawable.shihuacai);
        fruitList.add(shihuacai);
        Fruit sigua = new Fruit("丝瓜",R.drawable.sigua);
        fruitList.add(sigua);
        Fruit songmo = new Fruit("松蘑",R.drawable.songmo);
        fruitList.add(songmo);
        Fruit  suantai = new Fruit("蒜苔",R.drawable.suantai);
        fruitList.add( suantai);
        Fruit tiancai = new Fruit("甜菜",R.drawable.tiancai);
        fruitList.add(tiancai);
        Fruit malingshu = new Fruit("马铃薯",R.drawable.malingshu);
        fruitList.add(malingshu);
        Fruit waitoucai = new Fruit("歪头菜 ",R.drawable.waitoucai);
        fruitList.add(waitoucai);
        Fruit woju = new Fruit("莴苣",R.drawable.woju);
        fruitList.add(woju);
        Fruit xihulu = new Fruit("西葫芦",R.drawable.xihulu);
        fruitList.add(xihulu);
        Fruit xiyangcai = new Fruit("西洋菜",R.drawable.xiyangcai);
        fruitList.add(xiyangcai);
        Fruit xiancai = new Fruit("苋菜",R.drawable.xiancai);
        fruitList.add(xiancai);
        Fruit xiangcai = new Fruit("香菜",R.drawable.xiangcai);
        fruitList.add(xiangcai);
        Fruit xiangchun = new Fruit("香椿",R.drawable.xiangchun);
        fruitList.add(xiangchun);
        Fruit xianggu = new Fruit("香菇",R.drawable.xianggu);
        fruitList.add(xianggu);
        /*Fruit xiaobaicai = new Fruit("小白菜",R.drawable.xiaobaicai);
        fruitList.add(xiaobaicai);*/
        Fruit xinbai = new Fruit("薤白",R.drawable.xinbai);
        fruitList.add(xinbai);
        Fruit xingbaogu = new Fruit("杏鲍菇",R.drawable.xingbaogu);
        fruitList.add(xingbaogu);
        Fruit yangcong = new Fruit("洋葱",R.drawable.yangcong);
        fruitList.add(yangcong);
        Fruit junchen = new Fruit("菌陈",R.drawable.junchen);
        fruitList.add(junchen);
        Fruit yiner = new Fruit("银耳",R.drawable.yiner);
        fruitList.add(yiner);
        Fruit yuxingcao = new Fruit("鱼腥草",R.drawable.yuxingcao);
        fruitList.add(yuxingcao);
        Fruit yutou = new Fruit("芋头",R.drawable.yutou);
        fruitList.add(yutou);
        Fruit zhusun = new Fruit("竹荪",R.drawable.zhusun);
        fruitList.add(zhusun);
        Fruit zhusun1 = new Fruit("竹笋",R.drawable.zhusun1);
        fruitList.add(zhusun1);
        Fruit zicai = new Fruit("紫菜",R.drawable.zicai);
        fruitList.add(zicai);

        Fruit zishu = new Fruit("紫薯",R.drawable.zishu);
        fruitList.add(zishu);

    }

    private void initguwu() {

        Fruit caomi = new Fruit("糙米",R.drawable.caomi);
        fruitList.add(caomi);
        Fruit damai = new Fruit("大麦",R.drawable.damai);
        fruitList.add(damai);
       /* Fruit gaoliangmi = new Fruit("高粱米",R.drawable.gaoliangmi);
        fruitList.add(gaoliangmi);*/
        Fruit heimi = new Fruit("黑米",R.drawable.heimi);
        fruitList.add(heimi);
        Fruit jingmi = new Fruit("粳米",R.drawable.jingmi);
        fruitList.add(jingmi);
        Fruit maiya = new Fruit("麦芽",R.drawable.maiya);
        fruitList.add(maiya);
        Fruit mian = new Fruit("面",R.drawable.mian);
        fruitList.add(mian);
        Fruit nuomi = new Fruit("糯米",R.drawable.nuomi);
        fruitList.add(nuomi);
        Fruit qiaomai = new Fruit("荞麦",R.drawable.qiaomai);
        fruitList.add(qiaomai);
        Fruit canmi = new Fruit("灿米",R.drawable.canmi);
        fruitList.add(canmi);
        Fruit xiaomai = new Fruit("小麦",R.drawable.xiaomai);
        fruitList.add(xiaomai);
        Fruit xiaomi = new Fruit("小米",R.drawable.xiaomi);
        fruitList.add(xiaomi);
        Fruit yanmai = new Fruit("燕麦",R.drawable.yanmai);
        fruitList.add(yanmai);
        Fruit yirenmi = new Fruit("薏仁米",R.drawable.yirenmi);
        fruitList.add(yirenmi);
        Fruit yumi = new Fruit("玉米",R.drawable.yumi);
        fruitList.add(yumi);
    }

    private void initqinchu() {
        Fruit dilong = new Fruit("蚯蚓",R.drawable.qiuyin);
        fruitList.add(dilong);

        Fruit egan = new Fruit("鹅肝",R.drawable.egan);
        fruitList.add(egan);

        Fruit erou = new Fruit("鹅肉",R.drawable.erou);
        fruitList.add(erou);
        Fruit gerou = new Fruit("鸽肉",R.drawable.gerou);
        fruitList.add(gerou);
        Fruit gouji = new Fruit("狗脊",R.drawable.gouji);
        fruitList.add(gouji);
        Fruit gourou = new Fruit("狗肉",R.drawable.gourou);
        fruitList.add(gourou);
        Fruit jigan = new Fruit("鸡肝",R.drawable.jigan);
        fruitList.add(jigan);
        Fruit jirou = new Fruit("鸡肉",R.drawable.jirou);
        fruitList.add(jirou);
        Fruit jixin = new Fruit("鸡心",R.drawable.jixin);
        fruitList.add(jixin);
        Fruit jixue = new Fruit("鸡血",R.drawable.jixue);
        fruitList.add(jixue);
        Fruit lvrou = new Fruit("驴肉",R.drawable.lvrou);
        fruitList.add(lvrou);
        Fruit marou = new Fruit("马肉",R.drawable.marou);
        fruitList.add(marou);
        Fruit niubian = new Fruit("牛鞭",R.drawable.niubian);
        fruitList.add(niubian);
        Fruit niudu = new Fruit("牛肚",R.drawable.niudu);
        fruitList.add(niudu);
        Fruit niugan = new Fruit("牛肝",R.drawable.niugan);
        fruitList.add(niugan);
        Fruit niurou = new Fruit("牛肉",R.drawable.niurou);
        fruitList.add(niurou);
        Fruit niuxin = new Fruit("牛心",R.drawable.niuxin);
        fruitList.add(niuxin);
        /*Fruit qiuyin = new Fruit("蚯蚓",R.drawable.qiuyin);
        fruitList.add(qiuyin);*/
        Fruit tianji = new Fruit("田鸡",R.drawable.tianji);
        fruitList.add(tianji);
        Fruit turou = new Fruit("兔肉",R.drawable.turou);
        fruitList.add(turou);
        Fruit wuji1 = new Fruit("乌鸡",R.drawable.wuji);
        fruitList.add(wuji1);

        Fruit egan1 = new Fruit("鸭肝",R.drawable.yagan);
        fruitList.add(egan1);

        Fruit yarou = new Fruit("鸭肉",R.drawable.yarou);
        fruitList.add(yarou);
        Fruit yaxue = new Fruit("鸭血",R.drawable.yaxue);
        fruitList.add(yaxue);
         Fruit yanwo = new Fruit("燕窝",R.drawable.yanwo);
        fruitList.add(yanwo);
        Fruit yangbian = new Fruit("羊鞭",R.drawable.yangbian);
        fruitList.add(yangbian);
        Fruit yangdu = new Fruit("羊肚",R.drawable.yangdu);
        fruitList.add(yangdu);
        Fruit yangfei = new Fruit("羊肺",R.drawable.yangfei);
        fruitList.add(yangfei);
        Fruit yanggan = new Fruit("羊肝",R.drawable.yanggan);
        fruitList.add(yanggan);
        Fruit yangrou = new Fruit("羊肉",R.drawable.yangrou);
        fruitList.add(yangrou);
        Fruit yangshen = new Fruit("羊肾",R.drawable.yangshen);
        fruitList.add(yangshen);
        Fruit yangxin = new Fruit("羊心",R.drawable.yangxin);
        fruitList.add(yangxin);
        Fruit yangxue = new Fruit("羊血",R.drawable.yangxue);
        fruitList.add(yangxue);
        Fruit zhudu = new Fruit("猪肚",R.drawable.zhudu);
        fruitList.add(zhudu);
        Fruit zhufei = new Fruit("猪肺",R.drawable.zhufei);
        fruitList.add(zhufei);
        Fruit zhugan = new Fruit("猪肝",R.drawable.zhugan);
        fruitList.add(zhugan);
        Fruit zhunao = new Fruit("猪脑",R.drawable.zhunao);
        fruitList.add(zhunao);
        Fruit zhupi = new Fruit("猪皮",R.drawable.zhupi);
        fruitList.add(zhupi);
        Fruit zhurou = new Fruit("猪肉",R.drawable.zhurou);
        fruitList.add(zhurou);
        Fruit zhuti = new Fruit("猪蹄",R.drawable.zhuti);
        fruitList.add(zhuti);
        Fruit zhuxin = new Fruit("猪心",R.drawable.zhuxin);
        fruitList.add(zhuxin);
        Fruit zhuxue = new Fruit("猪血",R.drawable.zhuxue);
        fruitList.add(zhuxue);
        Fruit zhuyao = new Fruit("猪腰",R.drawable.zhuyao);
        fruitList.add(zhuyao);


    }

    private void Data(String url) {
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(FoodListActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                try {
                    fruitList2.clear();
                    Log.e("Test",Url);
                    String responseData = response.body().string();
                    JSONArray jsonArray = new JSONArray(responseData);
                    Fruit2 fruit2;
                    String name,content_url,iconUrl,kind;
                    if (jsonArray.length()==0){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(FoodListActivity.this,"未找到此类食品",Toast.LENGTH_SHORT).show();
                            }
                        });

                    }else {
                        for (int i =0;i<jsonArray.length();i++){
                            JSONObject jsonObject =   jsonArray.getJSONObject(i);
                            name = jsonObject.getString("name");
                            content_url = jsonObject.getString("content_url");
                            iconUrl = jsonObject.getString("iconUrl");
                            kind = jsonObject.getString("kind");
                            Log.e("Json",name+"::"+content_url+"::"+iconUrl);
                            fruit2 = new Fruit2(name,iconUrl,content_url,kind);
                            fruitList2.add(fruit2);
                        }
                        Log.e("Next","!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        Log.e("aaaaaa", fruitList2.get(0).getIconUrl());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter2 = new Fruit2Adapter(FoodListActivity.this,R.layout.foot_list,fruitList2);
                                ListView listView8 = (ListView) findViewById(R.id.list_view);
                                listView8.setAdapter(adapter2);
                            }
                        });


                    }
             /*       runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                          adapter2.notifyDataSetChanged();
                        }
                    });*/
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
