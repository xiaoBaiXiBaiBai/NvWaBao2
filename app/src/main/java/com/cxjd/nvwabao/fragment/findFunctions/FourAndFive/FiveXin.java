package com.cxjd.nvwabao.fragment.findFunctions.FourAndFive;

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


public class FiveXin extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout7;
    GridLayout gridLayout8;
    GridLayout gridLayout9;



    //定义网格中的数据
    String[] shucai = new String[]{
            "韭菜", "白萝卜", "洋葱", "大蒜", "大葱", "生姜",
            "蒜苗", "芹菜", "香菜", "蒜薹", "芥蓝", "尖椒"
    };

    String[] yinpin = new String[]{
            "啤酒", "红酒","白酒"
    };

    String[] tiaoweipin = new String[]{
            "砂仁", "胡椒", "芥末", "花椒", "小茴香", "辣椒",
            "荜茇", "橘皮", "草果", "丁香", "大茴香", "白豆蔻"
    };

    String[] zhongyao = new String[]{
            "肉桂", "麻黄", "薄荷", "乳香", "香附", "木香",
            "菊花", "紫苏", "桂枝", "荆芥", "淡豆豉", "白芷"
    } ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_five_xin,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.xin_shucai);
        gridLayout7 = view.findViewById(R.id.xin_yinpin);
        gridLayout8 = view.findViewById(R.id.xin_tiaoweipin);
        gridLayout9 = view.findViewById(R.id.xin_zhongyaocai);

        //调用网格初始化方法
        initGridLayout(gridLayout1,shucai);
        initGridLayout(gridLayout7,yinpin);
        initGridLayout(gridLayout8,tiaoweipin);
        initGridLayout(gridLayout9,zhongyao);

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
            textView.setBackground(getResources().getDrawable(R.drawable.textview_fourandfive_background));
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
