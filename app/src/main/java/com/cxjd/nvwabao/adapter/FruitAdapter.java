package com.cxjd.nvwabao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.Fruit;

import java.util.List;

/**
 * Created by Administrator on 2017/12/3.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private  int reasourceId;
    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        reasourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
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
       viewHolder.fruitImage.setImageResource(fruit.getImageId());
       viewHolder.fruitName.setText(fruit.getName());
       return view;
    }
    class  ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
