package com.cxjd.nvwabao.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.nvwabao.Activity.PeopleChatActivity;
import com.cxjd.nvwabao.Activity.PeopleInfoActivity;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.PeopleChat;

import java.util.List;

/**
 * Created by 白 on 2018/3/26.
 * <p>
 * 圈子中 动态的 适配器
 */

public class CircleFragmentAdapter extends ArrayAdapter<PeopleChat>  {

    private int resourceId;
    private List<PeopleChat> peopleChatList;


    private Context mContext;

    private int positionBB;   //单行序列数

    public CircleFragmentAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<PeopleChat> objects) {
        //初始化数据
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
        peopleChatList = objects;
        mContext = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        //实例ViewHolder，当程序第一次运行，保存获取到的控件，提高效率
        ViewHolder viewHolder;

        if(convertView==null){
            viewHolder=new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder.image_people = (ImageView) view.findViewById(R.id.image_people);//获取控件,只需要调用一遍，调用过后保存在ViewHolder中
            viewHolder.name_people = (TextView) view.findViewById(R.id.name_people);   //获取控件
            viewHolder.chat_people = (TextView) view.findViewById(R.id.chat_people);
            viewHolder.go_people = (ImageView) view.findViewById(R.id.go_people);
            viewHolder.address_people = (TextView) view.findViewById(R.id.address_people);
            viewHolder.from_people = (TextView) view.findViewById(R.id.from_people);


            view.setTag(viewHolder);
        }else{
            view=convertView;           //convertView不为空代表布局被加载过，只需要将convertView的值取出即可
            viewHolder=(ViewHolder) view.getTag();
        }

        PeopleChat peopleChat = getItem(position);

        viewHolder.image_people.setImageResource(peopleChat.getImageId());
        viewHolder.name_people.setText(peopleChat.getName());
        viewHolder.chat_people.setText(peopleChat.getChat());
        viewHolder.address_people.setText(peopleChat.getAddress());
        viewHolder.from_people.setText(peopleChat.getFrom());

        //positionBB = position;

        viewHolder.image_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                PeopleChat peopleChat = peopleChatList.get(position);
                Intent intent = new Intent(mContext, PeopleInfoActivity.class);
                Log.i("i", "onClick: 传递的id为+++++"+peopleChat.getPeopleId());
                bundle.putInt("id", peopleChat.getPeopleId());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
        viewHolder.chat_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                PeopleChat peopleChat = peopleChatList.get(position);
                Intent intent = new Intent(mContext, PeopleChatActivity.class);
                bundle.putInt("id", peopleChat.getPeopleId());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
       viewHolder.go_people.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Bundle bundle = new Bundle();
               PeopleChat peopleChat = peopleChatList.get(position);
               Intent intent = new Intent(mContext, PeopleChatActivity.class);
               bundle.putInt("id", peopleChat.getPeopleId());
               intent.putExtras(bundle);
               mContext.startActivity(intent);
           }
       });

        return view;

    }

    class ViewHolder{ //当布局加载过后，保存获取到的控件信息
        ImageView image_people;
        TextView name_people;
        TextView chat_people;
        ImageView go_people;
        TextView address_people;
        TextView from_people;

    }

}
