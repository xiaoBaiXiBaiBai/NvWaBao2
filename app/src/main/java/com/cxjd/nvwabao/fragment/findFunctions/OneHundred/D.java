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
 * 100种病症不宜食物  -- D
 */
public class D extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;
    GridLayout gridLayout6;


    //定义网格中的数据
    String[] d1 = new String[]{
            "蛏子","蛤蜊","蚌肉","冷饮","啤酒","汽水","笋干","田螺","咸菜","咸鱼"
    };

    String[] d2 = new String[]{
            "动物内脏","动物脑","蛋黄","鱼子","鱿鱼","芹菜","玉米","燕麦","猪排","炸鸡","薯条","油条","冷饮"
    };

    String[]  d3 = new String[]{
            "煎炸食品","肥肉","动物油","鹅肉","羊肉","酒","浓茶","咖啡","巧克力","辣椒","葱","大蒜"
    };

    String[] d4 = new String[]{
            "芥菜","酒","咖啡","浓茶","山楂","柠檬","杨梅","螃蟹","动物内","脏","蛋黄","鱿鱼","辛辣调料","红薯","豆类","芹菜"
    };

    String[] d5 = new String[]{
            "蛋黄","动物内脏","动物脂肪","白酒","甜食","饮料","油炸食品"
    };

    String[] d6 = new String[]{
            "啤酒","白酒","咖啡","精加工的速食米","土豆","白面粉","盐","汽水","玉米片","通心粉","肉汁"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_d,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_d_1);
        gridLayout2 = view.findViewById(R.id.onehundred_d_2);
        gridLayout3 = view.findViewById(R.id.onehundred_d_3);
        gridLayout4 = view.findViewById(R.id.onehundred_d_4);
        gridLayout5 = view.findViewById(R.id.onehundred_d_5);
        gridLayout6 = view.findViewById(R.id.onehundred_d_6);

        //调用网格初始化方法
        initGridLayout(gridLayout1,d1);
        initGridLayout(gridLayout2,d2);
        initGridLayout(gridLayout3,d3);
        initGridLayout(gridLayout4,d4);
        initGridLayout(gridLayout5,d5);
        initGridLayout(gridLayout6,d6);

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
