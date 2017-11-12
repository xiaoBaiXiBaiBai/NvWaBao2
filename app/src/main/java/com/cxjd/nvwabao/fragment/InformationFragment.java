package com.cxjd.nvwabao.fragment;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.cxjd.nvwabao.ActivityNews.DragActivity;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.NewsViewpaerAdappter;
import com.cxjd.nvwabao.bean.FocusTitle;
import com.cxjd.nvwabao.utils.TitleListManagr;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 李超 on 2017/10/29.
 */

public class InformationFragment extends Fragment {
    /*
     * 定义控件
     **/
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private NewsViewpaerAdappter viewpaerAdappter;

    public static final int TITLE_SELECTED=1;
    /*
     *定义存放标题对象的集合
     **/
    private List<FocusTitle> seansonlist =new ArrayList<>();
    /*
     *arrayTitle用于获取arrays.xml中定义的标题
     * */
    String[] arrayTitle;
    /*
     *定义管理频道按钮
     * */
    private ImageButton titleBtn;
    /*
     *初始化集合对象
     * */
    private List<FocusTitle> mTabNameList = new ArrayList<>();
    private List<FocusTitle> mTabNameItem = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information,container,false);
        /*
        * 控件初始化
        * */
        titleBtn = (ImageButton) view.findViewById(R.id.titleManager);
        arrayTitle=getResources().getStringArray(R.array.focusTitle);
        mViewPager = (ViewPager) view.findViewById(R.id.news_view_paper);
        mTabLayout = (TabLayout) view.findViewById(R.id.news_tab_layout);
        if (mTabNameItem!=null){
            mTabNameItem.clear();
        }
        mTabNameItem = TitleListManagr.readTitleList(getContext(),TitleListManagr.str_show);
        if (mTabNameItem==null) {
        /*
        * 给频道集合填充数据（包含分类item）
        * */
            initTiTle();
        /*
        * 将初始化后的频道集合数据保存至文件，便于以后和其他活动读取
        * */
            TitleListManagr.saveTitleList(seansonlist, getContext(), TitleListManagr.str_all);
        /*
        * 从文件中读取频道数据
        * */
            mTabNameItem = TitleListManagr.readTitleList(getContext(), TitleListManagr.str_all);
        }
        /*
        * 过滤出干净的频道item
        * */
        for (int i=0;i<mTabNameItem.size();i++){
            if (mTabNameItem.get(i).getTitleState()==FocusTitle.TITLE_STATE_NO){
                mTabNameList.add(mTabNameItem.get(i));
            }
        }

        /*
        * 给Tablayout中item间添加分割线
        * */
        LinearLayout mLinearLayout= (LinearLayout) mTabLayout.getChildAt(0);
        mLinearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        mLinearLayout.setDividerPadding(20);
        mLinearLayout.setDividerDrawable(ContextCompat.getDrawable(getContext(),R.drawable.divider_vertical));

        starttitleLayout();
        return view;
    }

    public void initTiTle(){
        for (int i=0;i<arrayTitle.length;i++){
            FocusTitle focusTitle=new FocusTitle();
            focusTitle.setTitleName(arrayTitle[i]);
            if (i==0||i==5){
                focusTitle.setTitleState(FocusTitle.TITLE_STATE_IS);
                focusTitle.setTitle_check(FocusTitle.TITLE_NOCHECKED);
            }else {
                focusTitle.setTitleState(FocusTitle.TITLE_STATE_NO);
                if (i<6){
                    focusTitle.setTitle_check(FocusTitle.TITLE_CHECKED);
                }
            }

            seansonlist.add(focusTitle);
        }
    }
    /*
    * 将tabLayout与viewpaper相关联
    * */
    private void starttitleLayout() {
        FragmentManager fragmentManager = getChildFragmentManager();
        viewpaerAdappter= new NewsViewpaerAdappter(fragmentManager, mTabNameList);
        for (int i = 0; i < mTabNameList.size(); i++){
            viewpaerAdappter.addFragment(new NewsItemFragment());
        }
        mViewPager.setAdapter(viewpaerAdappter);

        for (int i = 0; i < mTabNameList.size(); i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(mTabNameList.get(i).getTitleName()));
        }

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //为管理频道按钮添加监听启动频道管理界面
        titleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), DragActivity.class);
                startActivity(intent);
            }
        });
    }
}
