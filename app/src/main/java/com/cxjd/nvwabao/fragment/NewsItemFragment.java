package com.cxjd.nvwabao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.NewsItemAdapter;
import com.cxjd.nvwabao.bean.NewsTitleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abu on 2017/10/16.
 */

public class NewsItemFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<NewsTitleBean> titleBeanList=new ArrayList<>();
    int index;
    public NewsItemFragment() {
    }

    //public NewsItemFragment(int index) {
    //    this.index=index;
    //}

   @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.gh,container,false);
        init();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.news_item_recycle_view);
        NewsItemAdapter adapter=new NewsItemAdapter(titleBeanList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        return view;
    }
    public void init(){
        for (int i=0;i<=10;i++){
            NewsTitleBean titleBean=new NewsTitleBean(index+"我是一个粉刷家，分化本领强，爱爱爱爱哎哎哎啊不挖煤",R.drawable.icon_test,"招聘网","2017-8-9");
            titleBeanList.add(titleBean);
        }
    }

}
