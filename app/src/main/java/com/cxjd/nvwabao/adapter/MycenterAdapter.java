package com.cxjd.nvwabao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.cxjd.nvwabao.fragment.MineFragment;

/**
 * Created by abu on 2017/12/13.
 */

public class MycenterAdapter extends ArrayAdapter {
    private int resourceId;
    public MycenterAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        return view;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
