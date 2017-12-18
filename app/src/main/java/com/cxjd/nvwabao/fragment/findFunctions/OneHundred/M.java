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
 * 100种病症不宜食物  -- M
 */
public class M extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;


    //定义网格中的数据
    String[] m1 = new String[]{
            "辣椒","生姜","葱","大蒜","猪排","牛排","糙米","糯米","黄豆","蚕豆","花生","肥肉"
    };

    String[] m2 = new String[]{
            "口蘑","丁香鱼","松子","虾皮","莲子","羊肉","扇贝","盐","威菜","咸蛋","火腿","腌肉","番茄酱"
    };

    String[]  m3 = new String[]{
            "海鱼","虾","螃蟹","肥肉","猪油","油炸食品","红薯","土豆","韭菜","未加工的黄豆制品","辣椒","胡椒","大料","芥末","过甜食品","冷饮","汽水","酒"
    };

    String[] m4 = new String[]{
            "葱","蛋糕","动物内脏","肥肉","咖喱","罐头","胡椒","芥末","酒","辣椒","虾","咸鱼","咸菜","猪油","羊肉","狗肉","生姜"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_hundred_m,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.onehundred_m_1);
        gridLayout2 = view.findViewById(R.id.onehundred_m_2);
        gridLayout3 = view.findViewById(R.id.onehundred_m_3);
        gridLayout4 = view.findViewById(R.id.onehundred_m_4);

        //调用网格初始化方法
        initGridLayout(gridLayout1,m1);
        initGridLayout(gridLayout2,m2);
        initGridLayout(gridLayout3,m3);
        initGridLayout(gridLayout4,m4);

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
