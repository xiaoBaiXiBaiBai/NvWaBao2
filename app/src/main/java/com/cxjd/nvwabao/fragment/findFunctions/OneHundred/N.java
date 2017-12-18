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
 * 100种病症不宜食物  -- N
 */
public class N extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;


    //定义网格中的数据
    String[] n1 = new String[]{
            "浓茶","咖啡","油炸食品","辣椒","蛋黄","鱼子","动物内脏","动物油","肥肉"
    };

    String[] n2 = new String[]{
            "羊肉","狗肉","牛肉","虾","螃蟹","牡蛎","蚌肉","鱼类","醋","白酒","浓茶","咖啡","辣椒","生姜","葱","大蒜","洋葱","辛辣调味品"
    };

    String[]  n3 = new String[]{
            "猪油","牛油","动物脂肪","酒","浓茶","咖啡","辛辣调料"
    };

    String[] n4 = new String[]{
            "肥肉","动物内脏","蛋黄","辣椒","酒","冷饮","油炸食品","动物油","蟹黄"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_n,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_n_1);
        gridLayout2 = view.findViewById(R.id.onehundred_n_2);
        gridLayout3 = view.findViewById(R.id.onehundred_n_3);
        gridLayout4 = view.findViewById(R.id.onehundred_n_4);

        //调用网格初始化方法
        initGridLayout(gridLayout1,n1);
        initGridLayout(gridLayout2,n2);
        initGridLayout(gridLayout3,n3);
        initGridLayout(gridLayout4,n4);

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
