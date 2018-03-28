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

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.PeopleReturn;

import java.util.List;

/**
 * Created by 白 on 2018/3/20.
 * 圈子聊天列表适配器
 */

public class PeopleChatAdapter extends ArrayAdapter<PeopleReturn> {

    private int resourceId;



    public PeopleChatAdapter(Context context,int textViewResourceId, List<PeopleReturn> objects) {
        super(context,textViewResourceId, objects);

        resourceId = textViewResourceId;//获取子布局
    }

    @Override       //getView方法在每个子项被滚动到屏幕内的时候都会被调用，每次都将布局重新加载一边
    public View getView(int position, View convertView,ViewGroup parent) {

        View view;
        //实例ViewHolder，当程序第一次运行，保存获取到的控件，提高效率
        ViewHolder viewHolder;

        if(convertView==null){
            viewHolder=new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder.ivImage = (ImageView) view.findViewById(R.id.ivImage);//获取控件,只需要调用一遍，调用过后保存在ViewHolder中
            viewHolder.tvName = (TextView) view.findViewById(R.id.tvName);   //获取控件
            viewHolder.chat_dec = (TextView) view.findViewById(R.id.chat_dec);
            view.setTag(viewHolder);
        }else{
            view=convertView;           //convertView不为空代表布局被加载过，只需要将convertView的值取出即可
            viewHolder=(ViewHolder) view.getTag();
        }

        PeopleReturn peopleReturn = getItem(position);

        viewHolder.ivImage.setImageResource(peopleReturn.getImageId());
        viewHolder.tvName.setText(peopleReturn.getReturnName());
        viewHolder.chat_dec.setText(peopleReturn.getReturnChat());

        return view;
    }



    class ViewHolder{ //当布局加载过后，保存获取到的控件信息
        ImageView ivImage;
        TextView tvName;
        TextView chat_dec;

    }

}

