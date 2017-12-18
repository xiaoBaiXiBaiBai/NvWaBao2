package com.cxjd.nvwabao.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.EatingUtensilsAdapter;
import com.cxjd.nvwabao.bean.ListView;
import com.cxjd.nvwabao.fragment.findFunctions.eatingUtensils.Aluminum;
import com.cxjd.nvwabao.fragment.findFunctions.eatingUtensils.Copper;
import com.cxjd.nvwabao.fragment.findFunctions.eatingUtensils.Enamel;
import com.cxjd.nvwabao.fragment.findFunctions.eatingUtensils.GalvanizedVessel;
import com.cxjd.nvwabao.fragment.findFunctions.eatingUtensils.Iron;
import com.cxjd.nvwabao.fragment.findFunctions.eatingUtensils.Plastics;
import com.cxjd.nvwabao.fragment.findFunctions.eatingUtensils.StainlessSteel;

import java.util.ArrayList;
import java.util.List;

public class EatingUtensils extends AppCompatActivity {
    //用来存放所有的实例化的数据
    private List<ListView> itemList = new ArrayList<>();
    //全局属性
    android.widget.ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eating_utensils);
        //初始化列表数据
        initListView();
        EatingUtensilsAdapter adapter = new EatingUtensilsAdapter(EatingUtensils.this, R.layout.eating_utensils_item,itemList);
        listView = (android.widget.ListView) findViewById(R.id.list_view_24);
        listView.setAdapter(adapter);
        //默认显示
        replaceFragment(new Enamel());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        replaceFragment(new Enamel());
                        break;
                    case 1 :
                        replaceFragment(new Aluminum());
                        break;
                    case 2 :
                        replaceFragment(new Iron());
                        break;
                    case 3 :
                        replaceFragment(new Plastics());
                        break;
                    case 4 :
                        replaceFragment(new StainlessSteel());
                        break;
                    case 5 :
                        replaceFragment(new GalvanizedVessel());
                        break;
                    case 6 :
                        replaceFragment(new Copper());
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
        transaction.replace(R.id.right_eatingUtensils_fragment,fragment);
        transaction.commit();

    }

    private void initListView() {
        com.cxjd.nvwabao.bean.ListView item0 = new com.cxjd.nvwabao.bean.ListView("搪瓷器具");
        itemList.add(item0);
        com.cxjd.nvwabao.bean.ListView item1 = new com.cxjd.nvwabao.bean.ListView("铝制器具");
        itemList.add(item1);
        com.cxjd.nvwabao.bean.ListView item2 = new com.cxjd.nvwabao.bean.ListView("铁制器具");
        itemList.add(item2);
        com.cxjd.nvwabao.bean.ListView item3 = new com.cxjd.nvwabao.bean.ListView("塑料制品");
        itemList.add(item3);
        com.cxjd.nvwabao.bean.ListView item4 = new com.cxjd.nvwabao.bean.ListView("不锈钢餐具");
        itemList.add(item4);
        com.cxjd.nvwabao.bean.ListView item5 = new com.cxjd.nvwabao.bean.ListView("镀锌餐具");
        itemList.add(item5);
        com.cxjd.nvwabao.bean.ListView item6 = new com.cxjd.nvwabao.bean.ListView("铜制餐具");
        itemList.add(item6);
    }
}

