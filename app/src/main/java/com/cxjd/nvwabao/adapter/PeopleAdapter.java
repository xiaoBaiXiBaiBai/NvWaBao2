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
import com.cxjd.nvwabao.bean.People;

import java.util.List;

/**
 * Created by Administrator on 2017/12/3.
 */

public class PeopleAdapter extends ArrayAdapter<People> {
    private  int reasourceId;
    public PeopleAdapter(@NonNull Context context, int resource, @NonNull List<People> objects) {
        super(context, resource, objects);
        reasourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        People People = getItem(position);
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
       viewHolder.fruitImage.setImageResource(People.getImageId());
       viewHolder.fruitName.setText(People.getName());
       return view;
    }
    class  ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
