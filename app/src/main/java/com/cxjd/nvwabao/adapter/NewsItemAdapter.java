package com.cxjd.nvwabao.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxjd.nvwabao.ActivityNews.NewsDetailActivity;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.TitleContentBean;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by abu on 2017/10/17.
 */

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.ViewHolder> {
    private List<TitleContentBean> titleBeanList;
    private int position;
    Context context;
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView newsTitle;
        private TextView newstouchTime;
        private int position;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.news_img);
            newsTitle= (TextView) itemView.findViewById(R.id.news_title);
            //newstouchTime= (TextView) itemView.findViewById(R.id.news_datetime);

        }
    }

    public NewsItemAdapter(List<TitleContentBean> titleBeanList, Context context) {
        this.titleBeanList = titleBeanList;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_newsitem,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
           final TitleContentBean titleBean=titleBeanList.get(position);
           holder.newsTitle.setText(titleBean.getTittle());
           Picasso.with(context).load(titleBean.getImageAddress()).placeholder(R.drawable.icon_test).resize(120,100).into(holder.imageView);
           this.position=position;
           holder.imageView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent=new Intent(context, NewsDetailActivity.class);
                   intent.putExtra("content",titleBean.getUrl());
                   intent.putExtra("pageId",titleBean.getId());
                   context.startActivity(intent);
               }
           });
    }

    @Override
    public int getItemCount() {
        return titleBeanList.size();
    }
}
