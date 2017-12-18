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
 * 100种病症不宜食物  -- K
 */
public class K extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;


    //定义网格中的数据
    String[] k1 = new String[]{
            "猪排","牛排","薯片","油炸花生仁","杏仁","葵花子","炒黄豆","冰淇淋","冰冻饮料","辣椒","白酒","醋","韭菜","生姜","葱","大蒜"
    };

    String[] k2 = new String[]{
            "蚌肉","薄荷","狗肉","桂皮","胡椒","螃蟹","李子","柿子","石榴","桃子","乌梅","樱桃"
    };

    

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_k,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_k_1);
        gridLayout2 = view.findViewById(R.id.onehundred_k_2);

        //调用网格初始化方法
        initGridLayout(gridLayout1,k1);
        initGridLayout(gridLayout2,k2);

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
