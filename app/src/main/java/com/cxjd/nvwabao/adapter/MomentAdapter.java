package com.cxjd.nvwabao.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.Moment;
import com.cxjd.nvwabao.bean.User;
import com.cxjd.nvwabao.fragment.findFunctions.OneHundred.U;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * Created by huangziwei on 16-4-12.
 */
public class MomentAdapter extends BaseAdapter {
    private User user= DataSupport.findFirst(User.class);
    List<User> userList=DataSupport.findAll(User.class);
    public static final int VIEW_HEADER = 0;
    public static final int VIEW_MOMENT = 1;


    private List<Moment> mList;
    private Context mContext;
    private CustomTagHandler mTagHandler;
    private int pageid;

    public MomentAdapter(Context context,int pageId, List<Moment> list, CustomTagHandler tagHandler) {
        mList = list;
        mContext = context;
        mTagHandler = tagHandler;
        this.pageid=pageId;
    }
    @Override
    public int getCount() {
        // heanderView
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_moment, null);
            ViewHolder holder = new ViewHolder();
            holder.mCommentList = (LinearLayout) convertView.findViewById(R.id.comment_list);
            holder.mBtnInput = convertView.findViewById(R.id.btn_input_comment);
            holder.mContent = (TextView) convertView.findViewById(R.id.content);
            holder.time=convertView.findViewById(R.id.time);
            holder.name=convertView.findViewById(R.id.name);
            holder.imagHit=convertView.findViewById(R.id.imagehit);
            holder.love_count=convertView.findViewById(R.id.love_hit);
            convertView.setTag(holder);
       }
        //防止ListView的OnItemClick与item里面子view的点击发生冲突
        ((ViewGroup) convertView).setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
            final ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mContent.setText(mList.get(position).mContent);
            holder.name.setText(mList.get(position).getAuthor().getmName());
            holder.time.setText(mList.get(position).getCreate_time());
            holder.love_count.setText(mList.get(position).getPraise_num()+"");
            if (mList.get(position).isIs_user_praise()==true){
                holder.imagHit.setImageResource(R.mipmap.zan);
            }else {
                holder.imagHit.setImageResource(R.mipmap.zanf);
            }
            holder.imagHit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (justIsLogin()==false){
                        Toast.makeText(mContext, "请先登录", Toast.LENGTH_SHORT).show();
                    }else {
                        if (mList.get(position).isIs_user_praise() == false) {
                            String url = "http://47.94.145.225/user/addCommentPraise/" + mList.get(position).getMomentId() + "/" + user.getmId();
                            smallHit(url);
                            holder.love_count.setText("");
                            holder.imagHit.setImageResource(R.mipmap.zan);
                            int i = mList.get(position).getPraise_num();
                            i++;
                            holder.love_count.setText(i + "");
                            Toast.makeText(mContext, "点赞成功", Toast.LENGTH_SHORT).show();
                            mList.get(position).setIs_user_praise(true);
                            mList.get(position).setPraise_num(i);
                            notifyDataSetChanged();
                        } else {
                            Toast.makeText(mContext, "你已经点过赞了", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
            CommentFun.parseCommentList(mContext,mList.get(position).getMomentId() , mList.get(position).mComment,
                    holder.mCommentList, holder.mBtnInput, mTagHandler);

        return convertView;
    }

    private static class ViewHolder {
        LinearLayout mCommentList;
        View mBtnInput;
        TextView mContent,name,time,love_count;
        ImageView imagHit;
    }
    private void smallHit(String url){

        HttpTitleUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }
    private boolean justIsLogin() {
        if (userList.isEmpty()||userList.size()<=0){
            return false;
        }else {
            return true;
        }
    }
}
