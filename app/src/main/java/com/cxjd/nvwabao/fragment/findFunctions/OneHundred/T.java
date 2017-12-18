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
 * 100种病症不宜食物  --  T
 */
public class T extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;


    //定义网格中的数据
    String[] t1 = new String[]{
            "冷饮","绿豆","冬瓜","黄瓜","竹笋","莲藕","海带","丝瓜","肥肉","动物油","鱼子","奶酪","山楂","杨梅","话梅"
    };

    String[] t2 = new String[]{
            "梨","桃子","山楂","蜜枣","柿饼","桂圆","柿子","糖","白酒","冰淇淋","动物内脏","肥肉","糕点","果汁","黄油","蜜饯","汽水","鸭蛋","羊髓","猪油"
    };

    String[]  t3 = new String[]{
            "啤酒","葡萄酒","香槟","白酒","咖啡","浓茶","可乐","牛奶","奶酪","酸奶","羊奶","优酪乳","味精","盐","辛辣调料"
    };

    String[] t4 = new String[]{
            "动物内脏","鹅肉","鲱鱼","凤尾鱼","酒","三文鱼","肉汤","沙丁鱼","鱼子","菜花","芦笋","香菇","酒"
    };

    String[] t5 = new String[]{
            "肥肉","羊肉","狗肉","牛肉","动物内脏","动物油","蛋黄","鱼子","蟹黄","油炸食品","巧克力","冰淇淋","糖果","白酒","辛辣调料"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_t,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_t_1);
        gridLayout2 = view.findViewById(R.id.onehundred_t_2);
        gridLayout3 = view.findViewById(R.id.onehundred_t_3);
        gridLayout4 = view.findViewById(R.id.onehundred_t_4);
        gridLayout5 = view.findViewById(R.id.onehundred_t_5);

        //调用网格初始化方法
        initGridLayout(gridLayout1,t1);
        initGridLayout(gridLayout2,t2);
        initGridLayout(gridLayout3,t3);
        initGridLayout(gridLayout4,t4);
        initGridLayout(gridLayout5,t5);

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
