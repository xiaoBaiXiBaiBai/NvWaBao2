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
import com.cxjd.nvwabao.bean.People;
import com.cxjd.nvwabao.utils.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PeopleActivity extends AppCompatActivity {

    private ListView maxlv,minlv;
    private List<String> minList;
    private List<com.cxjd.nvwabao.bean.People> maxList;
    private ArrayAdapter<String> maxAdapter,minAdapter;
    private  String UrlBase = "http://47.94.145.225/user/getPartForSex/";
    private  String UrlBase2 = "http://47.94.145.225/user/getParts/";
    //private  String UrlBase = "http://192.168.31.227/user/getCrowdSick/";
    private int fPosition;
  //  private Select2Adapter adapter;
   private SelectAdapter adapter;
    private int buwei;
    private  String xingbie;

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


        xingbie = getIntent().getStringExtra("xingbie");
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
        fPosition=buwei;
        minList = minlistData(UrlBase+buwei+"/"+xingbie,minList);
        minlv = (ListView) findViewById(R.id.min_item);

        minAdapter = new ArrayAdapter<String>(PeopleActivity.this,android.R.layout.simple_list_item_1, minList);
        minlv.setAdapter(minAdapter);


        maxlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setDefSelect(position);
                fPosition = position;
                minList = minlistData(UrlBase+position+"/"+xingbie,minList);
                Message message = new Message();
                handler.sendMessage(message);
            }
        });

        minlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentDis = new Intent(PeopleActivity.this, Disease.class);
                intentDis.putExtra("xq", UrlBase2+fPosition+"/"+position);
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
        People people0 = new People("头部",R.drawable.biebu_fan_qian);
        maxList.add(people0);
        People people1 = new People("头",R.drawable.biebu_fan_qian);
        maxList.add(people1);
        People people2 = new People("眼",R.drawable.biebu_fan_qian);
        maxList.add(people2);
        People people3 = new People("耳",R.drawable.biebu_fan_qian);
        maxList.add(people3);
        People people4 = new People("鼻",R.drawable.biebu_fan_qian);
        maxList.add(people4);
        People people5 = new People("口",R.drawable.biebu_fan_qian);
        maxList.add(people5);
        People people6 = new People("眉",R.drawable.biebu_fan_qian);
        maxList.add(people6);
        People people7 = new People("牙",R.drawable.biebu_fan_qian);
        maxList.add(people7);
        People people8 = new People("胸部",R.drawable.biebu_fan_qian);
        maxList.add(people8);
        People people9 = new People("腹部",R.drawable.biebu_fan_qian);
        maxList.add(people9);
        People people10 = new People("四肢",R.drawable.biebu_fan_qian);
        maxList.add(people10);
        People people11 = new People("上肢",R.drawable.biebu_fan_qian);
        maxList.add(people11);
        People people12 = new People("下肢",R.drawable.biebu_fan_qian);
        maxList.add(people12);
        People people13 = new People("颈部",R.drawable.biebu_fan_qian);
        maxList.add(people13);
        People people14 = new People("腰部",R.drawable.biebu_fan_qian);
        maxList.add(people14);
        People people15 = new People("背部",R.drawable.biebu_fan_qian);
        maxList.add(people15);
        People people16 = new People("臀部",R.drawable.biebu_fan_qian);
        maxList.add(people16);
        People people17 = new People("生殖部位",R.drawable.biebu_fan_qian);
        maxList.add(people17);
        People people18 = new People("男性生殖部位",R.drawable.biebu_fan_qian);
        maxList.add(people18);
        People people19 = new People("女性生殖部位",R.drawable.biebu_fan_qian);
        maxList.add(people19);
/*        maxList.add("头部");
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
        maxList.add("女性生殖部位");*/

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
                        Toast.makeText(PeopleActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                try {


                    String responseData = response.body().string();
                    JSONArray jsonArray = new JSONArray(responseData);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        //maxList.add(jsonArray.getString(i));

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
        Log.e("Url",url);
        HttpUtil.sendOkHttpRequest(url, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(PeopleActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();

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
