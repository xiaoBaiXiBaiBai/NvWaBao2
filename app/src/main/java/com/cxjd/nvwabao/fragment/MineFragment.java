package com.cxjd.nvwabao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.cxjd.nvwabao.ActivityNews.LoginActivity;
import com.cxjd.nvwabao.ActivityNews.MycenterActivity;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.User;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 李超 on 2017/10/29.
 */

public class MineFragment extends Fragment{
    private TextView button;
    private ListView listView;
    TextView usernames,useraccount;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container,false);
        View mycenter=view.findViewById(R.id.shoucang_layout);
        button=view.findViewById(R.id.login);
        useraccount=view.findViewById(R.id.user_acc);
        usernames=view.findViewById(R.id.user_names);
        initstate();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        mycenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), MycenterActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initstate() {
        List<User> users= DataSupport.findAll(User.class);
        if (!users.isEmpty()){
            String useracco=users.get(0).getAccountNumbers();
            String username=users.get(0).getmName();
            useraccount.setText(useracco);
            usernames.setText(username);
            button.setVisibility(View.GONE);
        }else {
            useraccount.setVisibility(View.GONE);
            usernames.setText("未登录");
            button.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        initstate();
    }
}
