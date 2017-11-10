package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
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

public class Classify extends AppCompatActivity {

    private ListView maxlv,minlv,neikeSonlv;
    private List<String> maxList,minList,neikeSonList;
    private ArrayAdapter<String> maxAdapter,minAdapter,neikeSonAdapter;

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
        maxAdapter = new ArrayAdapter<String>(Classify.this, R.layout.list_item, maxList);
        maxlv.setAdapter(maxAdapter);



        minList = new ArrayList<>();
        Min0();
        minlv = (ListView) findViewById(R.id.min_item);

        minAdapter = new ArrayAdapter<String>(Classify.this,android.R.layout.simple_list_item_1, minList);
        minlv.setAdapter(minAdapter);

        maxlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:

                        minList.clear();
                        Min0();
                        minAdapter.notifyDataSetChanged();
                        break;
                    case 1:

                        minList.clear();
                        Min1();
                        minAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });
        minlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentDis = new Intent(Classify.this, Disease.class);
                intentDis.putExtra("xq", position);
                startActivity(intentDis);
            }
        });
    }


    public void MaxData(){
        maxList.add("内科");
        maxList.add("外科");
    }
    public void Min0(){
        for (int i = 0; i <20 ; i++) {
            minList.add("000000000");
            minList.add("000000000");
        }

    }
    public void Min1() {
        for (int i = 0; i <20 ; i++) {
            minList.add("1111111");
            minList.add("1111111");
        }

    }
    private List<String> listData(String url, final List<String> list) {
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Classify.this, "获取数据失败", Toast.LENGTH_SHORT).show();

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
