package com.cxjd.nvwabao.fragment.findFunctions.FourAndFive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.cxjd.nvwabao.R;

public class FiveGan extends Fragment {
    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;
    GridLayout gridLayout6;
    GridLayout gridLayout7;
    GridLayout gridLayout8;
    GridLayout gridLayout9;



    //定义网格中的数据
    String[] shucai = new String[]{
            "茄子", "西蓝花", "香椿", "菜花", "荠菜", "佛手瓜",
           "苋菜", "芥蓝", "菠菜", "荷蒿", "油菜", "空心菜",
            "芋头", "芹菜", "茭白", "胡萝卜", "白萝卜", "山药",
            "土豆", "刀豆", "红薯 ", "莲藕", "百合", "荸荠",
            "竹笋", "绿豆芽", "豇豆", "芦笋", "黄瓜", "丝瓜",
            "冬瓜", "南瓜", "黄豆芽", "四季豆", "黄花菜"
    };

    String[] shuiguo = new String[]{
            "苹果", "甘蔗", "柿子", "西瓜", "哈密瓜", "樱桃",
            "香瓜", "木瓜", "菱角", "香蕉", "桑葚", "荔枝",
            "鲜桂圆", "橘子", "杨梅", "桃", "猕猴桃", "李子",
            "菠萝", "芒果", "火龙果", "草莓", "枇杷"
    };

    String[]  jundou = new String[]{
            "香菇", "平菇", "金针菇", "草菇", "口蘑", "鸡腿菇",
            "茶树菇", "银耳", "木耳", "豌豆", "腐竹", "蚕豆",
            "豆腐"
    };

    String[] rouqindan = new String[]{
            "猪肉", "猪肝", "猪心", "猪肚", "猪肺", "猪血",
            "猪蹄", "狗肉", "牛肉", "牛肝", "羊肉", "羊肝",
            "驴肉", "鸡肉", "鸭肉", "鸡蛋", "鸭蛋", "麻雀",
            "鹅肉", "鸽肉", "鹌鹑肉"
    };

    String[] wuguganguo = new String[]{
            "糯米", "小米", "黑米", "大米", "小麦", "高粱",
            "玉米", "芝麻", "荞麦", "燕麦", "葵花子", "腰果",
            "薏米", "大麦", "松子", "芡实", "开心果", "果类",
            "绿豆", "红豆", "黑豆", "黄豆", "板栗", "莲子",
            "花生", "核桃", "桂圆", "红枣"
    };

    String[] shuichan = new String[]{
            "鳝鱼", "鲈鱼", "鲇鱼", "鲫鱼", "草鱼", "鲤鱼",
            "鲢鱼", "鲍鱼", "海参", "田螺", "刀鱼", "黄花鱼",
            "武昌鱼", "青鱼", "海蜇", "泥鳅", "三文鱼", "鳗鱼",
            "鲳鱼", "甲鱼", "虾", "牡蛎"
    };

    String[] yinpin = new String[]{
            "豆浆", "羊奶", "牛奶", "绿茶", "红茶", "蜂蜜",
            "白酒"
    };

    String[] tiaoweipin = new String[]{
            "饴糖", "红糖", "冰糖", "白糖"
    };

    String[] zhongyao = new String[]{
            "党参", "熟地", "当归", "黄芪", "人参", "肉桂",
            "构杞", "黄精", "麦门冬", "天门冬"
    } ;


@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_five_gan,container,false);

    //寻找gridLayout布局
    gridLayout1 = view.findViewById(R.id.gan_shucai);
    gridLayout2 = view.findViewById(R.id.gan_shuiguo);
    gridLayout3 = view.findViewById(R.id.gan_jundou);
    gridLayout4 = view.findViewById(R.id.gan_rouqindan);
    gridLayout5 = view.findViewById(R.id.gan_wuguganguo);
    gridLayout6 = view.findViewById(R.id.gan_shuichan);
    gridLayout7 = view.findViewById(R.id.gan_yinpin);
    gridLayout8 = view.findViewById(R.id.gan_tiaoweipin);
    gridLayout9 = view.findViewById(R.id.gan_zhongyaocai);

    //调用网格初始化方法
    initGridLayout(gridLayout1,shucai);
    initGridLayout(gridLayout2,shuiguo);
    initGridLayout(gridLayout3,jundou);
    initGridLayout(gridLayout4,rouqindan);
    initGridLayout(gridLayout5,wuguganguo);
    initGridLayout(gridLayout6,shuichan);
    initGridLayout(gridLayout7,yinpin);
    initGridLayout(gridLayout8,tiaoweipin);
    initGridLayout(gridLayout9,zhongyao);

    return view;
}

    /**
     * 为网格布局初始化
     * @param gridLayout   网格布局
     * @param strings  网格中的数据
     */
    private void initGridLayout(GridLayout gridLayout,String[] strings) {

        //为网格赋值
        for(int i=0; i< strings.length; i++){
            TextView textView = new TextView(this.getContext());
            textView.setText(strings[i]);
            //设置字体大小
            textView.setTextSize(15);
            textView.setBackground(getResources().getDrawable(R.drawable.textview_fourandfive_background));
            //居中显示
            textView.setGravity(Gravity.CENTER);
            //指定该组件所在的行
            GridLayout.Spec rowSpec = GridLayout.spec(i / 4);
            //指定该组件所在的列
            GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,columnSpec);
            //指定该组件占满父组件
            params.setGravity(Gravity.FILL);
            gridLayout.addView(textView,params);
        }



    }
}
