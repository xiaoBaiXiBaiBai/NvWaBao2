package com.cxjd.nvwabao.fragment;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cxjd.nvwabao.ActivityNews.DragActivity;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.ListDataSave;
import com.cxjd.nvwabao.adapter.NewsViewpaerAdappter;
import com.cxjd.nvwabao.bean.TitleBean;
import com.cxjd.nvwabao.bean.TitleLable;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 董长峰 on 2017/10/29.
 */

public class InformationFragment extends Fragment {
    /*
     * 定义控件
     **/
    private ListDataSave listDataSave;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private NewsViewpaerAdappter viewpaerAdappter;

    private List<TitleLable> seansonlist,TabNameList;
    /*
     *arrayTitle用于获取arrays.xml中定义的标题
     * */
     String[] arrayTitle,titleLayble;
    /*
     *定义管理频道按钮
     * */
    private ImageButton titleBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information,container,false);
        titleBtn = (ImageButton) view.findViewById(R.id.titleManager);
        mViewPager = (ViewPager) view.findViewById(R.id.news_view_paper);
        mTabLayout = (TabLayout) view.findViewById(R.id.news_tab_layout);
        //创建从SharedPreferences中提取数据对象
        listDataSave=new ListDataSave(getActivity(),"MyItem");
        seansonlist=new ArrayList<>();
        TabNameList=new ArrayList<>();
        /**
         * 创建数据库
         */
        Connector.getDatabase();
        /**
         *若数据库为空，则初始化
         */
        List<TitleBean> titleBeansList=DataSupport.findAll(TitleBean.class);
        if (titleBeansList.size()<=0){
            arrayTitle=getResources().getStringArray(R.array.focusTitle);
            titleLayble=getResources().getStringArray(R.array.TitleLable);
            initTiTle();
        }
        /**
         * 获取tabLayout标题，若为空则初始化
         */
        addTabName();
        /**
         * 给Tablayout中item间添加分割线
         */
        LinearLayout mLinearLayout= (LinearLayout) mTabLayout.getChildAt(0);
        mLinearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        mLinearLayout.setDividerPadding(20);
        mLinearLayout.setDividerDrawable(ContextCompat.getDrawable(getContext(),R.drawable.divider_vertical));

        starttitleLayout();
        return view;
    }
    //获取TabName数据集合
    private void addTabName() {
        List<TitleLable> titleLableList=listDataSave.getDataList("TitleLable",TitleLable.class);//DataSupport.findAll(TitleLable.class);
        if (titleLableList.size()<=0){
            initTabName();
            TabNameList=listDataSave.getDataList("TitleLable",TitleLable.class);//DataSupport.findAll(TitleLable.class);
        }else {
            TabNameList=titleLableList;
        }
    }
    //若第一次安装则将TabName数据添加至文件
    private void initTabName() {
        List<TitleBean> list= DataSupport.findAll(TitleBean.class);
        if (list!=null) {
            for (TitleBean titleBean : list) {
                if (titleBean.getTitle_check() == 1) {
                    TitleLable titleLable = new TitleLable();
                    titleLable.setTitle_check(titleBean.getTitle_check());
                    titleLable.setTitleCategery(titleBean.getTitleCategery());
                    titleLable.setTitleLable(titleBean.getTitleLable());
                    titleLable.setTitleName(titleBean.getTitleName());
                    seansonlist.add(titleLable);
                }
            }
        }
        //将关注的标题存储至文件
        listDataSave.setDataList("TitleLable",seansonlist);
        //将关注的标题存储至数据库
        for (TitleLable titleLable:seansonlist){
            titleLable.save();
        }
    }
    //第一次安装将所有标题信息存储至数据库
    public void initTiTle(){
        for (int i=0;i<arrayTitle.length;i++){
            TitleBean focusTitle=new TitleBean();
            focusTitle.setTitleName(arrayTitle[i]);
            if (i==0||i==5){
                focusTitle.setTitle_check(0);
                focusTitle.setTitleCategery(titleLayble[i]);
                focusTitle.setTitleLable("GROUP_NAME");
            }else {
                focusTitle.setTitleCategery(titleLayble[i]);
                focusTitle.setTitleLable("DATA");
                if (i<6){
                    focusTitle.setTitle_check(1);
                }
                else{
                    focusTitle.setTitle_check(0);
                }
            }
            focusTitle.save();
        }
    }
    /*
    * 将tabLayout与viewpaper相关联
    * */
    private void starttitleLayout() {
        FragmentManager fragmentManager = getChildFragmentManager();
        viewpaerAdappter= new NewsViewpaerAdappter(fragmentManager, TabNameList);
        for (int i = 0; i < TabNameList.size(); i++){
            viewpaerAdappter.addFragment(new NewsItemFragment(TabNameList.get(i).getTitleCategery()));
        }
        mViewPager.setAdapter(viewpaerAdappter);

        for (int i = 0; i < TabNameList.size(); i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(TabNameList.get(i).getTitleName()));
        }

        mTabLayout.setupWithViewPager(mViewPager);


        //为管理频道按钮添加监听启动频道管理界面
        titleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), DragActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
       addTabName();
       if (viewpaerAdappter!=null)
       viewpaerAdappter.notifyDataSetChanged();
       starttitleLayout();
    }
}