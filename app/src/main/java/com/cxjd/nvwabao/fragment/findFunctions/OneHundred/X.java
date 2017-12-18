package com.cxjd.nvwabao.fragment.findFunctions.OneHundred;

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

/**
 * 100种病症不宜食物  --  X
 */
public class X extends Fragment {

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
    GridLayout gridLayout10;


    //定义网格中的数据
    String[] x1 = new String[]{
            "碳酸饮料","矿物质水","浓茶","油炸食品","动物油","蛋黄","蟹黄"
    };

    String[] x2 = new String[]{
            "鱼类","鸡蛋","糖","胡椒","鱼肝油","松花蛋蛋黄","蟹黄","鱼子","西瓜","冷饮","乌梅"
    };

    String[]  x3 = new String[]{
            "冬瓜","绿豆","黄瓜","苦瓜","冷饮","辣椒","山楂","草莓","柠檬","菠萝","石榴","柿子","香瓜","橙子","桑葚","橄榄"
    };

    String[] x4 = new String[]{
            "牛肉","羊肉","芋头","芡实","葱","生姜","大蒜","辣椒","芥末","花椒","海鲜","禽肉","花粉"
    };

    String[] x5 = new String[]{
            "汤品","粥品","豆浆","西瓜","梨","薏米","玉米","红豆","西瓜","鲤鱼","咸菜","豆瓣酱","咸肉","巧克力","糖果"
    };

    String[] x6 = new String[]{
            "咖啡","酒冷饮","浓茶"
    };

    String[] x7 = new String[]{
            "葱","辣椒","韭菜","生姜","胡椒","咖喱","带鱼","黄鱼","平鱼","蚌肉","虾","螃蟹","烈酒"
    };

    String[]  x8 = new String[]{
            "虾","螃蟹","蚌肉","沙丁鱼","黄鱼","鳗鱼","鳝鱼","带鱼","甲鱼","禽肉","羊肉","牛肉","蘑菇","辛辣调料","板栗","醋","酒","花生酱","牛奶","玉米","大麦","荞麦","蚕豆","土豆"
    };

    String[] x9 = new String[]{
            "海鲜","肥肉","甲鱼","高粱","红薯","燕麦","蚕豆","青豆","芹菜","韭菜","毛豆","芋头","糯米","饮料","凉拌菜"
    };

    String[] x10 = new String[]{
            "羊肉","狗肉","牛肉","荔枝","杨梅","辣椒","花椒","胡椒","麻椒","丁香","茴香","胖头鱼","黄鱼","白酒","黄酒","葱","生姜","大蒜","韭菜","韭黄","洋葱","萝卜"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_x,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_x_1);
        gridLayout2 = view.findViewById(R.id.onehundred_x_2);
        gridLayout3 = view.findViewById(R.id.onehundred_x_3);
        gridLayout4 = view.findViewById(R.id.onehundred_x_4);
        gridLayout5 = view.findViewById(R.id.onehundred_x_5);
        gridLayout6 = view.findViewById(R.id.onehundred_x_6);
        gridLayout7 = view.findViewById(R.id.onehundred_x_7);
        gridLayout8 = view.findViewById(R.id.onehundred_x_8);
        gridLayout9 = view.findViewById(R.id.onehundred_x_9);
        gridLayout10 = view.findViewById(R.id.onehundred_x_10);

        //调用网格初始化方法
        initGridLayout(gridLayout1,x1);
        initGridLayout(gridLayout2,x2);
        initGridLayout(gridLayout3,x3);
        initGridLayout(gridLayout4,x4);
        initGridLayout(gridLayout5,x5);
        initGridLayout(gridLayout6,x6);
        initGridLayout(gridLayout7,x7);
        initGridLayout(gridLayout8,x8);
        initGridLayout(gridLayout9,x9);
        initGridLayout(gridLayout10,x10);

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
            textView.setBackground(getResources().getDrawable(R.drawable.one_hundred_gridlayout_backgroud));
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
