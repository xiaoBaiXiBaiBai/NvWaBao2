package com.cxjd.nvwabao.Activity;


import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.fragment.ManFFFragment;
import com.cxjd.nvwabao.fragment.ManFHFragment;
import com.cxjd.nvwabao.fragment.womenFHFragment;
import com.cxjd.nvwabao.fragment.womenFrontFragment;
import com.cxjd.nvwabao.utils.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FoodInfoActivity extends AppCompatActivity {
    private ImageView bingPicImg;
    private  String address,UrlBase = "http://192.168.31.227/user/getFoods/",Url;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TextView infoname,infoitem1,infoitem2,infoitem3,infoitem4;
    private String head_array;


    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3, view4, view5;//页卡视图
   private List<View> mViewList = new ArrayList<>();//页卡视图集合


    private String imageUrl,foods_name,item0,item1,item2,item3,effects,warning;
    private WebView webView1;
    private WebView webView2;
    private WebView webView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);

        bingPicImg = findViewById(R.id.bing_pic_img);
        infoname = findViewById(R.id.infoname);
        infoitem1 = findViewById(R.id.infoitem1);
        infoitem2 = findViewById(R.id.infoitem2);
        infoitem3 = findViewById(R.id.infoitem3);
        infoitem4 = findViewById(R.id.infoitem4);
        address = getIntent().getStringExtra("address");
        Url = UrlBase+address;
        Data(Url);



        mViewPager = findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        mInflater = LayoutInflater.from(this);
        view1 = mInflater.inflate(R.layout.infoview1, null);
        view2 = mInflater.inflate(R.layout.infoview2, null);
        view3 = mInflater.inflate(R.layout.infoview3, null);
        webView1 = (WebView)view1.findViewById(R.id.webview);
        webView2 = (WebView)view2.findViewById(R.id.webview);
        webView3 = (WebView)view3.findViewById(R.id.webview);

        WebSettings webSettings = webView1.getSettings();
        //优先使用缓存:
        webView1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        //webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
      //  webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
     //   webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
       // webSettings.setJavaScriptEnabled(true);
       // webSettings.setUseWideViewPort(true);
     //   webSettings.setLoadWithOverviewMode(true);
        //webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
   //     webView1.getSettings().setSupportZoom(true);
       // webView1.getSettings().setBuiltInZoomControls(true);
       // webView1.getSettings().setSupportZoom(true);
      /*  WindowManager windowManager= (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        int width = windowManager.getDefaultDisplay().getWidth();
        chooseScale(width);*/
        WebSettings webSettings2 = webView2.getSettings();
        webView2.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
      // webSettings2.setUseWideViewPort(true); //将图片调整到适合webview的大小
        //webSettings2.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);


        //添加页卡标题
        mTitleList.add("营养功效");
        mTitleList.add("注意事项");
        mTitleList.add("食用方法");



        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));



        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器




    }

    private void chooseScale(int width) {

        if(width > 650)

        {

            this.webView1.setInitialScale(300);

        }else if(width > 520)

        {

            this.webView1.setInitialScale(180);

        }else if(width > 450)

        {

            this.webView1.setInitialScale(160);

        }else if(width > 300)

        {

            this.webView1.setInitialScale(140);

        }else

        {

            this.webView1.setInitialScale(100);

        }

    }


    //ViewPager适配器
   class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));//添加页卡
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);//页卡标题
        }

    }



    private void Data(String url) {
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(FoodInfoActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                try {


                    String responseData = response.body().string();
                    JSONObject jsonObject = new JSONObject(responseData);
                   // JSONArray jsonArray = jsonObject.getJSONArray("head_array");
                   // Log.e("jsonArray",jsonArray.getString(0));
                     imageUrl = jsonObject.getString("imageUrl");
                    Log.e("imageUrl",imageUrl);
                    foods_name = jsonObject.getString("foods_name");

                    String head_array = jsonObject.getString("head_array");
                    JSONArray jsonArray = new JSONArray(head_array);
                    effects = jsonObject.getString("effects");
                    warning = jsonObject.getString("warning");
                    //Log.e("jsonArray",items[0]);
                     //head_array = jsonObject.getString("head_array");
                    item0 = jsonArray.getString(0);
                    item1 = jsonArray.getString(1);
                    item2 = jsonArray.getString(2);
                    item3 = jsonArray.getString(3);
                  // Log.e("jsonArray",jsonArray.getJSONObject(1).toString());
                  //  Log.e("imageUrl",imageUrl);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Glide.with(FoodInfoActivity.this).load(imageUrl).into(bingPicImg);
                            infoname.setText(foods_name);
                            infoitem1.setText(item0);
                            infoitem2.setText(item1);
                            infoitem3.setText(item2);
                            infoitem4.setText(item3);

                            webView1.loadDataWithBaseURL("", effects, "text/html", "utf-8", null);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            webView1.setWebChromeClient(new WebChromeClient());


                            webView2.loadDataWithBaseURL("", warning, "text/html", "utf-8", null);
                            webView2.getSettings().setJavaScriptEnabled(true);
                            webView2.setWebChromeClient(new WebChromeClient());
                        }
                    });
                  //  Glide.with(FoodInfoActivity.this).load(imageUrl).into(bingPicImg);
                   /* for (int i = 0; i < jsonArray.length(); i++) {
                        list.add(jsonArray.getString(i));

                    }*/

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
