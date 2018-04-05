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
import com.cxjd.nvwabao.bean.CirPingLun;
import com.cxjd.nvwabao.bean.Circles;
import com.cxjd.nvwabao.bean.PingLunPeople;


import java.util.List;

/**
 * 项目名： NvWaBao2
 * 包名：   com.cxjd.nvwabao.adapter
 * 文件名： CircleAdapter
 * 创建者： LC
 * 创建时间： 2018/3/26 21:21
 * 描述：   TODO
 */
public class CircleAdapter extends ArrayAdapter<Object>{

    private int resourceId;

    public CircleAdapter(@NonNull Context context, int textViewResourceId, List objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View  view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else{
            view = convertView;
        }

        if(resourceId == 2130968680){
            Circles circles = (Circles) getItem(position); //获取当前的
            ImageView headImage = view.findViewById(R.id.iv_cr_head);
            TextView titles = view.findViewById(R.id.cr_tv_title);
            TextView chengYuan = view.findViewById(R.id.cr_user);
            TextView tieZi = view.findViewById(R.id.cr_tie);
            headImage.setImageResource(circles.getHeadId());
            titles.setText(circles.getTitle());
            chengYuan.setText("成员  "+circles.getChengYuan());
            tieZi.setText("帖子  "+circles.getTieZi());
        }  else if (resourceId == 2130968681){
            CirPingLun pingLun = (CirPingLun) getItem(position);
            TextView name = view.findViewById(R.id.cr_pinglun_name);
            TextView address = view.findViewById(R.id.cr_pinglun_address);
            TextView pinglun = view.findViewById(R.id.cir_tv_pinglun);
            name.setText(pingLun.getName());
            address.setText(pingLun.getAddress());
            pinglun.setText(pingLun.getPinglun());
        } else {
            Log.i("res",resourceId+"");
            PingLunPeople pingLunPeople = (PingLunPeople) getItem(position);
            TextView name = view.findViewById(R.id.cr_tv_huifu_name);
            TextView data = view.findViewById(R.id.cr_pinglun_data);
            TextView pingLun = view.findViewById(R.id.cir_tv_pinglun_text);
            name.setText(pingLunPeople.getName());
            data.setText(pingLunPeople.getData());
            pingLun.setText(pingLunPeople.getPingLun());

        }
        return view;
    }




}
