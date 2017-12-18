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
 * 100种病症不宜食物  -- C
 */
public class C extends Fragment {
    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;


    //定义网格中的数据
    String[] c1 = new String[]{
            "白酒","辣椒","芥末","茴香","洋葱","大蒜葱","韭菜","苦瓜","芹菜","萝卜缨","丝瓜","冬瓜","萝卜","冷饮"
    };

    String[] c2 = new String[]{
            "冬瓜","黄瓜","绿豆","茴香","芹菜","苦瓜","西瓜","冷饮","肥肉","蛋黄","动物油","奶酪","炸鸡","薯条","薯片","燕麦片","花椒"
    };

    String[]  c3 = new String[]{
            "芹菜","大白菜","油菜","韭菜","萝卜","土豆","红薯","黄豆","蚕豆","肥肉","动物内脏","糙米","狗肉","羊肉","牛肉","熏鱼"
    };

    String[] c4 = new String[]{
            "肥肉","羊肉","狗肉","蛋黄","海鱼","虾","螃蟹","海带","紫菜","海参","辣椒","韭菜","生姜","洋葱","大蒜","花椒","胡椒","芥末","大料"
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_c,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_c_1);
        gridLayout2 = view.findViewById(R.id.onehundred_c_2);
        gridLayout3 = view.findViewById(R.id.onehundred_c_3);
        gridLayout4 = view.findViewById(R.id.onehundred_c_4);

        //调用网格初始化方法
        initGridLayout(gridLayout1,c1);
        initGridLayout(gridLayout2,c2);
        initGridLayout(gridLayout3,c3);
        initGridLayout(gridLayout4,c4);

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
