package com.cxjd.nvwabao.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.TitleBean;
import com.cxjd.nvwabao.bean.TitleLable;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by abu on 2017/10/7.
 */

public class SpecialRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TitleBean> list;
    private ListDataSave listDataSave;
    Context context;
    public enum IS_TITLE{
        TITLE_IS,
        TITE_NO
    }
    public SpecialRecyclerAdapter(List<TitleBean> list, Context context) {
        this.list = list;
        this.context=context;
        listDataSave=new ListDataSave(context,"MyItem");
    }

    public class ViewHolderTitle extends RecyclerView.ViewHolder{
         TextView textTitle;
        public ViewHolderTitle(View itemView) {
            super(itemView);
            textTitle= (TextView) itemView.findViewById(R.id.hometab1_theme_title);
        }
    }
    public class ViewHolderDate extends RecyclerView.ViewHolder{
        TextView textView;
        CheckBox box;
        public ViewHolderDate(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.item_title);
            box=itemView.findViewById(R.id.item_state);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==IS_TITLE.TITLE_IS.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videothemelist, parent, false);
            return new ViewHolderTitle(view);
        }else if (viewType==IS_TITLE.TITE_NO.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_recycler_item, parent, false);
            return new ViewHolderDate(view);
        }
        return null;
    }
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        list=DataSupport.findAll(TitleBean.class);
        if (holder instanceof ViewHolderTitle){
            TitleBean focusTitle=list.get(position);
            ((ViewHolderTitle) holder).textTitle.setText(focusTitle.getTitleName());
        }
        else if (holder instanceof ViewHolderDate){
            TitleBean focusTitle=list.get(position);
            ((ViewHolderDate) holder).textView.setText(focusTitle.getTitleName());
            if (focusTitle.getTitle_check()==0) {
                ((ViewHolderDate) holder).box.setChecked(false);
            }
            else {
                ((ViewHolderDate) holder).box.setChecked(true);
            }
            ((ViewHolderDate) holder).box.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (((ViewHolderDate) holder).box.isChecked()) {
                        ContentValues values=new ContentValues();
                        values.put("title_check",1);
                        DataSupport.updateAll(TitleBean.class,values,"titlename = ?",list.get(position).getTitleName());
                        TitleLable titleLable=new TitleLable(list.get(position).getTitleName(),
                                list.get(position).getTitleCategery(),1,
                                list.get(position).getTitleLable());
                        titleLable.save();
                        List<TitleLable> titleLableList=DataSupport.findAll(TitleLable.class);
                        listDataSave.setDataList("TitleLable",titleLableList);
                    }else {
                        ContentValues values = new ContentValues();
                        values.put("title_check", 0);
                        DataSupport.updateAll(TitleBean.class, values, "titlename = ?", list.get(position).getTitleName());
                        DataSupport.deleteAll(TitleLable.class, "titlename=?", list.get(position).getTitleName());
                        List<TitleLable> titleLableList=DataSupport.findAll(TitleLable.class);
                        listDataSave.setDataList("TitleLable",titleLableList);
                    }
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getTitleLable().equals("GROUP_NAME"))
            return IS_TITLE.TITLE_IS.ordinal();
        else
            return IS_TITLE.TITE_NO.ordinal();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
