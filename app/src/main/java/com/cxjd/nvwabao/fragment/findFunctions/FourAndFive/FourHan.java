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


public class FourHan extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout6;
    GridLayout gridLayout7;
    GridLayout gridLayout8;
    GridLayout gridLayout9;



    //定义网格中的数据
    String[] shucai = new String[]{
            "茄子", "蕹菜", "生藕", "芦荟", "生苦瓜","蕨根粉",
            "蕨菜", "马齿苋", "莼菜", "百合", "丝瓜", "荸荠",
            "鱼腥草", "木耳菜", "江蓠", "仙人掌", "菜瓜", "空心菜",
            "苦菜", "葵菜", "睡菜", "黄鹌菜", "瓠瓜", "榆钱",
            "羊栖菜", "芝麻叶", "蒲公英", "发菜", "车前草"
    };

    String[] shuiguo = new String[]{
            "西瓜", "香瓜", "杨桃", "柿饼", "柿子", "甘蔗",
            "柚子", "猕猴桃", "梨子", "桑葚", "香蕉", "哈密瓜"
    };

    String[]  jundou = new String[]{
            "黄豆芽", "绿豆芽", "草菇", "慈姑"
    };

    String[] rouqindan = new String[]{
            "松花蛋", "马肉", "蜗牛", "鸭血", "獭肉"
    };

    String[] shuichan = new String[]{
            "海藻", "田螺", "海带", "紫菜", "螃蟹", "蛤蜊",
            "章鱼", "石花菜", "乌鱼", "蚌肉", "蛏子", "螺蛳",
            "泥螺", "牡蛎", "蚬肉"
    };

    String[] yinpin = new String[]{
            "甘蔗汁", "西瓜汁", "香瓜汁", "梨汁", "哈密瓜汁", "猕猴桃汁",
            "番泻叶茶", "苦丁茶", "金莲花茶", "绞股蓝茶", "栀子花茶", "蝴蝶茶"
    };

    String[] tiaoweipin = new String[]{
            "豆豉", "盐", "面酱", "酱油"
    };

    String[] zhongyao = new String[]{
            "柴胡", "栀子", "牡丹皮", "珍珠", "麦门冬", "天门冬",
            "芦根", "夏枯草", "石斛", "大黄", "金铃子", "白茅根",
            "羚羊角", "犀牛角", "海藻", "黄柏", "熟地黄", "黄连"
    } ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four_han,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.han_shucai);
        gridLayout2 = view.findViewById(R.id.han_shuiguo);
        gridLayout3 = view.findViewById(R.id.han_jundou);
        gridLayout4 = view.findViewById(R.id.han_rouqindan);
        gridLayout6 = view.findViewById(R.id.han_shuichan);
        gridLayout7 = view.findViewById(R.id.han_yinpin);
        gridLayout8 = view.findViewById(R.id.han_tiaowei);
        gridLayout9 = view.findViewById(R.id.han_zhongyaocai);

        //调用网格初始化方法
        initGridLayout(gridLayout1,shucai);
        initGridLayout(gridLayout2,shuiguo);
        initGridLayout(gridLayout3,jundou);
        initGridLayout(gridLayout4,rouqindan);
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
