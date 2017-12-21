package com.cxjd.nvwabao.fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.cxjd.nvwabao.bean.TitleLable;
import com.cxjd.nvwabao.fragment.findFunctions.OneHundred.S;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abu on 2017/10/16.
 */

public class NewsItemFragment extends Fragment {
    List<TitleContentBean> titleContentBeans;
    ImageView imageView;
    String rqTitle;
    private ProgressDialog progressDialog;
    SwipeRefreshLayout refreshLayout;
    private RecyclerView mRecyclerView;
    ListDataSave listDataSave;

    public NewsItemFragment() {

    }

    @SuppressLint("ValidFragment")
    public NewsItemFragment(TitleLable titleLable) {
       //this.rqTitle="nanxing";
        this.rqTitle=titleLable.getTitleCategery();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.gh,container,false);
       listDataSave=new ListDataSave(getContext(),"Titlecontent");
       refreshLayout=view.findViewById(R.id.swiperefresh);
       refreshLayout.setColorSchemeResources(R.color.colorPrimary);
       imageView=view.findViewById(R.id.icon);
       titleContentBeans=new ArrayList<>();
        mRecyclerView = (RecyclerView)view.findViewById(R.id.news_item_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        requesList();
       refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
               requesList();
               titleContentBeans=listDataSave.getDataList(rqTitle,TitleContentBean.class);
              // adapter.notifyDataSetChanged();
           }
       });
        return view;
   }

    private void requesList() {
        titleContentBeans=listDataSave.getDataList(rqTitle,TitleContentBean.class);
        if (titleContentBeans.size()<=0||titleContentBeans.isEmpty()) {
            String address = "http://47.94.145.225/user/getPosts/" + rqTitle;
            Log.e("address",address);
            showProgressDialog();
            HttpTitleUtil.sendHttpRequest(address, new HttpTitleUtil.HttpCallbackListener() {
                @Override
                public void onFinish(String response) {
                    Log.e("response",response);
                    String st=response.toString();
                    Log.e("st",st);
                    listDataSave.setDataList(rqTitle, HttpTitleUtil.parseJsonWithGSON(response.toString()));
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            titleContentBeans = listDataSave.getDataList(rqTitle, TitleContentBean.class);
                            Log.e("titleBean.getTittle()",titleContentBeans.get(0).getTittle());
                            final NewsItemAdapter adapter = new NewsItemAdapter(titleContentBeans, getContext());

                            mRecyclerView.setAdapter(adapter);
                            Log.e("st","!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            closeProgressDialog();
                            refreshLayout.setRefreshing(false);
                        }
                    });

                }

                @Override
                public void onError(Exception e) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            closeProgressDialog();
                            refreshLayout.setRefreshing(false);
                        }
                    });
                }
            });
        }else {
            //titleContentBeans = listDataSave.getDataList(rqTitle, TitleContentBean.class);
            final NewsItemAdapter adapter = new NewsItemAdapter(titleContentBeans, getContext());
            mRecyclerView.setAdapter(adapter);
        }
    }
    private void showProgressDialog(){
        if (progressDialog==null){
            progressDialog=new ProgressDialog(getContext());
            progressDialog.setMessage("正在加载...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }
    private void closeProgressDialog(){
        if (progressDialog!=null){
            progressDialog.dismiss();
        }
    }
}