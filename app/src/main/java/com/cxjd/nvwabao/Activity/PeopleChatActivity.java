package com.cxjd.nvwabao.Activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.view.Menu;
import android.view.View;
import com.cxjd.nvwabao.R;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cxjd.nvwabao.adapter.PeopleChatAdapter;
import com.cxjd.nvwabao.bean.PeopleChat;
import com.cxjd.nvwabao.bean.PeopleReturn;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 白 on 2018/3/20.
 *
 * 与PeopleChatActivity2 互相刷新跳转
 */

public class PeopleChatActivity extends Activity implements View.OnClickListener {

    private ListView lvPeopleChat;
    //所有回复
    private List<PeopleReturn> peopleReturnList = new ArrayList<PeopleReturn>();
    //仅一个chat的回复
    private List<PeopleReturn> selectList = new ArrayList<>();
    //点击进入的病人
    private PeopleChat peopleChat;

    private int peopleId;

    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1_activity_people_chat_item);

        //淡入淡出需要
        getWindow().setEnterTransition(new Fade().setDuration(1000));
        getWindow().setExitTransition(new Fade().setDuration(1000));

        lvPeopleChat = (ListView) findViewById(R.id.lvPeopleChat);
        //读取 或 初始化 数据
        getData();


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String id =bundle.getString("id");
        System.out.println("id为+++++++++++++++++++++"+id);
        peopleId = Integer.parseInt(id);

        //病人收到的回复
        select(peopleId);

        System.out.println("编号"+peopleId);
        System.out.println("ssssssssssssss"+peopleChat.getPeopleId()+"----"+peopleChat.getChat());




        ImageView imageView = (ImageView) findViewById(R.id.people_image);
        imageView.setImageResource(peopleChat.getImageId());

        TextView people_name = (TextView) findViewById(R.id.people_name);
        people_name.setText(peopleChat.getName());
        TextView people_chat = (TextView) findViewById(R.id.people_chat);
        people_chat.setText(peopleChat.getChat());
        TextView peple_zan = (TextView) findViewById(R.id.people_zan);
        String zan = peopleChat.getZan() + "";
        peple_zan.setText(zan);

        ImageView peopleZanAdd = (ImageView) findViewById(R.id.people_zan_add);
        peopleZanAdd.setOnClickListener(this);

        ImageView ask = (ImageView) findViewById(R.id.ask);
        ask.setOnClickListener(this);





        //关联数据和子布局
        PeopleChatAdapter peopleChatAdapter = new PeopleChatAdapter(this, R.layout.a1_people_chat_item, selectList);

        lvPeopleChat.setAdapter(peopleChatAdapter);  //绑定数据和适配器

        //  列表 单项点击按钮  可直接使用
        /*lvPeopleChat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                PeopleReturn peopleChat = peopleReturnList.get(position); //获取点击行数

                Intent intent = new Intent(PeopleChatActivity.this, PeopleChatOneActivity.class);
                intent.putExtra("chat", peopleChat.getReturnChat());

                startActivity(intent);
            }
        });*/

    }

    private void getData() {

        peopleReturnList = DataSupport.findAll(PeopleReturn.class);

        if (peopleReturnList.size() < 5) {
            int[] returnIds = {1,2,3,4,5,6,7,8,9,10,11,12};
            int[] peopleIds = {1,2,2,2,3,4,5,5,2,2,1,7};
            int[] imageIds = {R.drawable.a1_people,R.drawable.a1_people ,R.drawable.a1_people,R.drawable.a1_people
                    ,R.drawable.a1_people,R.drawable.a1_people,R.drawable.a1_people,R.drawable.a1_people
                    ,R.drawable.a1_people,R.drawable.a1_people,R.drawable.a1_people,R.drawable.a1_people};   //图片存储
            String[] returnChats = { "ssssss", "dddddd","肝炎","心脏病","fsdsds","dsasassd","ssssss", "dddddd","肝炎","心脏病","fsdsds","dsasassd" };
            String[] returnNames = {"asss","烦烦烦","水水","顶顶"
                    ,"匹配","搜搜","啊啊","版本"
                    ,"啊啊啊","你你你","密码","阿奇"};

            for(int i=0;i<imageIds.length;i++){                  //将数据添加到集合中

                //peopleChatList.add(new PeopleChat(imageIds[i],names[i]));  //将图片id和对应的name存储到一起
                PeopleReturn peopleReturn = new PeopleReturn();
                peopleReturn.setReturnId(returnIds[i]);
                peopleReturn.setPeopleId(peopleIds[i]);
                peopleReturn.setImageId(imageIds[i]);
                peopleReturn.setReturnChat(returnChats[i]);
                peopleReturn.setReturnName(returnNames[i]);
                peopleReturnList.add(peopleReturn);
                peopleReturn.save();
            }
        }

    }

    //筛选出 单个聊天的回复集合
    private void select(int peopleId) {
        for(int i=peopleReturnList.size()-1;i>=0;i--) {
            if (peopleReturnList.get(i).getPeopleId() == peopleId) {
                selectList.add(peopleReturnList.get(i));
            }
        }

        List<PeopleChat> peopleChats = DataSupport.findAll(PeopleChat.class);

        ForA:  for (int i=0;i<peopleChats.size();i++) {
               if (peopleId == peopleChats.get(i).getPeopleId()) {
                   peopleChat = peopleChats.get(i);
                   System.out.println("找到了水水水水水水水水水水水水水水水水水水水"+peopleChat.getZan());
                    break ForA;
                 }
                }
        System.out.println("找到了咩咩咩咩咩咩咩咩咩咩咩咩");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.people_zan_add:

                String id = peopleId + "";
                List<PeopleChat> pList = DataSupport.where("peopleId = ?", id).find(PeopleChat.class);
                int zan = pList.get(0).getZan() + 1;

                PeopleChat pUpdate = new PeopleChat();
                pUpdate.setZan(zan);
                pUpdate.updateAll("peopleId = ?", id);

                progressDialog = new ProgressDialog(PeopleChatActivity.this);
                progressDialog.setTitle("点赞成功....");
                progressDialog.setMessage("Loading.....");
                progressDialog.setCancelable(true); //可按返回取消
                progressDialog.show();

                refresh(view);
                break;
            case R.id.ask:
                Intent returnPeople = new Intent(PeopleChatActivity.this, PeopleChatOneActivity.class);
                returnPeople.putExtra("id", peopleId);
                startActivity(returnPeople);
                break;

        }

    }

    //刷新页面
    private void refresh(View view) {
        finish();
        Intent add = new Intent(PeopleChatActivity.this, PeopleChatActivity.class);
        String id = peopleChat.getPeopleId() + "";
        Bundle bundle=new Bundle();
        bundle.putString("id",id);
        add.putExtras(bundle);
        startActivity(add,ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

    }

    //销毁进度条 Dialog
    @Override
    protected void onDestroy() {
        if(progressDialog != null) {
            progressDialog.dismiss();
        }
        super.onDestroy();
    }
}
