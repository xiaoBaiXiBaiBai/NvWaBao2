package com.cxjd.nvwabao.bean;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cxjd.nvwabao.Activity.EatingUtensils;
import com.cxjd.nvwabao.Activity.Find24Hours;
import com.cxjd.nvwabao.Activity.FirstAid;
import com.cxjd.nvwabao.Activity.FourAndFive;
import com.cxjd.nvwabao.Activity.GoldMedalTally;
import com.cxjd.nvwabao.Activity.OneHundred;
import com.cxjd.nvwabao.Activity.Physical;
import com.cxjd.nvwabao.Activity.SevenNutriens;
import com.cxjd.nvwabao.Activity.ShengOrKe;
import com.cxjd.nvwabao.R;

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
                        break;
                    case 1 :
                        Intent intent1 = new Intent(view.getContext(), FourAndFive.class);
                        view.getContext().startActivity(intent1);
                        break;
                    case 2 :
                        Intent intent2 = new Intent(view.getContext(), ShengOrKe.class);
                        view.getContext().startActivity(intent2);
                        break;
                    case 3 :
                        Intent intent3 = new Intent(view.getContext(), GoldMedalTally.class);
                        view.getContext().startActivity(intent3);
                        break;
                    case 4 :
                        Intent intent4 = new Intent(view.getContext(), FirstAid.class);
                        view.getContext().startActivity(intent4);
                        break;
                    case 5 :
                        Intent intent5 = new Intent(view.getContext(), Physical.class);
                        view.getContext().startActivity(intent5);
                        break;
                    case 6 :
                        Intent intent6 = new Intent(view.getContext(), EatingUtensils.class);
                        view.getContext().startActivity(intent6);
                        break;
                    case 7 :
                        Intent intent7 = new Intent(view.getContext(), SevenNutriens.class);
                        view.getContext().startActivity(intent7);
                        break;
                    case 8 :
                        Intent intent8 = new Intent(view.getContext(), OneHundred.class);
                        view.getContext().startActivity(intent8);
                        break;
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




