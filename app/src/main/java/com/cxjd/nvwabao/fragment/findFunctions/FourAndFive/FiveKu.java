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


public class FiveKu extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout4;
    GridLayout gridLayout7;
    GridLayout gridLayout9;



    //定义网格中的数据
    String[] shucai = new String[]{
            "苦瓜", "苦菊"
    };

    String[] rouqindan = new String[]{
            "猪血", "羊肝"
    };

    String[] yinpin = new String[]{
            "绿茶"
    };

    String[] zhongyao = new String[]{
            "苦杏仁", "大黄", "厚朴", "栀子", "桃仁", "黄连",
            "知母", "黄柏", "杏仁"
    } ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_five_ku,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.ku_shucai);
        gridLayout4 = view.findViewById(R.id.ku_rouqindan);
        gridLayout7 = view.findViewById(R.id.ku_yinpin);
        gridLayout9 = view.findViewById(R.id.ku_zhongyaocai);

        //调用网格初始化方法
        initGridLayout(gridLayout1,shucai);
        initGridLayout(gridLayout4,rouqindan);
        initGridLayout(gridLayout7,yinpin);
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
