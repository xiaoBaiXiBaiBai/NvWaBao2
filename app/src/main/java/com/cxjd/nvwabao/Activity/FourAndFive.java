package com.cxjd.nvwabao.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.ListView45Adapter;
import com.cxjd.nvwabao.bean.ListView;
import com.cxjd.nvwabao.fragment.findFunctions.FourAndFive.FiveGan;
import com.cxjd.nvwabao.fragment.findFunctions.FourAndFive.FiveKu;
import com.cxjd.nvwabao.fragment.findFunctions.FourAndFive.FiveSuan;
import com.cxjd.nvwabao.fragment.findFunctions.FourAndFive.FiveXian;
import com.cxjd.nvwabao.fragment.findFunctions.FourAndFive.FiveXin;
import com.cxjd.nvwabao.fragment.findFunctions.FourAndFive.FourHan;
import com.cxjd.nvwabao.fragment.findFunctions.FourAndFive.FourHot;
import com.cxjd.nvwabao.fragment.findFunctions.FourAndFive.FourLiang;
import com.cxjd.nvwabao.fragment.findFunctions.FourAndFive.FourWen;

import java.util.ArrayList;
import java.util.List;

public class FourAndFive extends AppCompatActivity {

    //选项集合
    private List<ListView> listViewList = new ArrayList<>();

    //全局变量
    android.widget.ListView listView;

    //选项名字数组
    String[] names = new String[]{"寒性食物","凉性食物","热性食物","温性食物","酸味食物","辛味食物","苦味食物","咸味食物","甘味食物"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_and_five);
        //初始化LIstView
        initItems();
        ListView45Adapter adapter = new ListView45Adapter(FourAndFive.this, R.layout.fragment_left_fourandfive_item,listViewList);
        //找到ListView中的TextView
        listView = (android.widget.ListView) findViewById(R.id.list_view_45);
        listView.setAdapter(adapter);

        //默认显示项
        replaceFragment(new FourHan());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        replaceFragment(new FourHan());
                        break;
                    case 1 :
                        replaceFragment(new FourLiang());
                        break;
                    case 2 :
                        replaceFragment(new FourHot());
                        break;
                    case 3 :
                        replaceFragment(new FourWen());
                        break;
                    case 4 :
                        replaceFragment(new FiveSuan());
                        break;
                    case 5 :
                        replaceFragment(new FiveXin());
                        break;
                    case 6 :
                        replaceFragment(new FiveKu());
                        break;
                    case 7 :
                        replaceFragment(new FiveXian());
                        break;
                    case 8 :
                       replaceFragment(new FiveGan());
                       break;
                }

            }
        });


    }


    /**
     * 更换Fragment显示的页面
     * @param fragment
     */
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.right_fourAndFive_fragment,fragment);
        fragmentTransaction.commit();
    }


    /**
     *  初始化列表
     */
    private void initItems() {
        for (int i=0; i<names.length; i++){
            ListView listView = new ListView(names[i]);
            listViewList.add(listView);
        }
    }
}
