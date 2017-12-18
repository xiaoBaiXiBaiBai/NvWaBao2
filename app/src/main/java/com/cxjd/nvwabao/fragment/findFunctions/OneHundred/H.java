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
 * 100种病症不宜食物  -- H
 */
public class H extends Fragment {
    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;

    //定义网格中的数据
    String[] h1 = new String[]{
            "辣椒","葱","生姜","洋葱","虾","螃蟹","松花蛋","肥肉","蛋黄","动物油","冬瓜","银耳","绿豆"
    };

    String[] h2 = new String[]{
            "鹅肉","羊肉","鸡肉","鸡蛋","南瓜","辣椒","榨菜","大蒜","糯米","荔枝","土豆","动物油","肥肉","狗肉","海鱼","虾","螃蟹","柿子","香蕉","红薯","苦瓜"
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_h,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_h_1);
        gridLayout2 = view.findViewById(R.id.onehundred_h_2);
        //调用网格初始化方法
        initGridLayout(gridLayout1,h1);
        initGridLayout(gridLayout2,h2);

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
