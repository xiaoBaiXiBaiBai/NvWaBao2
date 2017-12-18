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
 * 100种病症不宜食物  -- F
 */
public class F extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;
    GridLayout gridLayout6;


    //定义网格中的数据
    String[] f1 = new String[]{
            "肥肉","油炸食品","动物内脏","动物油","蛋黄","蟹黄","葱","生姜","大蒜","芥末","辣椒","桂皮","茴香","白酒","狗肉","羊肉","牛肉","胡椒","韭菜"
    };

    String[] f2 = new String[]{
            "牛肉","羊肉","黄鱼鳝鱼","带鱼","虾","螃蟹","蚌肉","肥肉","动物内脏","黄豆","动物油","蛋糕","冰淇淋","白酒 辣椒","芥末"

            };

    String[]  f3 = new String[]{
            "洋葱","葱","辣椒","生姜","花椒","大料","茴香","白酒","浓茶","咖啡","狗肉","榨菜","桂圆","桂皮","青柿","花粉制品","茄子"

            };

    String[] f4 = new String[]{
            "白酒","浓茶","动物内脏","肥肉","蜂蜜","大蒜","辣椒","冷饮","凉拌菜","人参","虾","咸菜","猪油"
    };

    String[] f5 = new String[]{
            "菠萝","鸡蛋","果冻","火腿","韭菜","苦瓜","辣椒","梨","茄子","芹菜","生菜","丝瓜","石榴","香肠","玉米","芋头","豆腐","大蒜","桑葚","花生"
            };

    String[] f6 = {
            "肥肉","动物油","油炸食品","糖果","糕点","含酒精饮料","巧克力","奶油饼干","油炸花生仁","腰果","葵花子"
            };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_f,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_f_1);
        gridLayout2 = view.findViewById(R.id.onehundred_f_2);
        gridLayout3 = view.findViewById(R.id.onehundred_f_3);
        gridLayout4 = view.findViewById(R.id.onehundred_f_4);
        gridLayout5 = view.findViewById(R.id.onehundred_f_5);
        gridLayout6 = view.findViewById(R.id.onehundred_f_6);

        //调用网格初始化方法
        initGridLayout(gridLayout1,f1);
        initGridLayout(gridLayout2,f2);
        initGridLayout(gridLayout3,f3);
        initGridLayout(gridLayout4,f4);
        initGridLayout(gridLayout5,f5);
        initGridLayout(gridLayout6,f6);

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
