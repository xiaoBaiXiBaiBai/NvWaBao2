package com.cxjd.nvwabao.fragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cxjd.nvwabao.Activity.People;
import com.cxjd.nvwabao.R;

/**
 * Created by Administrator on 2017/11/27.
 */

public class womenFrontFragment extends Fragment {
    private ImageView allshenti,bozi1bu,xiong1bu,shoubi2bu,jian1bu,shoubi1bu,yaobu1bu,fubu1bu,shengzhiqi1bu,tuibu1bu,shouzuo1bu,shouyou1bu;
    private ImageView head,jingbu_hou,xiongbu_hou,zuoshoubi_hou,jian_hou,youshoubi_hou,yaobu_hou,fubu_hou,shengzhiqi_hou,tuibu_hou,zuoshou_hou,youshou_hou;
    private  View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.wff, container, false);
        init();

        allshenti.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (head.getVisibility()==View.INVISIBLE){
                   head.setVisibility(View.VISIBLE);
                   Intent intent = new Intent(getActivity(),People.class);
                   intent.putExtra("buwei",0);
                   startActivity(intent);
               }else {
                   head.setVisibility(View.INVISIBLE);
               }
               //head.setVisibility(View.INVISIBLE);
           }
       });
        bozi1bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jingbu_hou.getVisibility()==View.INVISIBLE){
                    jingbu_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",13);
                    startActivity(intent);
                }else {
                    jingbu_hou.setVisibility(View.INVISIBLE);
                }
                //head.setVisibility(View.INVISIBLE);
            }
        });
        xiong1bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xiongbu_hou.getVisibility()==View.INVISIBLE){
                    xiongbu_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",8);
                    startActivity(intent);
                }else {
                    xiongbu_hou.setVisibility(View.INVISIBLE);
                }
                //head.setVisibility(View.INVISIBLE);
            }
        });
        shoubi2bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zuoshoubi_hou.getVisibility()==View.INVISIBLE){
                    zuoshoubi_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",11);
                    startActivity(intent);
                }else {
                    zuoshoubi_hou.setVisibility(View.INVISIBLE);
                }
                //head.setVisibility(View.INVISIBLE);
            }
        });
        jian1bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jian_hou.getVisibility()==View.INVISIBLE){
                    jian_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",13);
                    startActivity(intent);
                }else {
                    jian_hou.setVisibility(View.INVISIBLE);
                }
                //head.setVisibility(View.INVISIBLE);
            }
        });
        shoubi1bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (youshoubi_hou.getVisibility()==View.INVISIBLE){
                    youshoubi_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",11);
                    startActivity(intent);
                }else {
                    youshoubi_hou.setVisibility(View.INVISIBLE);
                }
                //head.setVisibility(View.INVISIBLE);
            }
        });
        yaobu1bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yaobu_hou.getVisibility()==View.INVISIBLE){
                    yaobu_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",14);
                    startActivity(intent);
                }else {
                    yaobu_hou.setVisibility(View.INVISIBLE);
                }
                //head.setVisibility(View.INVISIBLE);
            }
        });
        fubu1bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fubu_hou.getVisibility()==View.INVISIBLE){
                    fubu_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",9);
                    startActivity(intent);
                }else {
                    fubu_hou.setVisibility(View.INVISIBLE);
                }
                //head.setVisibility(View.INVISIBLE);
            }
        });
        shengzhiqi1bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shengzhiqi_hou.getVisibility()==View.INVISIBLE){
                    shengzhiqi_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",21);
                    startActivity(intent);
                }else {
                    shengzhiqi_hou.setVisibility(View.INVISIBLE);
                }
                //head.setVisibility(View.INVISIBLE);
            }
        });
        tuibu1bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tuibu_hou.getVisibility()==View.INVISIBLE){
                    tuibu_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",12);
                    startActivity(intent);
                }else {
                    tuibu_hou.setVisibility(View.INVISIBLE);
                }
                //head.setVisibility(View.INVISIBLE);
            }
        });
        shouzuo1bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zuoshou_hou.getVisibility()==View.INVISIBLE){
                    zuoshou_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",11);
                    startActivity(intent);
                }else {
                    zuoshou_hou.setVisibility(View.INVISIBLE);
                }
                //head.setVisibility(View.INVISIBLE);
            }
        });
        shouyou1bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (youshou_hou.getVisibility()==View.INVISIBLE){
                    youshou_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",11);
                    startActivity(intent);
                }else {
                    youshou_hou.setVisibility(View.INVISIBLE);
                }
                //head.setVisibility(View.INVISIBLE);
            }
        });
        return view;
    }

    private void init() {
        allshenti = (ImageView) view.findViewById(R.id.allshenti);
        bozi1bu = (ImageView) view.findViewById(R.id.bozi1bu);
        xiong1bu = (ImageView) view.findViewById(R.id.xiong1bu);
        shoubi2bu = (ImageView) view.findViewById(R.id.shoubi2bu);
        jian1bu  = (ImageView) view.findViewById(R.id.jian1bu);
        shoubi1bu  = (ImageView) view.findViewById(R.id.shoubi1bu);
        yaobu1bu = (ImageView) view.findViewById(R.id.yaobu1bu);
        fubu1bu  = (ImageView) view.findViewById(R.id.fubu1bu);
        shengzhiqi1bu = (ImageView) view.findViewById(R.id.shengzhiqi1bu);
        tuibu1bu = (ImageView) view.findViewById(R.id.tuibu1bu);
        shouzuo1bu = (ImageView) view.findViewById(R.id.shouzuo1bu);
        shouyou1bu = (ImageView) view.findViewById(R.id.shouyou1bu);


        head = (ImageView) view.findViewById(R.id.head);
        jingbu_hou= (ImageView) view.findViewById(R.id.jingbu_hou);
        xiongbu_hou= (ImageView) view.findViewById(R.id.xiongbu_hou);
        zuoshoubi_hou= (ImageView) view.findViewById(R.id.zuoshoubi_hou);
        jian_hou= (ImageView) view.findViewById(R.id.jian_hou);
        youshoubi_hou= (ImageView) view.findViewById(R.id.youshoubi_hou);
        yaobu_hou= (ImageView) view.findViewById(R.id.yaobu_hou);
        fubu_hou= (ImageView) view.findViewById(R.id.fubu_hou);
        shengzhiqi_hou= (ImageView) view.findViewById(R.id.shengzhiqi_hou);
        tuibu_hou= (ImageView) view.findViewById(R.id.tuibu_hou);
        zuoshou_hou= (ImageView) view.findViewById(R.id.zuoshou_hou);
        youshou_hou= (ImageView) view.findViewById(R.id.youshou_hou);

        head.setVisibility(View.INVISIBLE);
        jingbu_hou.setVisibility(View.INVISIBLE);
        xiongbu_hou.setVisibility(View.INVISIBLE);
        zuoshoubi_hou.setVisibility(View.INVISIBLE);
        jian_hou.setVisibility(View.INVISIBLE);
        youshoubi_hou.setVisibility(View.INVISIBLE);
        yaobu_hou.setVisibility(View.INVISIBLE);
        fubu_hou.setVisibility(View.INVISIBLE);
        shengzhiqi_hou.setVisibility(View.INVISIBLE);
        tuibu_hou.setVisibility(View.INVISIBLE);
        zuoshou_hou.setVisibility(View.INVISIBLE);
        youshou_hou.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onResume() {
        super.onResume();
        head.setVisibility(View.INVISIBLE);
        jingbu_hou.setVisibility(View.INVISIBLE);
        xiongbu_hou.setVisibility(View.INVISIBLE);
        zuoshoubi_hou.setVisibility(View.INVISIBLE);
        jian_hou.setVisibility(View.INVISIBLE);
        youshoubi_hou.setVisibility(View.INVISIBLE);
        yaobu_hou.setVisibility(View.INVISIBLE);
        fubu_hou.setVisibility(View.INVISIBLE);
        shengzhiqi_hou.setVisibility(View.INVISIBLE);
        tuibu_hou.setVisibility(View.INVISIBLE);
        zuoshou_hou.setVisibility(View.INVISIBLE);
        youshou_hou.setVisibility(View.INVISIBLE);
    }

}
