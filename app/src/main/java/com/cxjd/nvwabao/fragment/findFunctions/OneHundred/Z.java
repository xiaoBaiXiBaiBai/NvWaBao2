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
 * 100种病症不宜食物  --   Z
 */
public class Z extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;
    GridLayout gridLayout6;


    //定义网格中的数据
    String[] z1 = new String[]{
            "芝麻","虾","牡蛎","狗肉","辛辣调料","寒凉性食物","茭白","鹅肉","猪头肉","公鸡","酒","醋"
    };

    String[] z2 = new String[]{
            "白萝卜","韭菜","花生","大蒜","肥肉","动物油","动物内脏","油炸食品","辣椒","芥末","咖喱","白酒","咖啡","浓茶","醋"
    };

    String[]  z3 = new String[]{
            "生姜"," 葱"," 大蒜","韭菜","洋葱","辣椒","酒","油腻食品"
    };

    String[] z4 = new String[]{
            "动物内脏","豆类","肥肉","海鱼","汽水","辣椒","冷饮","奶制品","薯类","虾","芝麻","猪油","酒"
    };

    String[] z5 = new String[]{
            "鸡蛋","肥肉","咖喱","胡椒","鸡汤","酒","辣椒","巧克力","肉汤","糖","甜点","油条","鱼汤","鱼子","炸花生","炸鸡"
    };

    String[] z6 = new String[]{
            "辣椒","胡椒","花椒","大蒜","白酒","肥肉","羊肉","狗肉","芥末","咖喱","烟熏香肠","熏肉","烤肉","芒果","榴莲","荔枝","桂圆"
    };


@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_z,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_z_1);
        gridLayout2 = view.findViewById(R.id.onehundred_z_2);
        gridLayout3 = view.findViewById(R.id.onehundred_z_3);
        gridLayout4 = view.findViewById(R.id.onehundred_z_4);
        gridLayout5 = view.findViewById(R.id.onehundred_z_5);
        gridLayout6 = view.findViewById(R.id.onehundred_z_6);

        //调用网格初始化方法
        initGridLayout(gridLayout1,z1);
        initGridLayout(gridLayout2,z2);
        initGridLayout(gridLayout3,z3);
        initGridLayout(gridLayout4,z4);
        initGridLayout(gridLayout5,z5);
        initGridLayout(gridLayout6,z6);

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
