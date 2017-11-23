package com.cxjd.nvwabao.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.utils.HttpUtil;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Disease extends AppCompatActivity {
    private  List<String> returnList;
   // private TextView zhengzhuang,bingyin,yufang,zhiliao;
  //  private TextView zhengzhuangbtn,bingyinbtn,yufangbtn,zhiliaobtn;
    private String partName,contents,reason,sickName,prevention,diagnostic;
   private ExpandableTextView ZZexpTv1,BYexpTv2,YFexpTv1,ZLexpTv2;
   private  TextView disTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        disTitle = (TextView) findViewById(R.id.disTitle);
        //     Log.e("what",getIntent().getStringExtra("what"));
            String x = getIntent().getStringExtra("what");
        if (x==null){
            String UrlR = getIntent().getStringExtra("Room");
            listDataRoom(UrlR);
        }else if (Integer.parseInt(x) == 1){
            String Url = getIntent().getStringExtra("xq");
            listData(Url);
        }



   /*   if (getIntent().getBooleanExtra("Room",true)) {

        }
*/
        Button back = (Button) findViewById(R.id.nav_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        returnList = new ArrayList<>();


       // Message message = new Message();
        //handler.sendMessage(message);
        System.out.println(contents);
      //  reason =  returnList.get(2);
        init();

    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

        }
    };
    private void init() {
        ZZexpTv1 = (ExpandableTextView) findViewById(R.id.zhengzhuang)
                .findViewById(R.id.expand_text_view);
         BYexpTv2 = (ExpandableTextView) findViewById(R.id.bingyin)
                .findViewById(R.id.expand_text_view);
        YFexpTv1 = (ExpandableTextView) findViewById(R.id.yufang)
                .findViewById(R.id.expand_text_view);
        ZLexpTv2 = (ExpandableTextView) findViewById(R.id.zhiliao)
                .findViewById(R.id.expand_text_view);

       // ZZexpTv1.setText(contents);
        //BYexpTv2.setText(getString(R.string.dummy_text2));
        //YFexpTv1.setText(getString(R.string.dummy_text1));
        //ZLexpTv2.setText(getString(R.string.dummy_text2));

    }
    private void listData(String url) {

        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Disease.this, "获取数据失败", Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                try {


                    //String responseData = response.body().string();
                    //JSONArray jsonArray = new JSONArray(responseData);
                    JSONObject jsonObject = new JSONObject( response.body().string());
                   // System.out.println(jsonObject.getString("contents"));
                    returnList.add(jsonObject.getString("partName"));
                   // contents = jsonObject.getString("contents");
                    //System.out.println(contents);
                    ZZexpTv1.setText(jsonObject.getString("contents"));
                    BYexpTv2.setText(jsonObject.getString("reason"));
                    disTitle.setText(jsonObject.getString("sicksName"));
                    YFexpTv1.setText(jsonObject.getString("prevention"));
                    ZLexpTv2.setText(jsonObject.getString("diagnostic"));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    private void listDataRoom(String url) {

        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Disease.this, "获取数据失败", Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                try {


                    //String responseData = response.body().string();
                    //JSONArray jsonArray = new JSONArray(responseData);
                    JSONObject jsonObject = new JSONObject( response.body().string());
                    // System.out.println(jsonObject.getString("contents"));
                    //returnList.add(jsonObject.getString("partName"));
                    // contents = jsonObject.getString("contents");
                    //System.out.println(contents);
                    ZZexpTv1.setText(jsonObject.getString("contents"));
                    BYexpTv2.setText(jsonObject.getString("symptom"));
                    disTitle.setText(jsonObject.getString("sicksName"));
                    YFexpTv1.setText(jsonObject.getString("prevention"));
                    ZLexpTv2.setText(jsonObject.getString("cure"));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
