package com.cxjd.nvwabao.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cxjd.nvwabao.Activity.FoodInfoActivity;
import com.cxjd.nvwabao.Activity.FoodListActivity;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.Fruit2;

import java.util.List;

/**
 * Created by Administrator on 2017/12/3.
 */

public class Fruit3Adapter extends RecyclerView.Adapter<Fruit3Adapter.ViewHolder> {
    private  List<Fruit2> mFruitList;
    private Context contextCC;

   // private OnItemClickListener mOnItemClickListener;//声明接口
    static  class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = view.findViewById(R.id.fruit_image);
             fruitName = view.findViewById(R.id.fruit_name);
        }
    }
    public Fruit3Adapter(List<Fruit2> fruitList){
        mFruitList = fruitList;
    }
    @Override
    public Fruit3Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        contextCC = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foot_list3,parent,false);
        final ViewHolder holder = new ViewHolder(view);
       holder.fruitView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position = holder.getAdapterPosition();
               Fruit2 fruit2 = mFruitList.get(position);

               Intent intent = new Intent(contextCC,FoodInfoActivity.class);
               intent.putExtra("content_url",fruit2.getIconUrl());
               //intent.putExtra("address","药材/"+position);
               contextCC.startActivity(intent);
           }
       });
       holder.fruitImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position = holder.getAdapterPosition();
               Fruit2 fruit2 = mFruitList.get(position);
               Intent intent = new Intent(contextCC,FoodInfoActivity.class);
               intent.putExtra("content_url",fruit2.getIconUrl());
               //intent.putExtra("address","药材/"+position);
               contextCC.startActivity(intent);
           }
       });
        return holder;
    }

    @Override
    public void onBindViewHolder(final Fruit3Adapter.ViewHolder holder, int position) {
        Fruit2 fruit = mFruitList.get(position);
        Log.e("fruit.getName()",fruit.getName());
        Glide.with(contextCC).load(fruit.getImageId()).into(holder.fruitImage);


     //   View itemView = ((RelativeLayout) holder.itemView).getChildAt(0);
    /*    if (mOnItemClickListener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }*/
       // holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
/*    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }*/
}
