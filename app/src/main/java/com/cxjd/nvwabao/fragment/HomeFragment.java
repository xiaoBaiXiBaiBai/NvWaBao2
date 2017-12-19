package com.cxjd.nvwabao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.cxjd.nvwabao.Activity.ProtectActivity;
import com.cxjd.nvwabao.Activity.SearchMain;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.HttpTitleUtil;
import com.cxjd.nvwabao.adapter.ListDataSave;
import com.cxjd.nvwabao.adapter.NewsItemAdapter;
import com.cxjd.nvwabao.bean.TitleContentBean;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

     private SliderLayout mSliderLayout;
     private ImageView icon_search_food;
     private ImageView icon_search_heathy;
     private RecyclerView recyclerView;
    ListDataSave listDataSave;
    List<TitleContentBean> titleContentBeans;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        Toolbar toolbar = view.findViewById(R.id.toolbar_fragment_home);
        icon_search_food = view.findViewById(R.id.home_search_food);
        icon_search_heathy = view.findViewById(R.id.home_search_healthy);
        recyclerView=view.findViewById(R.id.home_recycler_view);
        requesList();
        listDataSave=new ListDataSave(getContext(),"Titlecontent");
        titleContentBeans=new ArrayList<>();
        titleContentBeans=listDataSave.getDataList("NewsCommand",TitleContentBean.class);
        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){


            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.share_item:
                          Toast.makeText(getActivity(),"本功能占未开放",Toast.LENGTH_SHORT).show();
                          break;
                }
                return true;
            }
        });

        //广告图片轮播效果
        mSliderLayout = view.findViewById(R.id.slider);
        final NewsItemAdapter adapter=new NewsItemAdapter(titleContentBeans,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        initSlider();

        //食品疾病查询方法
        serchFoodAndHealthy();

        return view;
    }
    private void requesList() {
        String address="http://47.94.145.225/user/getIndexPage";
        //showProgressDialog();
        HttpTitleUtil.sendHttpRequest(address, new HttpTitleUtil.HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                listDataSave.setDataList("NewsCommand", HttpTitleUtil.parseJsonWithGSON(response.toString()));
            }

            @Override
            public void onError(Exception e) {
            }
        });

    }

    private void serchFoodAndHealthy() {
        icon_search_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ProtectActivity.class);
                startActivity(intent);
            }
        });

        icon_search_heathy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SearchMain.class);
                startActivity(intent);
            }
        });

    }

    /**
     *  轮播初始化
     */
    private void initSlider(){
        TextSliderView textSliderView0 = new TextSliderView(this.getActivity());
        textSliderView0
                .description("如何吃")
                .image(R.drawable.carousel_1);
        textSliderView0.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"如何吃，找女娲",Toast.LENGTH_SHORT).show();
            }
        });

        TextSliderView textSliderView1 = new TextSliderView(this.getActivity());
        textSliderView1
                .description("怎么喝")
                .image(R.drawable.carousel_2);
        textSliderView1.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"喝什么，找女娲",Toast.LENGTH_SHORT).show();
            }
        });

        TextSliderView textSliderView2 = new TextSliderView(this.getActivity());
        textSliderView2
                .description("养生之道")
                .image(R.drawable.carousel_4);
        textSliderView2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"如何养生，找女娲",Toast.LENGTH_SHORT).show();
            }
        });

        TextSliderView textSliderView3 = new TextSliderView(this.getActivity());
        textSliderView3
                .description("女娲宝告诉你")
                .image(R.drawable.carousel_3);
        textSliderView3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"女娲宝，你的养生小管家",Toast.LENGTH_SHORT).show();
            }
        });

        mSliderLayout.addSlider(textSliderView0);
        mSliderLayout.addSlider(textSliderView1);
        mSliderLayout.addSlider(textSliderView2);
        mSliderLayout.addSlider(textSliderView3)
        ;

        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSliderLayout.setDuration(3000);




    }

    @Override
    public void onStop() {
        mSliderLayout.stopAutoCycle();
        super.onStop();
    }


}
