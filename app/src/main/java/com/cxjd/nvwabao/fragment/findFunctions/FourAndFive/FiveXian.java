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

public class FiveXian extends Fragment {

    //网格布局
    GridLayout gridLayout4;
    GridLayout gridLayout6;
    GridLayout gridLayout8;
    GridLayout gridLayout9;



    //定义网格中的数据
    String[] rouqindan = new String[]{
            "鸡血", "鸭肉", "猪腰"
    };

    String[] shuichan = new String[]{
            "海蜇", "田螺", "牡蛎肉", "蛤蜊", "鱿鱼", "海带",
            "鲍鱼", "海参"
    };

    String[] tiaoweipin = new String[]{
            "酱油", "盐"
    };

    String[] zhongyao = new String[]{
            "芒硝", "牡蛎壳"
    } ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_five_xian,container,false);

        //寻找gridLayout布局
        gridLayout4 = view.findViewById(R.id.xian_rouqindan);
        gridLayout6 = view.findViewById(R.id.xian_shuichan);
        gridLayout8 = view.findViewById(R.id.xian_tiaoweipin);
        gridLayout9 = view.findViewById(R.id.xian_zhongyaocai);


        //调用网格初始化方法
        initGridLayout(gridLayout4,rouqindan);
        initGridLayout(gridLayout6,shuichan);
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
