package com.cxjd.nvwabao.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.ActivityNews.TitleStateActivity;
import com.cxjd.nvwabao.bean.FocusTitle;
import com.cxjd.nvwabao.helper.OnDragVHListener;
import com.cxjd.nvwabao.helper.OnItemMoveListener;

import java.util.List;


/**
 * 仅拖拽排序
 * Created by YoKeyword on 16/1/4.
 */
public class DragAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnItemMoveListener {
    enum SS {
        TYPE_TITLE,
        TYPR_ITEM
    };
    public static final int TYPR_ITEM=1;
    public static final int TYPE_TITLE=0;
    private boolean isEditMode;
    private List<FocusTitle> mItems;
    private LayoutInflater mInflater;
    private Context context;
    public DragAdapter(Context context, List<FocusTitle> items) {
        this.context=context;
        mInflater = LayoutInflater.from(context);
        this.mItems = items;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0)
            return TYPE_TITLE;
        else
            return TYPR_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view;
        switch (viewType) {
            case TYPE_TITLE:
                view = mInflater.inflate(R.layout.item_my_item_header, parent, false);
                final TitleViewHolder titleViewHolder = new TitleViewHolder(view);
                titleViewHolder.btn_edt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!isEditMode) {
                            startEditMode((RecyclerView) parent);
                            titleViewHolder.btn_edt.setText(R.string.finish);
                        } else {
                            cancelEditMode((RecyclerView) parent);
                            titleViewHolder.btn_edt.setText(R.string.edit);
                        }
                    }
                });
               titleViewHolder.add_more.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //callback.onClick(view,holder.getAdapterPosition());
                        Intent intent=new Intent(view.getContext(),TitleStateActivity.class);
                        view.getContext().startActivity(intent);
                    }
                });
                return titleViewHolder;
            case TYPR_ITEM:
                view = mInflater.inflate(R.layout.item_my, parent, false);
                final DragViewHolder viewHolder = new DragViewHolder(view);
                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        moveMyToOther(viewHolder);
                    }
                });
                return viewHolder;
        }
        return null;
    }
   /* public interface OnItemClickCallback<T> {
        // 点击事件
        void onClick(View view , T info);
    }
    // 申明一个点击事件接口变量
    private OnItemClickCallback callback = null;
    public void ItemClick(Context ctx, OnItemClickCallback clickCallback){
        this.callback = clickCallback;
    }*/
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TitleViewHolder){
            if (isEditMode) {
                ((TitleViewHolder) holder).btn_edt.setText(R.string.finish);
            } else {
                ((TitleViewHolder) holder).btn_edt.setText(R.string.edit);
            }
        }if (holder instanceof DragViewHolder){
            ((DragViewHolder) holder).tv.setText(mItems.get(position).getTitleName());
            if (isEditMode) {
                ((DragViewHolder) holder).imageView.setVisibility(View.VISIBLE);
            } else {
                ((DragViewHolder) holder).imageView.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
       FocusTitle item = mItems.get(fromPosition);
        mItems.remove(fromPosition);
        mItems.add(toPosition, item);
        notifyItemMoved(fromPosition, toPosition);
    }

    private void startEditMode(RecyclerView parent) {
        isEditMode = true;

        int visibleChildCount = parent.getChildCount();
        for (int i = 0; i < visibleChildCount; i++) {
            View view = parent.getChildAt(i);
            ImageView imgEdit = (ImageView) view.findViewById(R.id.img_edit);
            if (imgEdit != null) {
                imgEdit.setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * 完成编辑模式
     *
     * @param parent
     */
    private void cancelEditMode(RecyclerView parent) {
        isEditMode = false;

        int visibleChildCount = parent.getChildCount();
        for (int i = 0; i < visibleChildCount; i++) {
            View view = parent.getChildAt(i);
            ImageView imgEdit = (ImageView) view.findViewById(R.id.img_edit);
            if (imgEdit != null) {
                imgEdit.setVisibility(View.INVISIBLE);
            }
        }
    }
    class DragViewHolder extends RecyclerView.ViewHolder implements OnDragVHListener {
        TextView tv;
        ImageView imageView;
        public DragViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            imageView= (ImageView) itemView.findViewById(R.id.img_edit);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemFinish() {
            itemView.setBackgroundColor(0);
        }

    }
    class TitleViewHolder extends RecyclerView.ViewHolder{
        TextView btn_edt;
        TextView add_more;
        public TitleViewHolder(View itemView) {
            super(itemView);
            btn_edt= (TextView) itemView.findViewById(R.id.tv_btn_edit);
            add_more=itemView.findViewById(R.id.add_more);
        }
    }
    private void moveMyToOther(DragViewHolder myHolder) {
        int position = myHolder.getAdapterPosition();
        mItems.remove(position);
        notifyDataSetChanged();
    }
}
