package com.cxjd.nvwabao.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import com.cxjd.nvwabao.R;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cxjd.nvwabao.adapter.PeopleChatAdapter;
import com.cxjd.nvwabao.bean.PeopleChat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 白 on 2018/3/20.
 */

public class PeopleChatActivity extends Activity {

    private ListView lvPeopleChat;
    private List<PeopleChat> peopleChatList = new ArrayList<PeopleChat>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1_activity_people_chat_item);

        lvPeopleChat = (ListView) findViewById(R.id.lvPeopleChat);
        getData();

        //关联数据和子布局
        PeopleChatAdapter peopleChatAdapter = new PeopleChatAdapter(this, R.layout.a1_people_chat_item, peopleChatList);

        lvPeopleChat.setAdapter(peopleChatAdapter);  //绑定数据和适配器

        lvPeopleChat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                PeopleChat peopleChat = peopleChatList.get(position); //获取点击行数

                Intent intent = new Intent(PeopleChatActivity.this, PeopleChatOneActivity.class);
                intent.putExtra("chat", peopleChat.getChat());

                startActivity(intent);
            }
        });

    }

    private void getData() {
        int[] imageIds = {R.drawable.a1_people,R.drawable.a1_people ,R.drawable.a1_people,R.drawable.a1_people
                ,R.drawable.a1_people,R.drawable.a1_people,R.drawable.a1_people,R.drawable.a1_people
                ,R.drawable.a1_people,R.drawable.a1_people,R.drawable.a1_people,R.drawable.a1_people};   //图片存储
        String[] names = { "ssssss", "dddddd","肝炎","心脏病","fsdsds","dsasassd","ssssss", "dddddd","肝炎","心脏病","fsdsds","dsasassd" };
        for(int i=0;i<imageIds.length;i++){                  //将数据添加到集合中

            PeopleChat peopleChat = new PeopleChat(imageIds[i],names[i]);
            //peopleChatList.add(new PeopleChat(imageIds[i],names[i]));  //将图片id和对应的name存储到一起
            peopleChatList.add(peopleChat);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
