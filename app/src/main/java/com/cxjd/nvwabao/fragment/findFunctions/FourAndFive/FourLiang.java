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


public class FourLiang extends Fragment {

    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    GridLayout gridLayout3;
    GridLayout gridLayout4;
    GridLayout gridLayout5;
    GridLayout gridLayout7;
    GridLayout gridLayout9;



    //定义网格中的数据
    String[] shucai = new String[]{
            "白菜", "小白菜", "丝瓜", "白萝卜", "马兰头", "冬瓜",
            "茭白", "丝瓜", "生菜", "菠菜", "苋菜", "黄瓜",
            "花椰菜", "芥蓝", "竹", "西蓝花", "莴笋", "芦笋",
            "芹菜", "芦蒿", "构杞头", "番茄", "油菜", "牛蒡",
            "笋瓜", "节瓜", "佛手瓜", "西瓜皮", "黄花菜", "刺儿菜"
    };

    String[] shuiguo = new String[]{
            "梨", "草莓", "芦柑", "苹果", "芒果", "橙子",
            "橘子", "火龙果", "刺梨", "山竹", "橄榄", "余甘",
            "枇杷", "莲雾"
    };

    String[]  jundou = new String[]{
            "蘑菇", "金针菇", "豆腐", "豆腐皮", "腐竹", "豆腐渣",
            "豆浆", "豆腐脑"
    };

    String[] rouqindan = new String[]{
            "猪皮", "水牛肉", "羊肝", "兔肉", "鸭肉", "田鸡肉",
            "鸭蛋"
    };

    String[] wuguganguo = new String[]{
            "大麦", "小麦", "小米", "荞麦", "薏苡仁", "马豆",
            "绿豆", "菱角"
    };



    String[] yinpin = new String[]{
            "菊花茶", "金银花茶", "椰子汁", "啤酒", "绿茶", "槐花茶"
    };

    String[] zhongyao = new String[]{
            "薄荷", "罗汉果", "莲子心", "丹参", "川贝母", "土贝母",
            "大蓟", "小蓟", "浮小麦", "芦根", "石斛", "胖大海",
            "女贞子", "马鞭草", "连翘", "天花粉", "升麻", "北沙参",
            "儿茶", "石韦", "玄参", "白芍", "朱砂", "牡丹皮",
            "牡蛎", "青箱子", "阴地蕨", "茵陈", "鸡冠花", "西洋参",
            "枳壳", "前胡", "钩藤", "穿山甲", "络石藤", "柴胡",
            "菊花", "益母草", "银柴胡", "槐米", "槐花", "薏苡仁",
            "冬瓜子", "冬瓜皮"
    } ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four_liang,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.liang_shucai);
        gridLayout2 = view.findViewById(R.id.liang_shuiguo);
        gridLayout3 = view.findViewById(R.id.liang_jundou);
        gridLayout4 = view.findViewById(R.id.liang_rouqindan);
        gridLayout5 = view.findViewById(R.id.liang_wuguganguo);
        gridLayout7 = view.findViewById(R.id.liang_yinpin);
        gridLayout9 = view.findViewById(R.id.liang_zhongyaocai);

        //调用网格初始化方法
        initGridLayout(gridLayout1,shucai);
        initGridLayout(gridLayout2,shuiguo);
        initGridLayout(gridLayout3,jundou);
        initGridLayout(gridLayout4,rouqindan);
        initGridLayout(gridLayout5,wuguganguo);
        initGridLayout(gridLayout7,yinpin);
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
