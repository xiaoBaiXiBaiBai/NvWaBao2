package com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally;

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
 *  营养素金牌榜  -- 碳水化合物（糖）
 */
public class SugarFragment extends Fragment {

    //网格布局
    GridLayout gridLayout1;


    //定义网格中的数据
    String[] shiwu = new String[]{
            "小麦","大米","小米","玉米","高粱","糯米","黑米","燕麦","薏米","芡实","红小豆","绿豆","荞麦","石花菜","蕨菜","平菇","竹荪","鸡腿菇","西瓜","莲子","甘蔗","甜瓜","香蕉","板栗","红糖","胡萝卜","白糖","红薯","马铃薯","葡萄","咖啡","冰糖","蔗糖"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sugar, container, false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.sugar_plant);


        //调用网格初始化方法
        initGridLayout(gridLayout1, shiwu);

        return view;
    }

    /**
     * 为网格布局初始化
     *
     * @param gridLayout 网格布局
     * @param strings    网格中的数据
     */
    private void initGridLayout(GridLayout gridLayout, String[] strings) {

        //为网格赋值
        for (int i = 0; i < strings.length; i++) {
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
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
            //指定该组件占满父组件
            params.setGravity(Gravity.FILL);
            gridLayout.addView(textView, params);
        }

    }

}
