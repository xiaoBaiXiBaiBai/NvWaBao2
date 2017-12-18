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
 * 100种病症不宜食物 -- b
 */
public class B extends Fragment {
    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;


    //定义网格中的数据
    String[] b1 = new String[]{
            "肥肉","动物肝脏","羊肉","牛肉","动物油","蛋黄","蟹黄","咸菜","咸蛋","火腿","豆辦酱","花生","葵花子","腰果","巧克力","冷饮","生姜","大蒜","辣椒","甜点","柠檬"
    };

    String[] b2 = new String[]{
            "蛋黄","鱿鱼","鱼子","虾","动物内脏","奶油","白酒","辣椒","洋葱","韭菜","生姜","大蒜","咸菜","咸蛋","豆瓣酱","火腿","香肠","咸肉"
    };

    String[]  b3 = new String[]{
            "柠檬","橙子","柚子","柑橘","山楂","猕猴桃","草莓","杨梅","葱","生姜","大蒜","辣椒","芥末","咖喱","白酒"
    };

    String[] b4 = new String[]{
            "板栗","咖喱","高粱","狗肉","胡椒","酒","咖啡","辣椒","荔枝","莲子","牛奶","牛肉","糯米","羊肉","葱","大蒜","肉桂","鹿茸","浓茶"
    };

    String[] b5 = new String[]{
            "山楂","杨梅","话梅","醋","柑橘","杏","羊肉","肥肉","动物","油","鱼子","白酒","萝卜","辣椒","大蒜","洋葱"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_b,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_b_1);
        gridLayout2 = view.findViewById(R.id.onehundred_b_2);
        gridLayout3 = view.findViewById(R.id.onehundred_b_3);
        gridLayout4 = view.findViewById(R.id.onehundred_b_4);
        gridLayout5 = view.findViewById(R.id.onehundred_b_5);

        //调用网格初始化方法
        initGridLayout(gridLayout1,b1);
        initGridLayout(gridLayout2,b2);
        initGridLayout(gridLayout3,b3);
        initGridLayout(gridLayout4,b4);
        initGridLayout(gridLayout5,b5);

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
