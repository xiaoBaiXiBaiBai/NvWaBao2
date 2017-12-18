package com.cxjd.nvwabao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cxjd.nvwabao.Activity.FoodInfoActivity;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.Fruit;
import com.cxjd.nvwabao.bean.Fruit2;

import java.util.List;

import javax.security.auth.login.LoginException;

/**
 * Created by Administrator on 2017/12/3.
 */

public class Fruit2Adapter extends ArrayAdapter<Fruit2> {
    private  int reasourceId;
    private Context contextCC;
    public Fruit2Adapter(@NonNull Context context, int resource, @NonNull List<Fruit2> objects) {
        super(context, resource, objects);
        reasourceId = resource;
        contextCC = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit2 fruit = getItem(position);
        View view;
       ViewHolder viewHolder;
       if (convertView==null){
           view = LayoutInflater.from(getContext()).inflate(reasourceId,parent,false);
           viewHolder = new ViewHolder();
           viewHolder.fruitImage = view.findViewById(R.id.fruit_image);
           viewHolder.fruitName = view.findViewById(R.id.fruit_name);
           view.setTag(viewHolder);
       }else {
           view = convertView;
           viewHolder = (ViewHolder)view.getTag();
       }
       //viewHolder.fruitImage.setImageResource(fruit.getImageId());
        Glide.with(contextCC).load(fruit.getImageId()).into(viewHolder.fruitImage);

       viewHolder.fruitName.setText(fruit.getName());
       return view;
    }
    class  ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
