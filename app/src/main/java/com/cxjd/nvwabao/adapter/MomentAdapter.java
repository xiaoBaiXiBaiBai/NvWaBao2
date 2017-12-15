package com.cxjd.nvwabao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.Moment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by huangziwei on 16-4-12.
 */
public class MomentAdapter extends BaseAdapter {

    public static final int VIEW_HEADER = 0;
    public static final int VIEW_MOMENT = 1;


    private List<Moment> mList;
    private Context mContext;
    private CustomTagHandler mTagHandler;

    public MomentAdapter(Context context, List<Moment> list, CustomTagHandler tagHandler) {
        mList = list;
        mContext = context;
        mTagHandler = tagHandler;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
                convertView = View.inflate(mContext, R.layout.item_moment, null);
                ViewHolder holder = new ViewHolder();
                holder.mCommentList = (LinearLayout) convertView.findViewById(R.id.comment_list);
                holder.mBtnInput = convertView.findViewById(R.id.btn_input_comment);
                holder.mContent = (TextView) convertView.findViewById(R.id.content);
                holder.commenttime=convertView.findViewById(R.id.time);
                holder.username=convertView.findViewById(R.id.name);
                convertView.setTag(holder);
       }
        //防止ListView的OnItemClick与item里面子view的点击发生冲突
        ((ViewGroup) convertView).setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
            int index = position;
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mContent.setText(mList.get(index).mContent);
            holder.username.setText(mList.get(index).getAuthor().getmName());
            holder.commenttime.setText(mList.get(index).getCreate_time());
            CommentFun.parseCommentList(mContext, mList.get(index).mComment,
                    holder.mCommentList, holder.mBtnInput, mTagHandler);
        return convertView;
    }

    private static class ViewHolder {
        LinearLayout mCommentList;
        View mBtnInput;
        TextView mContent;
        TextView username,commenttime;
    }
}
