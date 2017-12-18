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


public class FourWen extends Fragment {

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
    String[] shucai = new String[]{
            "香菜", "芥菜", "南瓜", "葱", "四季豆", "刀豆",
            "洋葱", "青蒜", "油菜", "熟藕", "罗勒", "熟白萝卜",
            "魔芋", "蒜薹", "雪里蕻", "生姜", "香椿头", "茴香苗"
    };

    String[] shuiguo = new String[]{
            "樱桃", "山楂", "荔枝", "石榴", "释迦", "柑橘",
            "金橘", "杨梅", "木瓜", "鲜桂圆", "红毛丹", "鲜枣",
            "番石榴", "佛手柑", "香椽", "乌梅", "越橘果"
    };

    String[]  jundou = new String[]{
            "茶树菇", "平菇"
    };

    String[] rouqindan = new String[]{
            "牛肚", "牛髓", "黄牛肉", "猪血", "猪肚", "猪肝",
            "羊奶", "羊髓", "狗肉", "羊骨", "羊肚", "羊肉",
            "鸡肉", "熊掌", "野鸡肉", "骆驼肉", "鹿肉", "獐肉",
            "麻雀蛋", "麻雀", "蚕蛹", "鹅蛋", "火腿", "鸡肝"
    };

    String[] wuguganguo = new String[]{
            "糯米", "黑米", "高梁", "杏仁", "核桃肉", "西米",
            "板栗", "开心果", "干莲子", "松子仁", "桂圆肉", "大枣",
            "果类", "橘饼", "谷芽", "槟榔"
    };

    String[] shuichan = new String[]{
            "草鱼", "鲈鱼", "鲇鱼", "鲤鱼", "鳝鱼", "鲢鱼",
            "淡菜","海马", "虾", "海参", "刀鱼", "武昌鱼",
            "鳙鱼", "大头鱼", "河豚", "鳟鱼", "白条鱼", "鳊鱼",
            "海星", "大马哈鱼", "魴鱼", "蚶"
    };

    String[] yinpin = new String[]{
            "红茶", "羊奶", "黄酒", "白酒", "红酒", "咖啡",
            "月季花茶", "玫瑰花茶", "茉莉花茶", "桂花茶", "金盏花茶",
            "白兰花茶", "迷迭香茶", "莲花茶", "紫藤花茶", "雪莲花茶"
    };

    String[] tiaoweipin = new String[]{
            "小茴香", "红糖", "饴糖", "胡椒", "干姜", "八角",
            "花椒", "芥末", "孜然", "莳萝", "砂仁", "料酒",
            "草果", "植物油", "醋", "小蒜", "胡葱"
    };

    String[] zhongyao = new String[]{
            "杜仲", "肉苁蓉", "陈皮", "五味子", "紫河车", "蛤蚧",
            "麦芽", "艾叶", "石榴皮", "木香", "红花", "橘核",
            "荆芥", "当归", "人参", "何首乌", "黄芪", "神曲",
            "丁香", "白术", "豆蔻", "紫苏", "五加皮", "高良姜",
            "姜黄", "山柰", "白芷", "山茱萸", "吴茱萸", "独活",
            "红曲"
    } ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four_wen,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.wen_shucai);
        gridLayout2 = view.findViewById(R.id.wen_shuiguo);
        gridLayout3 = view.findViewById(R.id.wen_jundou);
        gridLayout4 = view.findViewById(R.id.wen_rouqindan);
        gridLayout5 = view.findViewById(R.id.wen_wuguganguo);
        gridLayout6 = view.findViewById(R.id.wen_shuichan);
        gridLayout7 = view.findViewById(R.id.wen_yinpin);
        gridLayout8 = view.findViewById(R.id.wen_tiaoweipin);
        gridLayout9 = view.findViewById(R.id.wen_zhongyaocai);

        //调用网格初始化方法
        initGridLayout(gridLayout1,shucai);
        initGridLayout(gridLayout2,shuiguo);
        initGridLayout(gridLayout3,jundou);
        initGridLayout(gridLayout4,rouqindan);
        initGridLayout(gridLayout5,wuguganguo);
        initGridLayout(gridLayout6,shuichan);
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
