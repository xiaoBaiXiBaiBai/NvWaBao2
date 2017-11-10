package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.utils.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Room extends AppCompatActivity {
    private TextView neike, waike, fuchanke, xiaoerke, wuguanke, nanke, chuanranke, pifuke, xingbingke, jingshenxinlike, zhongliuke, buyunbuyuke;
    private ListView neikelv,waikelv,fuchankelv, xiaoerkelv, wuguankelv, nankelv, chuanrankelv, pifukelv, xingbingkelv, jingshenxinlikelv, zhongliukelv, buyunbuyukelv, minlv;
    private List<String> leftList, minList,neikeList,waikeList,fuchankeList, xiaoerkeList, wuguankeList, nankeList, chuanrankeList, pifukeList, xingbingkeList, jingshenxinlikeList, zhongliukeList, buyunbuyukeList;
    private ArrayAdapter<String> arr_adapter, minAdapter;
    private  String UrlBase = "http://192.168.31.227/user/getDepartments/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        Button  back = (Button) findViewById(R.id.nav_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        leftList = new ArrayList<>();
        init();

        minList = new ArrayList<>();
        listData(UrlBase+"0/0", minList);
        minlv = (ListView) findViewById(R.id.min_itemRoom);
        minAdapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, minList);
        minlv.setAdapter(minAdapter);

        initChange();


        minlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentDis = new Intent(Room.this, Disease.class);
                intentDis.putExtra("xq", position);
                startActivity(intentDis);
            }
        });
    }

    private void init() {
        neikelv = (ListView) findViewById(R.id.neikels);
        neike = (TextView) findViewById(R.id.neike);
        neikeList =    listData(UrlBase+"0", leftList);
        arr_adapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, neikeList);
        neikelv.setAdapter(arr_adapter);
        listSet(neike,neikelv,0);

        waikelv = (ListView) findViewById(R.id.waikels);
        waike = (TextView) findViewById(R.id.waike);
        waikeList =  listData(UrlBase+"1", leftList);
        arr_adapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, waikeList);
        waikelv.setAdapter(arr_adapter);
        listSet(waike,waikelv,1);

        fuchankelv = (ListView) findViewById(R.id.fuchankels);
        fuchanke = (TextView) findViewById(R.id.fuchanke);
        fuchankeList =  listData(UrlBase+"2", leftList);
        arr_adapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, fuchankeList);
        fuchankelv.setAdapter(arr_adapter);
        listSet(fuchanke,fuchankelv,2);

        xiaoerkelv = (ListView) findViewById(R.id.xiaoerkels);
        xiaoerke = (TextView) findViewById(R.id.xiaoerke);
        xiaoerkeList =  listData(UrlBase+"3", leftList);
        arr_adapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, xiaoerkeList);
        xiaoerkelv.setAdapter(arr_adapter);
        listSet(xiaoerke,xiaoerkelv,3);

        wuguankelv = (ListView) findViewById(R.id.wuguankels);
        wuguanke = (TextView) findViewById(R.id.wuguanke);
        wuguankeList =  listData(UrlBase+"4", leftList);
        arr_adapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, wuguankeList);
        wuguankelv.setAdapter(arr_adapter);
        listSet(wuguanke,wuguankelv,4);

        nankelv = (ListView) findViewById(R.id.nankels);
        nanke = (TextView) findViewById(R.id.nanke);
        nankeList =  listData(UrlBase+"5", leftList);
        arr_adapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, nankeList);
        nankelv.setAdapter(arr_adapter);
        listSet(nanke,nankelv,5);

        chuanrankelv = (ListView) findViewById(R.id.chuanrankels);
        chuanranke = (TextView) findViewById(R.id.chuanranke);
        chuanrankeList =  listData(UrlBase+"6", leftList);
        arr_adapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, chuanrankeList);
        chuanrankelv.setAdapter(arr_adapter);
        listSet(chuanranke,chuanrankelv,6);

        pifukelv = (ListView) findViewById(R.id.pifukels);
        pifuke = (TextView) findViewById(R.id.pifuke);
        pifukeList =  listData(UrlBase+"7", leftList);
        arr_adapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, pifukeList);
        pifukelv.setAdapter(arr_adapter);
        listSet(pifuke,pifukelv,7);

        xingbingkelv = (ListView) findViewById(R.id.xingbingkels);
        xingbingke = (TextView) findViewById(R.id.xingbingke);
        xingbingkeList =  listData(UrlBase+"8", leftList);
        arr_adapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, xingbingkeList);
        xingbingkelv.setAdapter(arr_adapter);
        listSet(xingbingke,xingbingkelv,8);

        jingshenxinlikelv = (ListView) findViewById(R.id.jingshenxinlikels);
        jingshenxinlike = (TextView) findViewById(R.id.jingshenxinlike);
        jingshenxinlikeList =  listData(UrlBase+"9", leftList);
        arr_adapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, jingshenxinlikeList);
        jingshenxinlikelv.setAdapter(arr_adapter);
        listSet(jingshenxinlike,jingshenxinlikelv,9);

        zhongliukelv = (ListView) findViewById(R.id.zhongliukels);
        zhongliuke = (TextView) findViewById(R.id.zhongliuke);
        zhongliukeList =  listData(UrlBase+"10", leftList);
        arr_adapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, zhongliukeList);
        zhongliukelv.setAdapter(arr_adapter);
        listSet(zhongliuke,zhongliukelv,10);

        buyunbuyukelv = (ListView) findViewById(R.id.buyunbuyukels);
        buyunbuyuke = (TextView) findViewById(R.id.buyunbuyuke);
        buyunbuyukeList =  listData(UrlBase+"11", leftList);
        arr_adapter = new ArrayAdapter<String>(Room.this, android.R.layout.simple_list_item_1, buyunbuyukeList);
        buyunbuyukelv.setAdapter(arr_adapter);
        listSet(buyunbuyuke,buyunbuyukelv,11);
    }
    private void initChange() {
        listSetChange(neikelv);
        listSetChange(waikelv);
        listSetChange(fuchankelv);
    }
    private void listSet(TextView textView,ListView listView ,int id) {



        final ListView finalListView = listView;
        final TextView finalTextView = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalListView.getVisibility() == View.GONE) {
                    finalTextView.setTextColor(Color.parseColor("#FFFFFF"));
                    finalTextView.setBackgroundColor(Color.parseColor("#1aaee1"));
                    finalListView.setVisibility(View.VISIBLE);
                } else if (finalListView.getVisibility() == View.VISIBLE) {
                    finalTextView.setTextColor(Color.parseColor("#000000"));
                    finalTextView.setBackgroundColor(Color.parseColor("#F0F0F0"));
                    finalListView.setVisibility(View.GONE);
                }

            }
        });
    }

    private void listSetChange(final ListView listView) {


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {


                listData(UrlBase+"1/" + position, minList);
                    Message message = new Message();
                handler.sendMessage(message);
                //minAdapter.notifyDataSetChanged();
            }
        });

    }
;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            minAdapter.notifyDataSetChanged();
        }
    };
    private List<String> listData(String url, final List<String> list) {
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Room.this, "获取数据失败", Toast.LENGTH_SHORT).show();

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

}