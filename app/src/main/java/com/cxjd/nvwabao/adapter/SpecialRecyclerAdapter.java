package com.cxjd.nvwabao.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.FocusTitle;
import com.cxjd.nvwabao.utils.TitleListManagr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abu on 2017/10/7.
 */

public class SpecialRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<FocusTitle> list;
    Context context;
     List<FocusTitle> cgList=new ArrayList<>();
    public enum IS_TITLE{
        TITLE_IS,
        TITE_NO
    }

    public SpecialRecyclerAdapter() {
    }

    public SpecialRecyclerAdapter(List<FocusTitle> list, Context context) {
        this.list = list;
        this.context=context;
    }
    public void setCgList(){
        if (cgList!=null)
            cgList.clear();
        for (int i=0;i<list.size();i++){
            if (list.get(i).getTitle_check()==FocusTitle.TITLE_CHECKED){
                cgList.add(list.get(i));
            }
        }
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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final int posi=holder.getAdapterPosition();
        if (holder instanceof ViewHolderTitle){
            FocusTitle focusTitle=list.get(position);
            ((ViewHolderTitle) holder).textTitle.setText(focusTitle.getTitleName());
        }
        if (holder instanceof ViewHolderDate){
            FocusTitle focusTitle=list.get(position);
            ((ViewHolderDate) holder).textView.setText(focusTitle.getTitleName());
            if (focusTitle.getTitle_check()==FocusTitle.TITLE_CHECKED) {
                ((ViewHolderDate) holder).box.setChecked(true);
            }
            else {
                ((ViewHolderDate) holder).box.setChecked(false);
            }
            ((ViewHolderDate) holder).box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b){
                        list.get(posi).setTitle_check(FocusTitle.TITLE_CHECKED);
                    }else{
                        list.get(posi).setTitle_check(FocusTitle.TITLE_NOCHECKED);
                    }
                    TitleListManagr.saveTitleList(list,context,TitleListManagr.str_all);
                    setCgList();
                    TitleListManagr.saveTitleList(cgList,context,TitleListManagr.str_show);
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getTitleState()==FocusTitle.TITLE_STATE_IS)
            return IS_TITLE.TITLE_IS.ordinal();
        else
            return IS_TITLE.TITE_NO.ordinal();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
