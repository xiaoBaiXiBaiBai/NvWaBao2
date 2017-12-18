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
 * 100种病症不宜食物  -- R
 */
public class Rr extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;


    //定义网格中的数据
    String[] r1 = new String[]{
            "动物油","动物内脏","肥肉","油炸食品","精细的主食","咸菜","威蛋","咸酱","糖果","巧克力","蜜饯","果脯","辣椒","芥末"
    };

    String[] r2 = new String[]{
            "盐","咸鱼","咸菜"," 红薯"," 洋葱","糯米"
    };

    String[]  r3 = new String[]{
            "羊肉","辣椒","胡椒","葱","烈酒","生鸡蛋","肥肉","咖喱","芥末","榴莲","臭豆腐"
    };

    String[] r4 = new String[]{
            "咖啡","油炸食品","肥肉","冷饮","巧克力","浓茶","辣椒","香肠","动物油","辛辣调料"
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_r,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_r_1);
        gridLayout2 = view.findViewById(R.id.onehundred_r_2);
        gridLayout3 = view.findViewById(R.id.onehundred_r_3);
        gridLayout4 = view.findViewById(R.id.onehundred_r_4);

        //调用网格初始化方法
        initGridLayout(gridLayout1,r1);
        initGridLayout(gridLayout2,r2);
        initGridLayout(gridLayout3,r3);
        initGridLayout(gridLayout4,r4);

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
