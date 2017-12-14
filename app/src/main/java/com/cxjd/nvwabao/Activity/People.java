package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.SelectAdapter;
import com.cxjd.nvwabao.utils.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class People extends AppCompatActivity {

    private ListView maxlv,minlv;
    private List<String> maxList,minList;
    private ArrayAdapter<String> maxAdapter,minAdapter;
    private  String UrlBase = "http://192.168.31.227/user/getParts/";
    //private  String UrlBase = "http://192.168.31.227/user/getCrowdSick/";
    private int fPosition;
    private SelectAdapter adapter;
    private int buwei;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify);
        Button back = (Button) findViewById(R.id.nav_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        buwei = getIntent().getIntExtra("buwei",0);
        maxList = new ArrayList<>();

        //listData(UrlBase);
        MaxData();
        maxlv = (ListView) findViewById(R.id.max_item);

        adapter = new SelectAdapter(this,maxList);
        maxlv.setAdapter(adapter);
//        maxAdapter.notifyDataSetChanged();
        adapter.setDefSelect(buwei);//设置默认选中第一项
        maxlv.setSelection(buwei);

        minList = new ArrayList<>();
        minList = minlistData(UrlBase+buwei,minList);
        minlv = (ListView) findViewById(R.id.min_item);

        minAdapter = new ArrayAdapter<String>(People.this,android.R.layout.simple_list_item_1, minList);
        minlv.setAdapter(minAdapter);


        maxlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setDefSelect(position);
                fPosition = position;
                minList = minlistData(UrlBase+position,minList);
                Message message = new Message();
                handler.sendMessage(message);
            }
        });

        minlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentDis = new Intent(People.this, Disease.class);
                intentDis.putExtra("xq", UrlBase+fPosition+"/"+position);
                intentDis.putExtra("what","1");
                startActivity(intentDis);
            }
        });


       // maxlv.getChildAt(buwei).setBackgroundColor(Color.parseColor("#FFFFFF"));
        //maxAdapter.notifyDataSetChanged();
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    minAdapter.notifyDataSetChanged();
                }
            });

        }
    };
    public void MaxData(){
      //  listData(UrlBase);
        maxList.add("头部");
        maxList.add("头");
        maxList.add("眼");
        maxList.add("耳");
        maxList.add("鼻");
        maxList.add("口");
        maxList.add("眉");
        maxList.add("牙");
        maxList.add("胸部");
        maxList.add("腹部");
        maxList.add("四肢");
        maxList.add("上肢");
        maxList.add("下肢");
        maxList.add("颈部");
        maxList.add("腰部");
        maxList.add("背部");
        maxList.add("臀部");
        maxList.add("皮肤");
        maxList.add("全身");
        maxList.add("生殖部位");
        maxList.add("男性生殖部位");
        maxList.add("女性生殖部位");

    }



    private void listData(String url) {
        Log.e("Url",url);
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(People.this, "获取数据失败", Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                try {


                    String responseData = response.body().string();
                    JSONArray jsonArray = new JSONArray(responseData);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        maxList.add(jsonArray.getString(i));

                    }
                /*    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            maxAdapter.notifyDataSetChanged();
                        }
                    });*/


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    private List<String> minlistData(String url, final List<String> list) {
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(People.this, "获取数据失败", Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                try {
                    list.clear();

                    String responseData = response.body().string();
                    JSONArray jsonArray = new JSONArray(responseData);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        list.add(jsonArray.getString(i));

                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            minAdapter.notifyDataSetChanged();
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        return list;
    }
}
