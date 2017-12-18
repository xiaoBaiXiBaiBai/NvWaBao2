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
import com.cxjd.nvwabao.fragment.findFunctions.OneHundred.Rr;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.A;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.B;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.C;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.D;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.E;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.F;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.G;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.H;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.I;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.J;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.K;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.L;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.M;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.N;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.O;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.P;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.Q;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.S;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.T;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.U;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.V;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.W;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.X;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.Y;
import com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.Z;

import java.util.ArrayList;
import java.util.List;

public class OneHundred extends AppCompatActivity {
    //集合，用来存放ListView中各项的数据
    private List<ListView> itemList = new ArrayList<>();
    //全局属性
    android.widget.ListView listView;
    //数据数组
    String[] items = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_hundred);

        //初始化ListView中的数据
        initListView();
        ListView45Adapter adapter = new ListView45Adapter(OneHundred.this, R.layout.fragment_left_fourandfive_item,itemList);
        listView = (android.widget.ListView) findViewById(R.id.list_view_45);
        listView.setAdapter(adapter);

        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.A());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.A());
                        break;
                    case 1 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.B());
                        break;
                    case 2 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.C());
                        break;
                    case 3 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.D());
                        break;
                    case 4 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.E());
                        break;
                    case 5 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.F());
                        break;
                    case 6 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.G());
                        break;
                    case 7 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.H());
                        break;
                    case 8 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.I());
                        break;
                    case 9 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.J());
                        break;
                    case 10 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.K());
                        break;
                    case 11 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.L());
                        break;
                    case 12 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.M());
                        break;
                    case 13 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.N());
                        break;
                    case 14 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.O());
                        break;
                    case 15 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.P());
                        break;
                    case 16 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.Q());
                        break;
                    case 17 :
                        replaceFragment(new Rr());
                        break;
                    case 18 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.S());
                        break;
                    case 19 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.T());
                        break;
                    case 20 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.U());
                        break;
                    case 21 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.V());
                        break;
                    case 22 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.W());
                        break;
                    case 23 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.X());
                        break;
                    case 24 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.Y());
                        break;
                    case 25 :
                        replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.OneHundred.Z());
                        break;
                    default :
                        break;
                }
            }
        });
    }

    private void initListView() {
        for(int i=0; i<items.length; i++){
            ListView listView = new ListView(items[i]);
            itemList.add(listView);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.right_100_fragment,fragment);
        fragmentTransaction.commit();
    }

}
