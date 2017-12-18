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
 * 营养素金牌榜  ---  蛋白质
 */
public class ProteinFragment extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;



    //定义网格中的数据
    String[] zhiwu = new String[]{
            "豆浆","豆腐","豌豆","豆腐皮","豆腐干","黄豆","刀豆","芸豆","金针菇","口蘑","鸡腿菇","干蘑菇","葵花子","南瓜子","莲子","燕麦","杏仁","紫菜","黑豆","花生","青豆","绿豆","蚕豆","西瓜子","芝麻","猴头菇","榛子","松子","核桃"
    };

    String[] dongwu = new String[]{
            "海参","虾","鸡蛋清","奶酪","羊奶","牛奶","猪瘦肉","猪血","猪皮","猪心","猪腰","猪肝","牛腰","牛肝","羊血","牛蹄筋","牛瘦肉","羊腰","羊肝","羊瘦肉","鸡肝","鸡肉","鹌鹑肉","鹌鹑蛋","鸭蛋清","鸭肉","兔肉","狗肉","鹅肉","鲍鱼","鲢鱼","青鱼","带鱼","龙虾","干贝","银鱼","蛤蜊","海蟹","蜗牛","蚕蛹","猪蹄","鲨鱼"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_protein,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.protein_plant);
        gridLayout2 = view.findViewById(R.id.protein_animal);


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
