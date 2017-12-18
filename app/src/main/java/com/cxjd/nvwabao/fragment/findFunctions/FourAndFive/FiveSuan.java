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


public class FiveSuan extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout7;
    GridLayout gridLayout8;
    GridLayout gridLayout9;



    //定义网格中的数据
    String[] shucai = new String[]{
            "马齿苋", "番茄"
    };

    String[] shuiguo = new String[]{
            "橙", "柚", "柠檬", "柑", "橄榄", "菠萝",
            "桃子", "枇杷", "杨梅", "李子", "山楂", "火龙果",
            "杏子", "葡萄", "乌梅", "猕猴桃", "石榴", "梨",
            "苹果"
    };

    String[] yinpin = new String[]{
            "果汁", "酸奶"
    };

    String[] tiaoweipin = new String[]{
            "醋"
    };

    String[] zhongyao = new String[]{
            "山萸肉", "白芍", "乌梅", "五味子", "金樱子"
    } ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_five_suan,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.suan_shucai);
        gridLayout2 = view.findViewById(R.id.suan_shuiguo);
        gridLayout7 = view.findViewById(R.id.suan_yinpin);
        gridLayout8 = view.findViewById(R.id.suan_tiaoweipin);
        gridLayout9 = view.findViewById(R.id.suan_zhongyaocai);

        //调用网格初始化方法
        initGridLayout(gridLayout1,shucai);
        initGridLayout(gridLayout2,shuiguo);
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
