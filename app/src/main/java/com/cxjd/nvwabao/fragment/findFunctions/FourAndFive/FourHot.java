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


public class FourHot extends Fragment {

    //网格布局
    GridLayout gridLayout5;
    GridLayout gridLayout8;
    GridLayout gridLayout9;



    //定义网格中的数据
    String[] ganguo = new String[]{
            "炒葵花子"
    };


    String[] tiaoweipin = new String[]{
            "辣椒", "胡椒", "肉桂", "咖喱粉"
    };

    String[] zhongyao = new String[]{
            "沉香", "附子", "硫黄", "鹿茸", "麻黄"
    } ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four_hot,container,false);

        //寻找gridLayout布局
        gridLayout5 = view.findViewById(R.id.hot_ganguo);
        gridLayout8 = view.findViewById(R.id.hot_tiaoweipin);
        gridLayout9 = view.findViewById(R.id.hot_zhongyaocai);

        //调用网格初始化方法
        initGridLayout(gridLayout5,ganguo);
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
