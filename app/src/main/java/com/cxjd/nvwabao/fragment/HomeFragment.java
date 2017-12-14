package com.cxjd.nvwabao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;


public class HomeFragment extends Fragment {

     private SliderLayout mSliderLayout;
     private ImageView icon_search_food;
     private ImageView icon_search_heathy;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        Toolbar toolbar = view.findViewById(R.id.toolbar_fragment_home);
        icon_search_food = view.findViewById(R.id.home_search_food);
        icon_search_heathy = view.findViewById(R.id.home_search_healthy);
        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){


            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.share_item:
                          Toast.makeText(getActivity(),"分享",Toast.LENGTH_SHORT).show();
                          break;
                }
                return true;
            }
        });

        //广告图片轮播效果
        mSliderLayout = view.findViewById(R.id.slider);

        initSlider();

        //食品疾病查询方法
        serchFoodAndHealthy();

        return view;
    }

    private void serchFoodAndHealthy() {
        icon_search_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"寻找食物",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),ProtectActivity.class);
                startActivity(intent);
            }
        });

        icon_search_heathy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"寻找健康 ",Toast.LENGTH_SHORT).show();
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
                .description("大甩卖")
                .image(R.drawable.girl_3);
        textSliderView0.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"大甩卖",Toast.LENGTH_SHORT).show();
            }
        });

        TextSliderView textSliderView1 = new TextSliderView(this.getActivity());
        textSliderView1
                .description("一元秒杀")
                .image(R.drawable.girl_4);
        textSliderView1.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"一元秒杀",Toast.LENGTH_SHORT).show();
            }
        });

        TextSliderView textSliderView2 = new TextSliderView(this.getActivity());
        textSliderView2
                .description("买一送一")
                .image(R.drawable.girl_5);
        textSliderView2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"买一送一",Toast.LENGTH_SHORT).show();
            }
        });

        mSliderLayout.addSlider(textSliderView0);
        mSliderLayout.addSlider(textSliderView1);
        mSliderLayout.addSlider(textSliderView2);

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
