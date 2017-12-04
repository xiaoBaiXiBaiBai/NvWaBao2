package com.cxjd.nvwabao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.ListView;

import java.util.List;

/**
 * Created by 李超 on 2017/12/3.
 */

public class ListViewAdapter  extends ArrayAdapter<ListView> {

    //用于存储ListView子项布局id
    private int resourceId;

    /**
     * 将子项与ListView绑定起来
     *
     * @param context  上下文
     * @param textViewResourceId  子项布局ID
     * @param objects  ListView组件对象
     */
    public ListViewAdapter (Context context, int textViewResourceId, List<ListView> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ListView listView = getItem(position);
       // View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        } else {
            view = convertView;
        }
        TextView itemName = view.findViewById(R.id.fragment_listview_item_name);
        itemName.setText(listView.getName());
        return view;
    }
}
