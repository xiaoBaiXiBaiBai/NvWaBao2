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
 * 100种病症不宜食物  -- W
 */
public class W extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;


    //定义网格中的数据
    String[] w1 = new String[]{
            "豆类","肥肉","咖啡","苦瓜","辣椒","糯米","螃蟹","柿子","薯类","西瓜","鸭蛋","洋葱","酒","醋"
    };

    String[] w2 = new String[]{
            "酸菜","巧克力","蜜饯","醋","白酒","浓茶","咖啡","葱","生姜","大蒜","牛奶","蛋黄","芹菜","韭菜","萝卜","红薯","豆类","柠檬","青果"
    };

    String[]  w3 = new String[]{
            "牛排","猪排","鸡排","薯条","各种冷饮","苦瓜","冬瓜","绿豆","牡蛎","螃蟹","梨","柚子","芹菜","丝瓜","醋","巧克力","咖啡","酸菜","白酒"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_w,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_w_1);
        gridLayout2 = view.findViewById(R.id.onehundred_w_2);
        gridLayout3 = view.findViewById(R.id.onehundred_w_3);

        //调用网格初始化方法
        initGridLayout(gridLayout1,w1);
        initGridLayout(gridLayout2,w2);
        initGridLayout(gridLayout3,w3);
        
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
