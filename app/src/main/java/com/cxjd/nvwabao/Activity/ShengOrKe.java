package com.cxjd.nvwabao.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.ListView45Adapter;
import com.cxjd.nvwabao.bean.ListView;
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

public class ShengOrKe extends AppCompatActivity {

    //相生
    ImageButton imageButton1;
    //相生图片的状态，决定图片的显示，默认为1
    int state1 = 1;
    //相克图片的状态，决定图片的显示，默认为0
    int state2 = 0;
    //相克
    ImageButton imageButton2;
    //集合，用来存放ListView中各项的数据
    private List<ListView> itemList = new ArrayList<>();
    //全局属性
    android.widget.ListView listView;
    //数据数组
    String[] items = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    //当前的选中项，默认为第一项即A
    int defaultPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheng_or_ke);
        //找到用于存放相生相克图片的ImageView组件
        imageButton1 = (ImageButton) findViewById(R.id.imageButton_xiangsheng);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton_xiangke);

        //初始化ListView中的数据
        initListView();
        ListView45Adapter adapter = new ListView45Adapter(ShengOrKe.this, R.layout.fragment_left_fourandfive_item,itemList);
        listView = (android.widget.ListView) findViewById(R.id.list_view_45);
        listView.setAdapter(adapter);

        //默认显示
        if (state1 == 1 && defaultPosition == 0){
            listView.setSelection(defaultPosition);
            replaceFragment(new A());
        }



        imageButton1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //按下
                    state1 = 1;
                    state2 = 0;
                    imageButton1.setImageDrawable(getResources().getDrawable(R.drawable.xiangsheng_press));
                    imageButton2.setImageDrawable(getResources().getDrawable(R.drawable.xiangke));
                    switch (defaultPosition){
                        case 0 :
                            replaceFragment(new A());
                            break;
                        case 1 :
                            replaceFragment(new B());
                            break;
                        case 2 :
                            replaceFragment(new C());
                            break;
                        case 3 :
                            replaceFragment(new D());
                            break;
                        case 4 :
                            replaceFragment(new E());
                            break;
                        case 5 :
                            replaceFragment(new F());
                            break;
                        case 6 :
                            replaceFragment(new G());
                            break;
                        case 7 :
                            replaceFragment(new H());
                            break;
                        case 8 :
                            replaceFragment(new I());
                            break;
                        case 9 :
                            replaceFragment(new J());
                            break;
                        case 10 :
                            replaceFragment(new K());
                            break;
                        case 11 :
                            replaceFragment(new L());
                            break;
                        case 12 :
                            replaceFragment(new M());
                            break;
                        case 13 :
                            replaceFragment(new N());
                            break;
                        case 14 :
                            replaceFragment(new O());
                            break;
                        case 15 :
                            replaceFragment(new P());
                            break;
                        case 16 :
                            replaceFragment(new Q());
                            break;
                        case 17 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.R());
                            break;
                        case 18 :
                            replaceFragment(new S());
                            break;
                        case 19 :
                            replaceFragment(new T());
                            break;
                        case 20 :
                            replaceFragment(new U());
                            break;
                        case 21 :
                            replaceFragment(new V());
                            break;
                        case 22 :
                            replaceFragment(new W());
                            break;
                        case 23 :
                            replaceFragment(new X());
                            break;
                        case 24 :
                            replaceFragment(new Y());
                            break;
                        case 25 :
                            replaceFragment(new Z());
                            break;
                        default :
                            break;
                    }
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    if (state1 == 0 || state2 == 1){
                        imageButton2.setImageDrawable(getResources().getDrawable(R.drawable.xiangke_press));
                        imageButton1.setImageDrawable(getResources().getDrawable(R.drawable.xiangsheng));
                    }else if (state1 == 1 || state2 ==0){
                        imageButton2.setImageDrawable(getResources().getDrawable(R.drawable.xiangke));
                        imageButton1.setImageDrawable(getResources().getDrawable(R.drawable.xiangsheng_press));
                    }

                }
                return false;
            }
        });


        imageButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //按下
                    state1 = 0;
                    state2 = 1;
                    imageButton2.setImageDrawable(getResources().getDrawable(R.drawable.xiangke_press));
                    imageButton1.setImageDrawable(getResources().getDrawable(R.drawable.xiangsheng));
                    switch (defaultPosition){
                        case 0 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.A());
                            break;
                        case 1 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.B());
                            break;
                        case 2 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.C());
                            break;
                        case 3 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.D());
                            break;
                        case 4 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.E());
                            break;
                        case 5 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.F());
                            break;
                        case 6 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.G());
                            break;
                        case 7 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.H());
                            break;
                        case 8 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.I());
                            break;
                        case 9 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.J());
                            break;
                        case 10 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.K());
                            break;
                        case 11 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.L());
                            break;
                        case 12 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.M());
                            break;
                        case 13 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.N());
                            break;
                        case 14 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.O());
                            break;
                        case 15 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.P());
                            break;
                        case 16 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.Q());
                            break;
                        case 17 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.R());
                            break;
                        case 18 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.S());
                            break;
                        case 19 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.T());
                            break;
                        case 20 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.U());
                            break;
                        case 21 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.V());
                            break;
                        case 22 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.W());
                            break;
                        case 23 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.X());
                            break;
                        case 24 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.Y());
                            break;
                        case 25 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.Z());
                            break;
                        default :
                            break;
                    }
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    if (state1 == 0 || state2 == 1){
                        imageButton2.setImageDrawable(getResources().getDrawable(R.drawable.xiangke_press));
                        imageButton1.setImageDrawable(getResources().getDrawable(R.drawable.xiangsheng));
                    }else if (state1 == 1 || state2 ==0){
                        imageButton2.setImageDrawable(getResources().getDrawable(R.drawable.xiangke));
                        imageButton1.setImageDrawable(getResources().getDrawable(R.drawable.xiangsheng_press));
                    }
                }
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(state1 == 1){
                    switch (position){
                        case 0 :
                            replaceFragment(new A());
                            break;
                        case 1 :
                            replaceFragment(new B());
                            break;
                        case 2 :
                            replaceFragment(new C());
                            break;
                        case 3 :
                            replaceFragment(new D());
                            break;
                        case 4 :
                            replaceFragment(new E());
                            break;
                        case 5 :
                            replaceFragment(new F());
                            break;
                        case 6 :
                            replaceFragment(new G());
                            break;
                        case 7 :
                            replaceFragment(new H());
                            break;
                        case 8 :
                            replaceFragment(new I());
                            break;
                        case 9 :
                            replaceFragment(new J());
                            break;
                        case 10 :
                            replaceFragment(new K());
                            break;
                        case 11 :
                            replaceFragment(new L());
                            break;
                        case 12 :
                            replaceFragment(new M());
                            break;
                        case 13 :
                            replaceFragment(new N());
                            break;
                        case 14 :
                            replaceFragment(new O());
                            break;
                        case 15 :
                            replaceFragment(new P());
                            break;
                        case 16 :
                            replaceFragment(new Q());
                            break;
                        case 17 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.sheng.R());
                            break;
                        case 18 :
                            replaceFragment(new S());
                            break;
                        case 19 :
                            replaceFragment(new T());
                            break;
                        case 20 :
                            replaceFragment(new U());
                            break;
                        case 21 :
                            replaceFragment(new V());
                            break;
                        case 22 :
                            replaceFragment(new W());
                            break;
                        case 23 :
                            replaceFragment(new X());
                            break;
                        case 24 :
                            replaceFragment(new Y());
                            break;
                        case 25 :
                            replaceFragment(new Z());
                            break;
                        default :
                            break;
                    }
                }else if(state2 == 1){
                    switch (position){
                        case 0 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.A());
                            break;
                        case 1 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.B());
                            break;
                        case 2 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.C());
                            break;
                        case 3 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.D());
                            break;
                        case 4 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.E());
                            break;
                        case 5 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.F());
                            break;
                        case 6 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.G());
                            break;
                        case 7 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.H());
                            break;
                        case 8 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.I());
                            break;
                        case 9 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.J());
                            break;
                        case 10 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.K());
                            break;
                        case 11 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.L());
                            break;
                        case 12 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.M());
                            break;
                        case 13 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.N());
                            break;
                        case 14 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.O());
                            break;
                        case 15 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.P());
                            break;
                        case 16 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.Q());
                            break;
                        case 17 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.R());
                            break;
                        case 18 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.S());
                            break;
                        case 19 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.T());
                            break;
                        case 20 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.U());
                            break;
                        case 21 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.V());
                            break;
                        case 22 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.W());
                            break;
                        case 23 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.X());
                            break;
                        case 24 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.Y());
                            break;
                        case 25 :
                            replaceFragment(new com.cxjd.nvwabao.fragment.findFunctions.shengAndKe.ke.Z());
                            break;
                        default :
                            break;
                    }
                }
            }
        });

    }

    /**
     * 为ListView组件中的每一项赋值
     */
    private void initListView() {
        for(int i=0; i<items.length; i++){
            ListView item = new ListView(items[i]);
            itemList.add(item);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.right_shengAndKe_fragment,fragment);
        fragmentTransaction.commit();
    }




}
