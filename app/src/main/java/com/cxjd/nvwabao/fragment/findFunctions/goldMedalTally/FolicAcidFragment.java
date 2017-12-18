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
 *   维生素金牌榜  -- 叶酸
 */
public class FolicAcidFragment extends Fragment {
    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;



    //定义网格中的数据
    String[] zhiwu = new String[]{
            "小白菜","莴笋","菠菜","空心菜","芦笋","豆瓣菜","香菇","小葱","西蓝花","茼蒿","黄豆","腐乳","黄酱","葵花子","芸豆","绿豆","构杞","榴莲","红小豆","大枣"
    };

    String[] dongwu = new String[]{
            "猪肝"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_folic_acid,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.yesuan_plant);
        gridLayout2 = view.findViewById(R.id.yesuan_animal);


        //调用网格初始化方法
        initGridLayout(gridLayout1,zhiwu);
        initGridLayout(gridLayout2,dongwu);

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
