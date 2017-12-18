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
 * 100种病症不宜食物  --  J
 */
public class J extends Fragment {
    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;
    GridLayout gridLayout6;
    GridLayout gridLayout7;


    //定义网格中的数据
    String[] j1 = new String[]{
            "冷饮","寒凉性食物","辛辣刺激的食物"
    };

    String[] j2 = new String[]{
            "巧克力","冰淇淋","糖果","饼干","大蒜","葱","生姜","辣椒","芥末","花椒","胡椒","咖喱","小茴香","桂皮","白酒","浓茶","咖啡"
    };

    String[]  j3 = new String[]{
            "薯条","猪排","炸鸡","油条","肥肉","猪油","肉汤","油酥点心","白酒","咖啡","辣椒","洋葱","生姜","大蒜","胡椒","花椒","醋","酸菜"
    };

    String[] j4 = new String[]{
            "土豆","红薯","豆类","萝卜","韭菜","猪油","肥肉","动物内脏","鸡汤","火腿","羊肉","南瓜","辣椒","带鱼","虾","螃蟹"
    };

    String[] j5 = new String[]{
            "面包","鸡汤","薯条","冰淇淋","杏仁","松子","巧克力","奶油饼干","腰果，葵花子","黄鱼","金枪鱼","鰻鱼","蚌肉","螃蟹","酒"
    };

    String[] j6 = new String[]{
            "海带","紫菜","各种鱼类","贝类","虾","螃蟹","香菜","花生","土豆","圆白菜","酒","辣椒","生姜","大蒜","花椒","芥末"
    };

    String[] j7 = new String[]{
            "螃蟹","虾","鸭肉","蚕蛹","鸡蛋","鸭蛋","南瓜","荸荠","甜瓜","大蒜","白酒"
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_j,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_j_1);
        gridLayout2 = view.findViewById(R.id.onehundred_j_2);
        gridLayout3 = view.findViewById(R.id.onehundred_j_3);
        gridLayout4 = view.findViewById(R.id.onehundred_j_4);
        gridLayout5 = view.findViewById(R.id.onehundred_j_5);
        gridLayout6 = view.findViewById(R.id.onehundred_j_6);
        gridLayout7 = view.findViewById(R.id.onehundred_j_7);


        //调用网格初始化方法
        initGridLayout(gridLayout1,j1);
        initGridLayout(gridLayout2,j2);
        initGridLayout(gridLayout3,j3);
        initGridLayout(gridLayout4,j4);
        initGridLayout(gridLayout5,j5);
        initGridLayout(gridLayout6,j6);
        initGridLayout(gridLayout7,j7);

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
