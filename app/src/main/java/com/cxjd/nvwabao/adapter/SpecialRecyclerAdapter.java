package com.cxjd.nvwabao.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.FocusTitle;

import java.util.List;

/**
 * Created by abu on 2017/10/7.
 */

public class SpecialRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<FocusTitle> list;
    private TextView textTitle,textView;
    public enum IS_TITLE{
        TITLE_IS,
        TITE_NO
    }
    public SpecialRecyclerAdapter(List<FocusTitle> list) {
        this.list = list;
    }
    public class ViewHolderTitle extends RecyclerView.ViewHolder{
        public ViewHolderTitle(View itemView) {
            super(itemView);
            textTitle= (TextView) itemView.findViewById(R.id.hometab1_theme_title);
        }
    }
    public class ViewHolderDate extends RecyclerView.ViewHolder{
        public ViewHolderDate(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.item_title);
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
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) ==IS_TITLE.TITLE_IS.ordinal()
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderTitle){
            FocusTitle focusTitle=list.get(position);
            textTitle.setText(focusTitle.getTitleName());
        }
        if (holder instanceof ViewHolderDate){
            FocusTitle focusTitle=list.get(position);
            textView.setText(focusTitle.getTitleName());
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getTitleState()=="GROUP_NAME")
            return IS_TITLE.TITLE_IS.ordinal();

        else
            return IS_TITLE.TITE_NO.ordinal();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
