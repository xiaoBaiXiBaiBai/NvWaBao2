package com.cxjd.nvwabao.Activity;

import android.content.Intent;
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

public class People2 extends AppCompatActivity {

    private ListView maxlv,minlv,neikeSonlv;
    private List<String> maxList,minList,neikeSonList;
    private ArrayAdapter<String> maxAdapter,minAdapter,neikeSonAdapter;
   // private  String UrlBase = "http://192.168.31.227/user/getParts/";
    private  String UrlBase = "http://192.168.31.227/user/getCrowdSick/";
    private int fPosition;
    private SelectAdapter adapter;
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





        maxList = new ArrayList<>();
        MaxData();
        maxlv = (ListView) findViewById(R.id.max_item);
    //    maxAdapter = new ArrayAdapter<String>(People2.this, R.layout.list_item, maxList);
       // maxlv.setAdapter(maxAdapter);
        adapter = new SelectAdapter(this,maxList);
        maxlv.setAdapter(adapter);
        adapter.setDefSelect(0);

        minList = new ArrayList<>();
        minList = minlistData(UrlBase+0,minList);
        minlv = (ListView) findViewById(R.id.min_item);

        minAdapter = new ArrayAdapter<String>(People2.this,android.R.layout.simple_list_item_1, minList);
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
                Intent intentDis = new Intent(People2.this, Disease.class);
                intentDis.putExtra("xq", UrlBase+fPosition+"/"+position);
                intentDis.putExtra("what","1");
                startActivity(intentDis);
            }
        });
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
       // maxList = listData(UrlBase,maxList);
        maxList.add("男人");
        maxList.add("女人");
        maxList.add("老人");
        maxList.add("小孩");
    }



    private List<String> listData(String url, final List<String> list) {
        Log.e("Url",url);
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(People2.this, "获取数据失败", Toast.LENGTH_SHORT).show();

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

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        return list;
    }
    private List<String> minlistData(String url, final List<String> list) {
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(People2.this, "获取数据失败", Toast.LENGTH_SHORT).show();

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
