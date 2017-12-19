package com.cxjd.nvwabao.ActivityNews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.HttpTitleUtil;
import com.cxjd.nvwabao.adapter.ListDataSave;
import com.cxjd.nvwabao.adapter.NewsItemAdapter;
import com.cxjd.nvwabao.bean.ListView;
import com.cxjd.nvwabao.bean.TitleContentBean;
import com.cxjd.nvwabao.bean.User;

import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class MycenterActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ListDataSave listDataSave;
    User user= DataSupport.findFirst(User.class);
    List<TitleContentBean> titleContentBeans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycenter);
        recyclerView=findViewById(R.id.my_center_recycler);
        listDataSave=new ListDataSave(this,"MycenterActivity");
        requesList();
        titleContentBeans=new ArrayList<>();
        titleContentBeans=listDataSave.getDataList("MyShouCangcontent",TitleContentBean.class);
        final NewsItemAdapter adapter=new NewsItemAdapter(titleContentBeans,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void requesList() {
        String url="http://47.94.145.225/user/getCollection/"+34;
        HttpTitleUtil.sendHttpRequest(url, new HttpTitleUtil.HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String mycollect=jsonObject.getString("user_collection");
                    listDataSave.setDataList("MyShouCangcontent", HttpTitleUtil.parseJsonWithGSON(mycollect));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });

    }
}
