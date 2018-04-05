package com.cxjd.nvwabao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TabHost;
import android.widget.TextView;

import com.cxjd.nvwabao.Activity.CirclesMainPage;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.CircleAdapter;
import com.cxjd.nvwabao.bean.Circles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by 李超 on 2017/10/29.
 */

public class CircleFragment extends Fragment implements AbsListView.OnScrollListener {
    //fragment视图
    private View view;

    private SwipeRefreshLayout mySRL;

    private List<Circles> circlesList = new ArrayList<>();

    private int heads[] = {R.drawable.cr_jiuyibang,R.drawable.cr_meirong,R.drawable.cr_fuke,R.drawable.cr_liuchan,R.drawable.cr_gaoxueya,
                           R.drawable.cr_tangniu,R.drawable.cr_beiyun,R.drawable.cr_buyu,R.drawable.cr_yangsheng,R.drawable.cr_jianzhouyan,
                           R.drawable.cr_nanren};
    private String titles[] = {"就医帮帮团","美容美体","妇科疾病","避孕流产","高血压","糖尿病","备孕怀孕","不孕不育","中医养生","肩周炎","男人帮"};

    private String chengYuan[] = {"60.0万","59.9万","56.4万","59.9万","60.1万","60.5万","59.8万","54.7万",
                                  "59.9万","71.3万","59.9万"};

    private String tieZi[] = {"566","4989","2737","2168","427","589","4789","23","47","456","789"};

    //圈子ListView
    android.widget.ListView listView;

    private View footerView;

    //用来可显示的最后一条数据的索引
    private int visibleLasIndex;

    //刷新的条件，适配器中的个数
    private int i = 6;

    //适配器
    CircleAdapter adapter;

    //handler
    private Handler refreshHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x101:
                    Circles circles07 = new Circles(heads[6],titles[6],"6",chengYuan[6],tieZi[6],6);
                    Circles circles08 = new Circles(heads[7],titles[7],"5",chengYuan[7],tieZi[7],7);
                    Circles circles09 = new Circles(heads[8],titles[8],"4",chengYuan[8],tieZi[8],8);
                    Circles circles10 = new Circles(heads[9],titles[9],"3",chengYuan[9],tieZi[9],9);
                    Circles circles11 = new Circles(heads[10],titles[10],"2",chengYuan[10],tieZi[10],10);

                    circlesList.addAll(Arrays.asList(circles07,circles08,circles09,circles10,circles11));
                    adapter.notifyDataSetChanged();
                    listView.removeFooterView(footerView);
                    break;
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null){
            view = inflater.inflate(R.layout.fragment_circle,container,false);
            //初始化页面
            initView(view);
            //初始化圈子
            initCircles();
            //初始列表
            initListView(view);
        }
        return view;
    }




    private void initListView(View view) {
        adapter = new CircleAdapter(getContext(),R.layout.cir_circles_item,circlesList,0);
        listView = view.findViewById(R.id.cir_lv_circle);
        footerView = getLayoutInflater().inflate(R.layout.loading_layout,null);
        listView.addFooterView(footerView);
        listView.setOnScrollListener(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Circles circles = circlesList.get(position);
                Intent intent = new Intent(getContext(), CirclesMainPage.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("circles",circles);
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });
    }

    private void initView(View view) {
        //设置圈子标题
        TextView textView = view.findViewById(R.id.fragment_title);
        textView.setText(R.string.circle);
        //设置TabHost组件
        final TabHost tabHost = view.findViewById(R.id.cr_tabhost);
        //初始化TabHost容器
        tabHost.setup();

        //创建第一个Tab页面
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1").setIndicator("动态").setContent(R.id.cr_tab_01);
        //添加第一个标签页
        tabHost.addTab(tab1);
        //创建第二个Tab页面
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2").setIndicator("圈子").setContent(R.id.cr_tab_02);
        //添加第二个Tab页面
        tabHost.addTab(tab2);
    }



    private void initCircles() {

        Circles circles01 = new Circles(heads[0],titles[0],"1",chengYuan[0],tieZi[0],0);
        Circles circles02 = new Circles(heads[1],titles[1],"2",chengYuan[1],tieZi[1],1);
        Circles circles03 = new Circles(heads[2],titles[2],"3",chengYuan[2],tieZi[2],2);
        Circles circles04 = new Circles(heads[3],titles[3],"4",chengYuan[3],tieZi[3],3);
        Circles circles05 = new Circles(heads[4],titles[4],"5",chengYuan[4],tieZi[4],4);
        Circles circles06 = new Circles(heads[5],titles[5],"6",chengYuan[5],tieZi[5],5);
        circlesList.addAll(Arrays.asList(circles01,circles02,circles03,circles04,circles05,circles06));
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
          if (adapter.getCount() == i){
              i++;
              new LoadDataThread().start();
          }


    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount , int totalItemCount) {
         //减去最后一个加载中那条
        visibleLasIndex = firstVisibleItem + visibleItemCount - 1;
    }

    /**
     * 模拟加载数据的线程
     */
    class LoadDataThread extends Thread{
        @Override
        public void run() {
            try{
              Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //通过handler发送一个更新数据的标题
            refreshHandler.sendEmptyMessage(0x101);
        }
    }

}
