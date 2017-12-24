package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.Fruit2Adapter;
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

public class FoodList2Activity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    private List<Fruit2> fruitList2 = new ArrayList<>();
    private FruitAdapter adapter;
    private Fruit2Adapter adapter2;
    private String UrlBase = "http://47.94.145.225/user/getKey/";
    private String listName,Url;
    private ImageView fruit_image;
    private TextView disTitle,text_shucai,text_xuqin,text_gandou,text_dannairu,text_guwu,text_shuichan,text_shuiguoganguo,text_yaocao;
    private DragGridLayout dgl_shucai,dgl_xuqin,dgl_gandou,dgl_dannairu,dgl_guwu,dgl_shuichan,dgl_shuiguoganguo,dgl_yaocao;
    private TextView tx;
    private List<String> shucai_items = new ArrayList<>();
    private List<String> xuqin_items = new ArrayList<>();
    private List<String> gandou_items = new ArrayList<>();
    private List<String> dannairu_items = new ArrayList<>();
    private List<String> guwu_items = new ArrayList<>();
    private List<String> shuichan_items = new ArrayList<>();
    private List<String> shuiguoganguo_items = new ArrayList<>();
    private List<String> yaocai_items = new ArrayList<>();
    private  Fruit2 fruit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list2);
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

        dgl_shucai.setResource(R.drawable.selector_textbg, 5, 5);
        dgl_shucai.setEnableDrag(false);


        //设置点击事件
        dgl_shucai.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(FoodList2Activity.this,FoodInfoActivity.class);
                for (int i = 0;i<fruitList2.size();i++){
                    Log.e("fruitList2.get(i)",fruitList2.get(i).getName());
                    if (fruitList2.get(i).getName().trim().equals(tv.getText().toString().trim())){
                        intent.putExtra("content_url",fruitList2.get(i).getIconUrl());
                        break;
                    }
                }
                startActivity(intent);
            }

        });
        dgl_xuqin.setResource(R.drawable.selector_textbg, 5, 5);
        dgl_xuqin.setEnableDrag(false);


        //设置点击事件
        dgl_xuqin.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(FoodList2Activity.this,FoodInfoActivity.class);
                for (int i = 0;i<fruitList2.size();i++){
                    Log.e("fruitList2.get(i)",fruitList2.get(i).getName());
                    if (fruitList2.get(i).getName().trim().equals(tv.getText().toString().trim())){
                        intent.putExtra("content_url",fruitList2.get(i).getIconUrl());
                        break;
                    }
                }
                startActivity(intent);
            }

        });
        dgl_gandou.setResource(R.drawable.selector_textbg, 5, 5);
        dgl_gandou.setEnableDrag(false);


        //设置点击事件
        dgl_gandou.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(FoodList2Activity.this,FoodInfoActivity.class);
                for (int i = 0;i<fruitList2.size();i++){
                    Log.e("fruitList2.get(i)",fruitList2.get(i).getName());
                    if (fruitList2.get(i).getName().trim().equals(tv.getText().toString().trim())){
                        intent.putExtra("content_url",fruitList2.get(i).getIconUrl());
                        break;
                    }
                }
                startActivity(intent);
            }

        });
        dgl_dannairu.setResource(R.drawable.selector_textbg, 5, 5);
        dgl_dannairu.setEnableDrag(false);


        //设置点击事件
        dgl_dannairu.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(FoodList2Activity.this,FoodInfoActivity.class);
                for (int i = 0;i<fruitList2.size();i++){
                    Log.e("fruitList2.get(i)",fruitList2.get(i).getName());
                    if (fruitList2.get(i).getName().trim().equals(tv.getText().toString().trim())){
                        intent.putExtra("content_url",fruitList2.get(i).getIconUrl());
                        break;
                    }
                }
                startActivity(intent);
            }

        });
        dgl_guwu.setResource(R.drawable.selector_textbg, 5, 5);
        dgl_guwu.setEnableDrag(false);


        //设置点击事件
        dgl_guwu.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(FoodList2Activity.this,FoodInfoActivity.class);
                for (int i = 0;i<fruitList2.size();i++){
                    Log.e("fruitList2.get(i)",fruitList2.get(i).getName());
                    if (fruitList2.get(i).getName().trim().equals(tv.getText().toString().trim())){
                        intent.putExtra("content_url",fruitList2.get(i).getIconUrl());
                        break;
                    }
                }
                startActivity(intent);
            }

        });
        dgl_shuichan.setResource(R.drawable.selector_textbg, 5, 5);
        dgl_shuichan.setEnableDrag(false);


        //设置点击事件
        dgl_shuichan.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(FoodList2Activity.this,FoodInfoActivity.class);
                for (int i = 0;i<fruitList2.size();i++){
                    Log.e("fruitList2.get(i)",fruitList2.get(i).getName());
                    if (fruitList2.get(i).getName().trim().equals(tv.getText().toString().trim())){
                        intent.putExtra("content_url",fruitList2.get(i).getIconUrl());
                        break;
                    }
                }
                startActivity(intent);
            }

        });
        dgl_shuiguoganguo.setResource(R.drawable.selector_textbg, 5, 5);
        dgl_shuiguoganguo.setEnableDrag(false);


        //设置点击事件
        dgl_shuiguoganguo.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(FoodList2Activity.this,FoodInfoActivity.class);
                for (int i = 0;i<fruitList2.size();i++){
                    Log.e("fruitList2.get(i)",fruitList2.get(i).getName());
                    if (fruitList2.get(i).getName().trim().equals(tv.getText().toString().trim())){
                        intent.putExtra("content_url",fruitList2.get(i).getIconUrl());
                        break;
                    }
                }
                startActivity(intent);
            }

        });
        dgl_yaocao.setResource(R.drawable.selector_textbg, 5, 5);
        dgl_yaocao.setEnableDrag(false);


        //设置点击事件
        dgl_yaocao.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());

                Intent intent = new Intent(FoodList2Activity.this,FoodInfoActivity.class);
                for (int i = 0;i<fruitList2.size();i++){
                    Log.e("fruitList2.get(i)",fruitList2.get(i).getName());
                    if (fruitList2.get(i).getName().trim().equals(tv.getText().toString().trim())){
                        intent.putExtra("content_url",fruitList2.get(i).getIconUrl());
                        break;
                    }
                }
                //intent.putExtra("address","药材/"+position);
                startActivity(intent);
            }

        });


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

        dgl_shucai=findViewById(R.id.dgl_shucai);
        dgl_xuqin=findViewById(R.id.dgl_xuqin);
        dgl_gandou=findViewById(R.id.dgl_gandou);
        dgl_dannairu=findViewById(R.id.dgl_dannairu);
        dgl_guwu=findViewById(R.id.dgl_guwu);
        dgl_shuichan=findViewById(R.id.dgl_shuichan);
        dgl_shuiguoganguo=findViewById(R.id.dgl_shuiguoganguo);
        dgl_yaocao=findViewById(R.id.dgl_yaocai);
    }


    private void Data(String url) {
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(FoodList2Activity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(FoodList2Activity.this,"未找到此类食品",Toast.LENGTH_SHORT).show();
                            }
                        });

                    }else {
                        for (int i =0;i<jsonArray.length();i++){
                            JSONObject jsonObject =   jsonArray.getJSONObject(i);
                            name = jsonObject.getString("name");
                            content_url = jsonObject.getString("content_url");
                            iconUrl = jsonObject.getString("iconUrl");
                            kind = jsonObject.getString("kind");
                            Log.e("Json",name+"::"+content_url+"::"+iconUrl);
                            switch (kind){
                                case "谷物":guwu_items.add(name);
                                    break;
                                case "蔬菜":shucai_items.add(name);
                                    break;
                                case "畜禽":xuqin_items.add(name);
                                    break;
                                case "干豆":gandou_items.add(name);
                                    break;
                                case "蛋奶乳":dannairu_items.add(name);
                                    break;
                                case "水产":dannairu_items.add(name);
                                    break;
                                case "水果干果":dannairu_items.add(name);
                                    break;
                                case "药材":dannairu_items.add(name);
                                    break;
                                default:break;


                            }
                           fruit2 = new Fruit2(name,iconUrl,content_url,kind);
                            fruitList2.add(fruit2);
                        }
  //                      Log.e("Next","!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                        Log.e("aaaaaa", fruitList2.get(0).getIconUrl());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (shucai_items.size()>0){
                                    text_shucai.setVisibility(View.VISIBLE);
                                    dgl_shucai.setVisibility(View.VISIBLE);
                                    dgl_shucai.setItems(shucai_items);

                                }else {
                                    text_shucai.setVisibility(View.GONE);
                                    dgl_shucai.setVisibility(View.GONE);

                                }

                                if (xuqin_items.size()>0){
                                    text_xuqin.setVisibility(View.VISIBLE);
                                    dgl_xuqin.setVisibility(View.VISIBLE);
                                    dgl_xuqin.setItems(xuqin_items);

                                }else {
                                    text_xuqin.setVisibility(View.GONE);
                                    dgl_xuqin.setVisibility(View.GONE);

                                }
                                if (gandou_items.size()>0){
                                    text_gandou.setVisibility(View.VISIBLE);
                                    dgl_gandou.setVisibility(View.VISIBLE);
                                    dgl_gandou.setItems(gandou_items);

                                }else {
                                    text_gandou.setVisibility(View.GONE);
                                    dgl_gandou.setVisibility(View.GONE);

                                }
                                if (dannairu_items.size()>0){
                                    text_dannairu.setVisibility(View.VISIBLE);
                                    dgl_dannairu.setVisibility(View.VISIBLE);
                                    dgl_dannairu.setItems(dannairu_items);

                                }else {
                                    text_dannairu.setVisibility(View.GONE);
                                    dgl_dannairu.setVisibility(View.GONE);

                                }
                                if (guwu_items.size()>0){
                                    text_guwu.setVisibility(View.VISIBLE);
                                    dgl_guwu.setVisibility(View.VISIBLE);
                                    dgl_guwu.setItems(guwu_items);

                                }else {
                                    text_guwu.setVisibility(View.GONE);
                                    dgl_guwu.setVisibility(View.GONE);

                                }
                                if (shuichan_items.size()>0){
                                    text_shuichan.setVisibility(View.VISIBLE);
                                    dgl_shuichan.setVisibility(View.VISIBLE);
                                    dgl_shuichan.setItems(shuichan_items);

                                }else {
                                    text_shuichan.setVisibility(View.GONE);
                                    dgl_shuichan.setVisibility(View.GONE);

                                }
                                if (shuiguoganguo_items.size()>0){
                                    text_shuiguoganguo.setVisibility(View.VISIBLE);
                                    dgl_shuiguoganguo.setVisibility(View.VISIBLE);
                                    dgl_shuiguoganguo.setItems(shuiguoganguo_items);

                                }else {
                                    text_shuiguoganguo.setVisibility(View.GONE);
                                    dgl_shuiguoganguo.setVisibility(View.GONE);

                                }
                                if (yaocai_items.size()>0){
                                    text_yaocao.setVisibility(View.VISIBLE);
                                    dgl_yaocao.setVisibility(View.VISIBLE);
                                    dgl_yaocao.setItems(yaocai_items);

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
