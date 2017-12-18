package com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally;

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
 *   营养素金牌榜  --  钙
 */
public class CaFragment extends Fragment {
    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;



    //定义网格中的数据
    String[] zhiwu = new String[]{
            "黄花菜","蕨菜","豆制品","苋菜","香菜","四棱豆","黑木耳","海带","紫菜","南瓜子","蚕豆","芥未","绿茶","雪里蕻","红茶"
    };

    String[] dongwu = new String[]{
            "牛奶","乳制品","虾皮","虾","动物骨","蟹","蛤蜊","海参"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ca,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.ca_plant);
        gridLayout2 = view.findViewById(R.id.ca_animal);


        //调用网格初始化方法
        initGridLayout(gridLayout1,zhiwu);
        initGridLayout(gridLayout2,dongwu);

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
