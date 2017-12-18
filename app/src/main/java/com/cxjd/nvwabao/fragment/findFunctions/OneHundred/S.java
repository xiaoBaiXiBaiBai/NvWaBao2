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
public class S extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;


    //定义网格中的数据
    String[] s1 = new String[]{
            "韭菜","洋葱","大蒜","辣椒","羊肉","狗肉","牛肉","桂圆","红参","鹿角胶","核桃","榴莲","鱼类","海产品","白酒","洋葱","生姜","花椒"
    };

    String[] s2 = new String[]{
            "菠菜","燕麦片","巧克力","油菜","空心菜","葱","酸菜","竹笋","草莓","茭白","肥肉","动物内脏","啤酒","黄油","羊肉","狗肉","鳝鱼","鳗鱼","黄鱼","金枪鱼","沙丁鱼","虾","螃蟹","蚌肉"
    };

    String[]  s3 = new String[]{
            "豆类","肥肉","芥末","咖啡","辣椒","年糕","浓茶","巧克力","大蒜","洋葱","油炸食品","玉米"
    };

    String[] s4 = new String[]{
            "生姜","辣椒","胡椒","芥末","咖喱","花椒","葱","白酒","咖啡","浓茶","巧克力","葡萄酒","肥肉","动物油","动物内脏"
    };

    String[] s5 = new String[]{
            "肥肉","动物油","动物内脏","蛋黄","油炸食品","糖果","冰淇淋","巧克力","奶油蛋糕","饼干","果汁"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_s,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_s_1);
        gridLayout2 = view.findViewById(R.id.onehundred_s_2);
        gridLayout3 = view.findViewById(R.id.onehundred_s_3);
        gridLayout4 = view.findViewById(R.id.onehundred_s_4);
        gridLayout5 = view.findViewById(R.id.onehundred_s_5);

        //调用网格初始化方法
        initGridLayout(gridLayout1,s1);
        initGridLayout(gridLayout2,s2);
        initGridLayout(gridLayout3,s3);
        initGridLayout(gridLayout4,s4);
        initGridLayout(gridLayout5,s5);

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
