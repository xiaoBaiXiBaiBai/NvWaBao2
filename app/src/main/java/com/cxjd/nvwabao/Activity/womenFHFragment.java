package com.cxjd.nvwabao.Activity;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cxjd.nvwabao.R;

/**
 * Created by Administrator on 2017/11/27.
 */

public class womenFHFragment extends Fragment {
    private ImageView tou_fan_qian,jingbu_fan_qian,jian_fan_qian,biebu_fan_qian,yaobu_fan_qian,yaobuwei_fan_qian,tunbu_fan_qian,tuibu_fan_qian,zuoshoubi_fan_qian,youshoubi_fan_qian,zuoshou_fan_qian,youshou_fan_qian;
    private ImageView tou_fan_hou,jingbu_fan_hou,jian_fan_hou,biebu_fan_hou,yaobu_fan_hou,yaobuwei_fan_hou,tunbu_fan_hou,tuibu_fan_hou,zuoshoubi_fan_hou,youshoubi_hou,zuoshou_fan_hou,youshou_fan_hou;
    private  View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.wfh, container, false);
        init();

        tou_fan_qian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tou_fan_hou.getVisibility()==View.INVISIBLE){
                    tou_fan_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",0);
                    startActivity(intent);
                }else {
                    tou_fan_hou.setVisibility(View.INVISIBLE);
                }
                //tou_fan_hou.setVisibility(View.INVISIBLE);
            }
        });
        jingbu_fan_qian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jingbu_fan_hou.getVisibility()==View.INVISIBLE){
                    jingbu_fan_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",13);
                    startActivity(intent);
                }else {
                    jingbu_fan_hou.setVisibility(View.INVISIBLE);
                }
                //tou_fan_hou.setVisibility(View.INVISIBLE);
            }
        });
        jian_fan_qian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jian_fan_hou.getVisibility()==View.INVISIBLE){
                    jian_fan_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",13);
                    startActivity(intent);
                }else {
                    jian_fan_hou.setVisibility(View.INVISIBLE);
                }
                //tou_fan_hou.setVisibility(View.INVISIBLE);
            }
        });
        biebu_fan_qian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (biebu_fan_hou.getVisibility()==View.INVISIBLE){
                    biebu_fan_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",15);
                    startActivity(intent);
                }else {
                    biebu_fan_hou.setVisibility(View.INVISIBLE);
                }
                //tou_fan_hou.setVisibility(View.INVISIBLE);
            }
        });
        yaobu_fan_qian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yaobu_fan_hou.getVisibility()==View.INVISIBLE){
                    yaobu_fan_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",14);
                    startActivity(intent);
                }else {
                    yaobu_fan_hou.setVisibility(View.INVISIBLE);
                }
                //tou_fan_hou.setVisibility(View.INVISIBLE);
            }
        });
        yaobuwei_fan_qian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yaobuwei_fan_hou.getVisibility()==View.INVISIBLE){
                    yaobuwei_fan_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",14);
                    startActivity(intent);
                }else {
                    yaobuwei_fan_hou.setVisibility(View.INVISIBLE);
                }
                //tou_fan_hou.setVisibility(View.INVISIBLE);
            }
        });
        tunbu_fan_qian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tunbu_fan_hou.getVisibility()==View.INVISIBLE){
                    tunbu_fan_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",16);
                    startActivity(intent);
                }else {
                    tunbu_fan_hou.setVisibility(View.INVISIBLE);
                }
                //tou_fan_hou.setVisibility(View.INVISIBLE);
            }
        });
        tuibu_fan_qian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tuibu_fan_hou.getVisibility()==View.INVISIBLE){
                    tuibu_fan_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",12);
                    startActivity(intent);
                }else {
                    tuibu_fan_hou.setVisibility(View.INVISIBLE);
                }
                //tou_fan_hou.setVisibility(View.INVISIBLE);
            }
        });
        zuoshoubi_fan_qian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zuoshoubi_fan_hou.getVisibility()==View.INVISIBLE){
                    zuoshoubi_fan_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",11);
                    startActivity(intent);
                }else {
                    zuoshoubi_fan_hou.setVisibility(View.INVISIBLE);
                }
                //tou_fan_hou.setVisibility(View.INVISIBLE);
            }
        });
        youshoubi_fan_qian.setOnClickListener(new View.OnClickListener() {
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
                //tou_fan_hou.setVisibility(View.INVISIBLE);
            }
        });
        zuoshou_fan_qian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zuoshou_fan_hou.getVisibility()==View.INVISIBLE){
                    zuoshou_fan_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",11);
                    startActivity(intent);
                }else {
                    zuoshou_fan_hou.setVisibility(View.INVISIBLE);
                }
                //tou_fan_hou.setVisibility(View.INVISIBLE);
            }
        });
        youshou_fan_qian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (youshou_fan_hou.getVisibility()==View.INVISIBLE){
                    youshou_fan_hou.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(),People.class);
                    intent.putExtra("buwei",11);
                    startActivity(intent);
                }else {
                    youshou_fan_hou.setVisibility(View.INVISIBLE);
                }
                //tou_fan_hou.setVisibility(View.INVISIBLE);
            }
        });
        return view;
    }

    private void init() {
        tou_fan_qian = (ImageView) view.findViewById(R.id.tou_fan_qian);
        jingbu_fan_qian = (ImageView) view.findViewById(R.id.jingbu_fan_qian);
        jian_fan_qian = (ImageView) view.findViewById(R.id.jian_fan_qian);
        biebu_fan_qian = (ImageView) view.findViewById(R.id.biebu_fan_qian);
        yaobu_fan_qian  = (ImageView) view.findViewById(R.id.yaobu_fan_qian);
        yaobuwei_fan_qian  = (ImageView) view.findViewById(R.id.yaobuwei_fan_qian);
        tunbu_fan_qian = (ImageView) view.findViewById(R.id.tunbu_fan_qian);
        tuibu_fan_qian  = (ImageView) view.findViewById(R.id.tuibu_fan_qian);
        zuoshoubi_fan_qian = (ImageView) view.findViewById(R.id.zuoshoubi_fan_qian);
        youshoubi_fan_qian = (ImageView) view.findViewById(R.id.youshoubi_fan_qian);
        zuoshou_fan_qian = (ImageView) view.findViewById(R.id.zuoshou_fan_qian);
        youshou_fan_qian = (ImageView) view.findViewById(R.id.youshou_fan_qian);


        tou_fan_hou = (ImageView) view.findViewById(R.id.tou_fan_hou);
        jingbu_fan_hou= (ImageView) view.findViewById(R.id.jingbu_fan_hou);
        jian_fan_hou= (ImageView) view.findViewById(R.id.jian_fan_hou);
        biebu_fan_hou= (ImageView) view.findViewById(R.id.biebu_fan_hou);
        yaobu_fan_hou= (ImageView) view.findViewById(R.id.yaobu_fan_hou);
        yaobuwei_fan_hou= (ImageView) view.findViewById(R.id.yaobuwei_fan_hou);
        tunbu_fan_hou= (ImageView) view.findViewById(R.id.tunbu_fan_hou);
        tuibu_fan_hou= (ImageView) view.findViewById(R.id.tuibu_fan_hou);
        zuoshoubi_fan_hou= (ImageView) view.findViewById(R.id.zuoshoubi_fan_hou);
        youshoubi_hou= (ImageView) view.findViewById(R.id.youshoubi_hou);
        zuoshou_fan_hou= (ImageView) view.findViewById(R.id.zuoshou_fan_hou);
        youshou_fan_hou= (ImageView) view.findViewById(R.id.youshou_fan_hou);



        tou_fan_hou.setVisibility(View.INVISIBLE);
        jingbu_fan_hou.setVisibility(View.INVISIBLE);
        jian_fan_hou.setVisibility(View.INVISIBLE);
        biebu_fan_hou.setVisibility(View.INVISIBLE);
        yaobu_fan_hou.setVisibility(View.INVISIBLE);
        yaobuwei_fan_hou.setVisibility(View.INVISIBLE);
        tunbu_fan_hou.setVisibility(View.INVISIBLE);
        tuibu_fan_hou.setVisibility(View.INVISIBLE);
        zuoshoubi_fan_hou.setVisibility(View.INVISIBLE);
        youshoubi_hou.setVisibility(View.INVISIBLE);
        zuoshou_fan_hou.setVisibility(View.INVISIBLE);
        youshou_fan_hou.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onResume() {
        super.onResume();
        tou_fan_hou.setVisibility(View.INVISIBLE);
        jingbu_fan_hou.setVisibility(View.INVISIBLE);
        jian_fan_hou.setVisibility(View.INVISIBLE);
        biebu_fan_hou.setVisibility(View.INVISIBLE);
        yaobu_fan_hou.setVisibility(View.INVISIBLE);
        yaobuwei_fan_hou.setVisibility(View.INVISIBLE);
        tunbu_fan_hou.setVisibility(View.INVISIBLE);
        tuibu_fan_hou.setVisibility(View.INVISIBLE);
        zuoshoubi_fan_hou.setVisibility(View.INVISIBLE);
        youshoubi_hou.setVisibility(View.INVISIBLE);
        zuoshou_fan_hou.setVisibility(View.INVISIBLE);
        youshou_fan_hou.setVisibility(View.INVISIBLE);
    }

}
