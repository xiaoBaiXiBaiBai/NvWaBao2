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
 * 营养素金牌榜 -- 脂肪
 */
public class ZhiFangFragment extends Fragment {
    //网格布局
    GridLayout gridLayout1;
    GridLayout gridLayout2;



    //定义网格中的数据
    String[] zhiwu = new String[]{
            "杏仁","开心果","核桃","松子","橄榄","黄豆","榛子","花生","干辣椒","巧克力","腰果","葵花子","茶油","菜籽油","色拉油","花生油","椰子","大豆油","麦芽油","辣椒油","葵花子油","玉米油","棕榈油","芝麻油","南瓜子","芥末","黄油","西瓜子","椰子油"
    };

    String[] dongwu = new String[]{
            "鸽肉","鸽蛋黄","鹌鹑蛋黄","鸡蛋黄","鱿鱼","奶酪","猪皮","牛肝","猪蹄","猪腰","猪肝","鸭蛋黄","猪肉","肥羊肉","羊腰","羊肝","肥牛肉","牛腰","猪油","牛油","羊油","动物奶油","胖头鱼"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhi_fang,container,false);

        //寻找gridLayout布局
        gridLayout1 = view.findViewById(R.id.zhifang_plant);
        gridLayout2 = view.findViewById(R.id.zhifang_animal);


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
