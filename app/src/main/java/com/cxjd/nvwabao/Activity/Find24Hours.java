package com.cxjd.nvwabao.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.ListViewAdapter;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight01;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight02;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight03;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight04;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight05;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight06;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight07;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight08;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight09;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight10;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight11;
import com.cxjd.nvwabao.fragment.findFunctions.twentyfourHours.Find24HoursRight12;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 李超 on 2017/11/29.
 */

public class Find24Hours extends AppCompatActivity {

    //用来存放所有的实例化的数据
    private List<com.cxjd.nvwabao.bean.ListView> itemList = new ArrayList<>();
    //全局属性
    ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_24hours);
        //初始化列表数据
        initListView();
        ListViewAdapter adapter = new ListViewAdapter(Find24Hours.this, R.layout.listview_item,itemList);
        listView = (ListView) findViewById(R.id.list_view_24);
        listView.setAdapter(adapter);
        //默认显示
        replaceFragment(new Find24HoursRight01());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        replaceFragment(new Find24HoursRight01());
                        break;
                    case 1 :
                        replaceFragment(new Find24HoursRight02());
                        break;
                    case 2 :
                        replaceFragment(new Find24HoursRight03());
                        break;
                    case 3 :
                        replaceFragment(new Find24HoursRight04());
                        break;
                    case 4 :
                        replaceFragment(new Find24HoursRight05());
                        break;
                    case 5 :
                        replaceFragment(new Find24HoursRight06());
                        break;
                    case 6 :
                        replaceFragment(new Find24HoursRight07());
                        break;
                    case 7 :
                        replaceFragment(new Find24HoursRight08());
                        break;
                    case 8 :
                        replaceFragment(new Find24HoursRight09());
                        break;
                    case 9 :
                        replaceFragment(new Find24HoursRight10());
                        break;
                    case 10 :
                        replaceFragment(new Find24HoursRight11());
                        break;
                    case 11 :
                        replaceFragment(new Find24HoursRight12());
                        break;
                    default:
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
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_24hours_fragment,fragment);
        transaction.commit();

    }

    private void initListView() {
        com.cxjd.nvwabao.bean.ListView item0 = new com.cxjd.nvwabao.bean.ListView("23.00"+"\n " + "~" +"\n "+ "01.00");
        itemList.add(item0);
        com.cxjd.nvwabao.bean.ListView item1 = new com.cxjd.nvwabao.bean.ListView("01.00"+"\n " + "~" + "\n "+"03.00");
        itemList.add(item1);
        com.cxjd.nvwabao.bean.ListView item2 = new com.cxjd.nvwabao.bean.ListView("03.00"+"\n " + "~" + "\n "+"05.00");
        itemList.add(item2);
        com.cxjd.nvwabao.bean.ListView item3 = new com.cxjd.nvwabao.bean.ListView("05.00"+"\n " + "~" + "\n "+"07.00");
        itemList.add(item3);
        com.cxjd.nvwabao.bean.ListView item4 = new com.cxjd.nvwabao.bean.ListView("07.00"+"\n " + "~" + "\n "+"09.00");
        itemList.add(item4);
        com.cxjd.nvwabao.bean.ListView item5 = new com.cxjd.nvwabao.bean.ListView("09.00"+"\n " + "~" + "\n "+"11.00");
        itemList.add(item5);
        com.cxjd.nvwabao.bean.ListView item6 = new com.cxjd.nvwabao.bean.ListView("11.00"+"\n " + "~" + "\n "+"13.00");
        itemList.add(item6);
        com.cxjd.nvwabao.bean.ListView item7 = new com.cxjd.nvwabao.bean.ListView("13.00"+"\n " + "~" +"\n "+ "15.00");
        itemList.add(item7);
        com.cxjd.nvwabao.bean.ListView item8 = new com.cxjd.nvwabao.bean.ListView("15.00"+"\n " + "~" + "\n "+"17.00");
        itemList.add(item8);
        com.cxjd.nvwabao.bean.ListView item9 = new com.cxjd.nvwabao.bean.ListView("17.00"+"\n " + "~" +"\n "+ "19.00");
        itemList.add(item9);
        com.cxjd.nvwabao.bean.ListView item10 = new com.cxjd.nvwabao.bean.ListView("19.00"+"\n " + "~" +"\n "+ "21.00");
        itemList.add(item10);
        com.cxjd.nvwabao.bean.ListView item11 = new com.cxjd.nvwabao.bean.ListView("21.00"+"\n " + "~" + "\n "+"23.00");
        itemList.add(item11);
    }


}
