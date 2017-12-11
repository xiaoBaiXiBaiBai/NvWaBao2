package com.cxjd.nvwabao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cxjd.nvwabao.ActivityNews.RegisterActivity;
import com.cxjd.nvwabao.R;

/**
 * Created by 李超 on 2017/10/29.
 */

public class MineFragment extends Fragment implements View.OnClickListener{
    private EditText user_name,user_password;
    private Button commit_btn,clear_btn1,clear_btn2;
    private TextView foget_pass,new_user;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container,false);
        init(view);
        return view;
    }

    private void init(View view) {
        user_name=view.findViewById(R.id.user_name);
        user_password=view.findViewById(R.id.user_password);
        commit_btn=view.findViewById(R.id.commit_btn);
        clear_btn1=view.findViewById(R.id.clear_btn1);
        clear_btn2=view.findViewById(R.id.clear_btn2);
        foget_pass=view.findViewById(R.id.wjmm);
        new_user=view.findViewById(R.id.tv_newuser);

        new_user.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_newuser:
                Intent intent=new Intent(getActivity(),RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
