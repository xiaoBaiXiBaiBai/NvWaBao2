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
 * 100种病症不宜食物  -- P
 */
public class P extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;


    //定义网格中的数据
    String[] p1 = new String[]{
            "冬瓜","苦瓜","黄瓜","绿豆","芹菜","西瓜","羊肉","牛肉","桂圆","肥肉","油炸食品","动物内脏","蛋黄","白酒","咖啡","浓茶","洋葱","辛辣调料"
    };

    String[] p2 = new String[]{
            "浓茶","大蒜","肥肉","核桃","花生","韭菜","荞麦","蒜薹","虾","杏仁","洋葱","猪油"
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_p,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_p_1);
        gridLayout2 = view.findViewById(R.id.onehundred_p_2);

        //调用网格初始化方法
        initGridLayout(gridLayout1,p1);
        initGridLayout(gridLayout2,p2);

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
