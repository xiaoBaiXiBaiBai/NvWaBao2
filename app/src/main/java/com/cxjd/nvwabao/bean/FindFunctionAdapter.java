package com.cxjd.nvwabao.bean;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.cxjd.nvwabao.Activity.Find24Hours;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.fragment.FindFragment;

import java.util.List;

/**
 * Created by 李超 on 2017/11/6.
 *
 * 发现模块功能列表的适配器
 *
 */

public class FindFunctionAdapter extends RecyclerView.Adapter <FindFunctionAdapter.ViewHolder>{

    //存放find页面所有功能的集合
    private List<FindFunction> mFunctionList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View functionView;
        ImageView functionImage;

        public ViewHolder(View view){
            super(view);
            functionView = view;
            functionImage = view.findViewById(R.id.find_function_itemImage);
        }
    }

    public FindFunctionAdapter(List<FindFunction> functionList){
        mFunctionList = functionList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_function_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);

        //备用，当图片和功能简介分离时使用
//        holder.functionView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                int position = holder.getAdapterPosition();
//                FindFunction findFunction = mFunctionList.get(position);
//                Toast.makeText(view.getContext(),"you clicked view",Toast.LENGTH_SHORT).show();
//            }
//        });


        holder.functionImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                FindFunction findFunction = mFunctionList.get(position);

                switch (position){
                    case 0 :
                        Intent intent = new Intent(view.getContext(), Find24Hours.class);
                        view.getContext().startActivity(intent);
                }



            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FindFunction findFunction = mFunctionList.get(position);
        holder.functionImage.setImageResource(findFunction.getImageId());
    }

    @Override
    public int getItemCount() {
        return mFunctionList.size();
    }


}




