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
 * 100种病症不宜食物  --  Y
 */
public class Y extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;
    GridLayout gridLayout6;
    GridLayout gridLayout7;
    GridLayout gridLayout8;
    GridLayout gridLayout9;


    //定义网格中的数据
    String[] y1 = new String[]{
            "肥肉","哈密瓜","咖啡","辣椒","冷饮","烈酒","浓茶","生葱","生大蒜","西瓜","咸鱼","香瓜"
    };

    String[] y2 = new String[]{
            "虾子","羊肉","辛辣调料","冷饮","豆类","豆制品","寒凉性食物","芝麻","猪头肉","红枣","桂圆","酒","醋"
    };

    String[]  y3 = new String[]{
            "冷饮","寒凉性食物","辣椒","葱","大蒜","炒花生","白酒","白萝卜","洋葱","芥菜","生姜","胡椒","茴香","山楂","荸荠"
    };

    String[] y4 = new String[]{
            "猪油","牛油","猪肚","蛋黄","鱼子","猪心","肥肉","奶油","咖啡","浓茶","可乐","白酒","黄酒","洋葱","辛辣调料"
    };

    String[] y5 = new String[]{
            "白酒","辣椒","芥末","洋葱","生姜","大蒜","胡椒","花椒","桂皮","小茴香","带鱼","黄鱼","平鱼","蚌肉","螃蟹","韭菜","羊肉","南瓜","辣椒","蒜薹"
    };

    String[] y6 = new String[]{
            "爆米花","葱，大蒜","鹅肉","桂皮","狗肉","胡椒","黄鱼","韭菜","辣椒","桂圆","螃蟹","人参","砂仁","虾","羊肉"
    };

    String[] y7 = new String[]{
            "白酒","咖啡","浓茶","辣椒","洋葱","生姜","大蒜","芥末","大料","胡椒","麻椒","葱","咖喱"
    };

    String[]  y8 = new String[]{
            "猪排","牛排","薯条","薯片","糙米","花生","葵花子","杏仁","腰果","开心果","榛子","辣椒","大蒜","葱","生姜","花椒","胡椒","咖喱","酒","咖啡","浓茶"
    };

    String[] y9 = new String[]{
            "爆米花","葱","大蒜","鹅肉","桂皮","狗肉","胡椒","黄鱼","鸡肉","韭菜","辣椒","桂圆","螃蟹","雀肉","人参","砂仁","虾","羊肉"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_y,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_y_1);
        gridLayout2 = view.findViewById(R.id.onehundred_y_2);
        gridLayout3 = view.findViewById(R.id.onehundred_y_3);
        gridLayout4 = view.findViewById(R.id.onehundred_y_4);
        gridLayout5 = view.findViewById(R.id.onehundred_y_5);
        gridLayout6 = view.findViewById(R.id.onehundred_y_6);
        gridLayout7 = view.findViewById(R.id.onehundred_y_7);
        gridLayout8 = view.findViewById(R.id.onehundred_y_8);
        gridLayout9 = view.findViewById(R.id.onehundred_y_9);

        //调用网格初始化方法
        initGridLayout(gridLayout1,y1);
        initGridLayout(gridLayout2,y2);
        initGridLayout(gridLayout3,y3);
        initGridLayout(gridLayout4,y4);
        initGridLayout(gridLayout5,y5);
        initGridLayout(gridLayout6,y6);
        initGridLayout(gridLayout7,y7);
        initGridLayout(gridLayout8,y8);
        initGridLayout(gridLayout9,y9);

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