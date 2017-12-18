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
 * 100种病症不宜食物  -- G
 */
public class G extends Fragment {

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
    String[] g1 = new String[]{
            "虾","螃蟹","贝类","牛奶","蛋类","鳗鱼","鳝鱼","金枪鱼","沙丁鱼","黄鱼","洋葱","辛辣调料"
    };

    String[] g2 = new String[]{
            "鱿鱼","鱼子","蛋黄","肥肉","动物油","动物内脏","油炸食品","奶酪","奶糖","牛奶","羊奶","干酪","小米","巧克力","海带","紫菜","各种鱼类","贝类","虾","螃蟹"
    };

    String[]  g3 = new String[]{
            "芥末","咖喱","葱","生姜","大蒜","辣椒","白酒","沙丁鱼","高梁","红薯","燕麦","蚕豆","青豆","芹菜","韭菜","毛豆","竹笋","芋头","油炸食品"
    };

    String[] g4 = new String[]{
            "浓茶","咖啡","辣椒","肥肉","猪油","油炸食品"
            };

    String[] g5 = new String[]{
            "动物脂肪","咖喱","胡椒","芥末","酒","咖啡","辣椒","蜜饯","浓茶","碳酸饮料","咸菜","咸鱼"
    };

    String[] g6 = new String[]{
            "糯米","人参","阿胶","墨鱼","鱼子","蟹黄","辣椒","石榴","乌梅","鸭肉","羊肉","桂圆及","甜点"
    };

    String[] g7 = new String[]{
            "白酒","白糖","动物内脏","肥肉","糕点","巧克力","糖果","虾","咸菜","蟹黄","鸭蛋","羊髓","鱼子","猪油"
            };
    String[] g8 = new String[]{
            "贝类","蛋黄","动物脑","动物","骨髓","动物内脏","动物脂肪","酒精","巧克力","鱼子"
    };

    String[] g9 = new String[]{
            "糯米","人参","阿胶","海鱼","虾","螃蟹","桂圆","石榴","乌梅","甜点","鸭肉","羊肉","枸杞子"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_g,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_g_1);
        gridLayout2 = view.findViewById(R.id.onehundred_g_2);
        gridLayout3 = view.findViewById(R.id.onehundred_g_3);
        gridLayout4 = view.findViewById(R.id.onehundred_g_4);
        gridLayout5 = view.findViewById(R.id.onehundred_g_5);
        gridLayout6 = view.findViewById(R.id.onehundred_g_6);
        gridLayout7 = view.findViewById(R.id.onehundred_g_7);
        gridLayout8 = view.findViewById(R.id.onehundred_g_8);
        gridLayout9 = view.findViewById(R.id.onehundred_g_9);

        //调用网格初始化方法
        initGridLayout(gridLayout1,g1);
        initGridLayout(gridLayout2,g2);
        initGridLayout(gridLayout3,g3);
        initGridLayout(gridLayout4,g4);
        initGridLayout(gridLayout5,g5);
        initGridLayout(gridLayout6,g6);
        initGridLayout(gridLayout7,g7);
        initGridLayout(gridLayout8,g8);
        initGridLayout(gridLayout9,g9);

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
