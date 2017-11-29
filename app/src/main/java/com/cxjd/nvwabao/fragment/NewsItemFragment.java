package com.cxjd.nvwabao.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.HttpTitleUtil;
import com.cxjd.nvwabao.adapter.ListDataSave;
import com.cxjd.nvwabao.adapter.NewsItemAdapter;
import com.cxjd.nvwabao.bean.TitleContentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abu on 2017/10/16.
 */

public class NewsItemFragment extends Fragment {
    List<TitleContentBean> titleContentBeans;
    ImageView imageView;
    String rqTitle;
    private RecyclerView mRecyclerView;
    ListDataSave listDataSave;

    public NewsItemFragment() {

    }

    @SuppressLint("ValidFragment")
    public NewsItemFragment(String string) {

        this.rqTitle="nanxing";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.gh,container,false);
       listDataSave=new ListDataSave(getContext(),"Titlecontent");
       imageView=view.findViewById(R.id.icon);
       String address="http://192.168.31.227/user/getPosts/"+rqTitle;
       HttpTitleUtil.sendHttpRequest(address, new HttpTitleUtil.HttpCallbackListener() {
           @Override
           public void onFinish(String response) {
               listDataSave.setDataList("Simplecontent"+rqTitle, HttpTitleUtil.parseJsonWithGSON(response.toString()));
           }

           @Override
           public void onError(Exception e) {

           }
       });
       titleContentBeans=new ArrayList<>();
       titleContentBeans=listDataSave.getDataList("Simplecontent"+rqTitle,TitleContentBean.class);
       mRecyclerView = (RecyclerView)view.findViewById(R.id.news_item_recycle_view);
       NewsItemAdapter adapter=new NewsItemAdapter(titleContentBeans,getContext());
       LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
       mRecyclerView.setLayoutManager(layoutManager);
       mRecyclerView.setAdapter(adapter);
       return view;
   }

}