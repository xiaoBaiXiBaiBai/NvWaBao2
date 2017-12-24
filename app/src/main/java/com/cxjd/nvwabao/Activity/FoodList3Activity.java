package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.Fruit2Adapter;
import com.cxjd.nvwabao.adapter.Fruit3Adapter;
import com.cxjd.nvwabao.adapter.FruitAdapter;
import com.cxjd.nvwabao.bean.Fruit;
import com.cxjd.nvwabao.bean.Fruit2;
import com.cxjd.nvwabao.fragment.DragGridLayout;
import com.cxjd.nvwabao.mainActivity.MainActivity;
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

public class FoodList3Activity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    private List<Fruit2> fruitList2 = new ArrayList<>();
    private FruitAdapter adapter;
    private Fruit3Adapter adapter0,adapter1,adapter2,adapter3,adapter4,adapter5,adapter6,adapter7;
    private String UrlBase = "http://47.94.145.225/user/getKey/";
    private String listName,Url;
    private ImageView fruit_image;
    private TextView disTitle,text_shucai,text_xuqin,text_gandou,text_dannairu,text_guwu,text_shuichan,text_shuiguoganguo,text_yaocao;
    private RecyclerView dgl_shucai,dgl_xuqin,dgl_gandou,dgl_dannairu,dgl_guwu,dgl_shuichan,dgl_shuiguoganguo,dgl_yaocao;
    private TextView tx;
    private List<Fruit2> shucai_items = new ArrayList<>();
    private List<Fruit2> xuqin_items = new ArrayList<>();
    private List<Fruit2> gandou_items = new ArrayList<>();
    private List<Fruit2> dannairu_items = new ArrayList<>();
    private List<Fruit2> guwu_items = new ArrayList<>();
    private List<Fruit2> shuichan_items = new ArrayList<>();
    private List<Fruit2> shuiguoganguo_items = new ArrayList<>();
    private List<Fruit2> yaocai_items = new ArrayList<>();
    //private  Fruit2 fruit2;
    //private LinearLayoutManager layoutManager0,layoutManager1,layoutManager2,layoutManager3,layoutManager4,layoutManager5,layoutManager6,layoutManager7;
    private StaggeredGridLayoutManager layoutManager0,layoutManager1,layoutManager2,layoutManager3,layoutManager4,layoutManager5,layoutManager6,layoutManager7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list3);
        Button back = (Button) findViewById(R.id.nav_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();

        fruit_image = findViewById(R.id.fruit_image);
        int  leixingINT =getIntent().getIntExtra("leixing",8);
        listName = getIntent().getStringExtra("listName");
        Url = UrlBase+listName;
        disTitle.setText(listName);
        Data(Url);




    }

    private void init() {
        disTitle = findViewById(R.id.disTitle);

        text_shucai= findViewById(R.id.text_shucai);
        text_xuqin= findViewById(R.id.text_xuqin);
        text_gandou= findViewById(R.id.text_gandou);
        text_dannairu= findViewById(R.id.text_dannairu);
        text_guwu= findViewById(R.id.text_guwu);
        text_shuichan= findViewById(R.id.text_shuichan);
        text_shuiguoganguo= findViewById(R.id.text_shuiguoganguo);
        text_yaocao= findViewById(R.id.text_yaocao);


     /*   layoutManager0 = new LinearLayoutManager(this);
        layoutManager1 = new LinearLayoutManager(this);
        layoutManager2 = new LinearLayoutManager(this);
        layoutManager3 = new LinearLayoutManager(this);
        layoutManager4 = new LinearLayoutManager(this);
        layoutManager5 = new LinearLayoutManager(this);
        layoutManager6 = new LinearLayoutManager(this);
        layoutManager7 = new LinearLayoutManager(this);*/
        layoutManager0 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        layoutManager1 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        layoutManager2 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        layoutManager3 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        layoutManager4 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        layoutManager5 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        layoutManager6 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        layoutManager7 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        dgl_shucai=findViewById(R.id.dgl_shucai);
        dgl_shucai.setNestedScrollingEnabled(false);
        dgl_xuqin=findViewById(R.id.dgl_xuqin);
        dgl_xuqin.setNestedScrollingEnabled(false);
        dgl_gandou=findViewById(R.id.dgl_gandou);
        dgl_gandou.setNestedScrollingEnabled(false);
        dgl_dannairu=findViewById(R.id.dgl_dannairu);
        dgl_dannairu.setNestedScrollingEnabled(false);
        dgl_guwu=findViewById(R.id.dgl_guwu);
        dgl_guwu.setNestedScrollingEnabled(false);
        dgl_shuichan=findViewById(R.id.dgl_shuichan);
        dgl_shuichan.setNestedScrollingEnabled(false);
        dgl_shuiguoganguo=findViewById(R.id.dgl_shuiguoganguo);
        dgl_shuiguoganguo.setNestedScrollingEnabled(false);
        dgl_yaocao=findViewById(R.id.dgl_yaocai);
        dgl_yaocao.setNestedScrollingEnabled(false);
    }


    private void Data(String url) {
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(FoodList3Activity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                try {
                    fruitList2.clear();
                    Log.e("Test",Url);
                    String responseData = response.body().string();
                    JSONArray jsonArray = new JSONArray(responseData);
                    Fruit2 fruit2;
                    String name,content_url,iconUrl,kind;
                    if (jsonArray.length()==0){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(FoodList3Activity.this,"未找到此类食品",Toast.LENGTH_SHORT).show();
                            }
                        });

                    }else {
                        for (int i =0;i<jsonArray.length();i++){
                            JSONObject jsonObject =   jsonArray.getJSONObject(i);
                            name = jsonObject.getString("name");
                            content_url = jsonObject.getString("content_url");
                            iconUrl = jsonObject.getString("iconUrl");
                            kind = jsonObject.getString("kind");
                          //  Log.e("Json",name+"::"+content_url+"::"+iconUrl);
                            Log.e("kind",kind);
                            switch (kind){
                                case "谷物":
                                    fruit2 = new Fruit2(name,iconUrl,content_url,kind);
                                    guwu_items.add(fruit2);
                                    break;
                                case "蔬菜":
                                    fruit2 = new Fruit2(name,iconUrl,content_url,kind);

                                    shucai_items.add(fruit2);
                                    break;
                                case "畜禽":  fruit2 = new Fruit2(name,iconUrl,content_url,kind);
                                    xuqin_items.add(fruit2);
                                    break;
                                case "干豆":  fruit2 = new Fruit2(name,iconUrl,content_url,kind);
                                    gandou_items.add(fruit2);
                                    break;

                                case "水产":  fruit2 = new Fruit2(name,iconUrl,content_url,kind);
                                   shuichan_items.add(fruit2);
                                    break;
                                case "水果干果":  fruit2 = new Fruit2(name,iconUrl,content_url,kind);
                                    shuiguoganguo_items.add(fruit2);
                                    break;
                                case "药材":  fruit2 = new Fruit2(name,iconUrl,content_url,kind);
                                    yaocai_items.add(fruit2);
                                    break;
                                case "蛋奶乳":  fruit2 = new Fruit2(name,iconUrl,content_url,kind);
                                    dannairu_items.add(fruit2);
                                    break;
                                default:break;


                            }

                        }
                        //                      Log.e("Next","!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                        Log.e("aaaaaa", fruitList2.get(0).getIconUrl());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (shucai_items.size()>0){
                                    dgl_shucai.setLayoutManager(layoutManager0);
                                    text_shucai.setVisibility(View.VISIBLE);
                                    dgl_shucai.setVisibility(View.VISIBLE);
                                    adapter0 = new Fruit3Adapter(shucai_items);
                                    dgl_shucai.setAdapter(adapter0);


                                }else {

                                    text_shucai.setVisibility(View.GONE);
                                    dgl_shucai.setVisibility(View.GONE);

                                }

                                if (xuqin_items.size()>0){
                                    dgl_xuqin.setLayoutManager(layoutManager1);
                                    text_xuqin.setVisibility(View.VISIBLE);
                                    dgl_xuqin.setVisibility(View.VISIBLE);
                                    adapter1 = new Fruit3Adapter(xuqin_items);
                                    dgl_xuqin.setAdapter(adapter1);

                                }else {
                                    text_xuqin.setVisibility(View.GONE);
                                    dgl_xuqin.setVisibility(View.GONE);

                                }
                                if (gandou_items.size()>0){
                                    dgl_gandou.setLayoutManager(layoutManager2);
                                    text_gandou.setVisibility(View.VISIBLE);
                                    dgl_gandou.setVisibility(View.VISIBLE);
                                    adapter2 = new Fruit3Adapter(gandou_items);
                                    dgl_gandou.setAdapter(adapter2);

                                }else {
                                    text_gandou.setVisibility(View.GONE);
                                    dgl_gandou.setVisibility(View.GONE);

                                }
                                if (dannairu_items.size()>0){
                                    dgl_dannairu.setLayoutManager(layoutManager3);
                                    text_dannairu.setVisibility(View.VISIBLE);
                                    dgl_dannairu.setVisibility(View.VISIBLE);
                                    adapter3 = new Fruit3Adapter(dannairu_items);
                                    dgl_dannairu.setAdapter(adapter3);

                                }else {
                                    text_dannairu.setVisibility(View.GONE);
                                    dgl_dannairu.setVisibility(View.GONE);

                                }
                                if (guwu_items.size()>0){
                                    dgl_guwu.setLayoutManager(layoutManager4);
                                    text_guwu.setVisibility(View.VISIBLE);
                                    dgl_guwu.setVisibility(View.VISIBLE);
                                    adapter4 = new Fruit3Adapter(guwu_items);
                                    dgl_guwu.setAdapter(adapter4);

                                }else {
                                    text_guwu.setVisibility(View.GONE);
                                    dgl_guwu.setVisibility(View.GONE);

                                }
                                if (shuichan_items.size()>0){
                                    dgl_shuichan.setLayoutManager(layoutManager5);
                                    text_shuichan.setVisibility(View.VISIBLE);
                                    dgl_shuichan.setVisibility(View.VISIBLE);
                                    adapter5 = new Fruit3Adapter(shuichan_items);
                                    dgl_shuichan.setAdapter(adapter5);

                                }else {
                                    text_shuichan.setVisibility(View.GONE);
                                    dgl_shuichan.setVisibility(View.GONE);

                                }
                                if (shuiguoganguo_items.size()>0){
                                    dgl_shuiguoganguo.setLayoutManager(layoutManager6);
                                    text_shuiguoganguo.setVisibility(View.VISIBLE);
                                    dgl_shuiguoganguo.setVisibility(View.VISIBLE);
                                    adapter6 = new Fruit3Adapter(shuiguoganguo_items);
                                    dgl_shuiguoganguo.setAdapter(adapter6);

                                }else {
                                    text_shuiguoganguo.setVisibility(View.GONE);
                                    dgl_shuiguoganguo.setVisibility(View.GONE);

                                }
                                if (yaocai_items.size()>0){
                                    dgl_yaocao.setLayoutManager(layoutManager7);
                                    text_yaocao.setVisibility(View.VISIBLE);
                                    dgl_yaocao.setVisibility(View.VISIBLE);
                                    adapter7 = new Fruit3Adapter(yaocai_items);
                                    dgl_yaocao.setAdapter(adapter7);

                                }else {
                                    text_yaocao.setVisibility(View.GONE);
                                    dgl_yaocao.setVisibility(View.GONE);

                                }



                            }
                        });


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        if (tx!=null){
            tx.setTextColor(Color.parseColor("#808080"));
        }

    }
}
