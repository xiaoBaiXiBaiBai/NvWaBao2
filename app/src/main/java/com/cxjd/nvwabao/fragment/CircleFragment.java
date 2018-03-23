package com.cxjd.nvwabao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.nvwabao.Activity.PeopleChatActivity;
import com.cxjd.nvwabao.Activity.PeopleChatOneActivity;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.PeopleChat;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 李超 on 2017/10/29.
 */

public class CircleFragment extends Fragment implements View.OnClickListener {

    private List<PeopleChat> peopleChatList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle,container,false);


        //设置病人信息
        setDate(view);


        System.out.println("数量"+peopleChatList.size());
        System.out.println(peopleChatList.get(0).getName());

        //加载所有点击项目信息
        TextView people_1 = view.findViewById(R.id.people_1);
        people_1.setText(peopleChatList.get(0).getName());
        TextView textView1 = view.findViewById(R.id.chat_1);
        textView1.setText(peopleChatList.get(0).getChat());
        ImageView imageView1 = view.findViewById(R.id.image_1);
        imageView1.setImageResource(peopleChatList.get(0).getImageId());


        TextView people_2 = view.findViewById(R.id.people_2);
        people_2.setText(peopleChatList.get(1).getName());
        TextView textView2 = view.findViewById(R.id.chat_2);
        textView2.setText(peopleChatList.get(1).getChat());
        ImageView imageView2 = view.findViewById(R.id.image_2);
        imageView2.setImageResource(peopleChatList.get(1).getImageId());

        TextView people_3 = view.findViewById(R.id.people_3);
        people_3.setText(peopleChatList.get(2).getName());
        TextView textView3 = view.findViewById(R.id.chat_3);
        textView3.setText(peopleChatList.get(2).getChat());
        ImageView imageView3 = view.findViewById(R.id.image_3);
        imageView3.setImageResource(peopleChatList.get(2).getImageId());

        TextView people_4 = view.findViewById(R.id.people_4);
        people_4.setText(peopleChatList.get(3).getName());
        TextView textView4 = view.findViewById(R.id.chat_4);
        textView4.setText(peopleChatList.get(3).getChat());
        ImageView imageView4 = view.findViewById(R.id.image_4);
        imageView4.setImageResource(peopleChatList.get(3).getImageId());

        TextView people_5 = view.findViewById(R.id.people_5);
        people_5.setText(peopleChatList.get(4).getName());
        TextView textView5 = view.findViewById(R.id.chat_5);
        textView5.setText(peopleChatList.get(4).getChat());
        ImageView imageView5 = view.findViewById(R.id.image_5);
        imageView5.setImageResource(peopleChatList.get(4).getImageId());

        TextView people_6 = view.findViewById(R.id.people_6);
        people_6.setText(peopleChatList.get(5).getName());
        TextView textView6 = view.findViewById(R.id.chat_6);
        textView6.setText(peopleChatList.get(5).getChat());
        ImageView imageView6 = view.findViewById(R.id.image_6);
        imageView6.setImageResource(peopleChatList.get(5).getImageId());

        TextView people_7 = view.findViewById(R.id.people_7);
        people_7.setText(peopleChatList.get(6).getName());
        TextView textView7 = view.findViewById(R.id.chat_7);
        textView7.setText(peopleChatList.get(6).getChat());
        ImageView imageView7 = view.findViewById(R.id.image_7);
        imageView7.setImageResource(peopleChatList.get(6).getImageId());

        TextView people_8 = view.findViewById(R.id.people_8);
        people_8.setText(peopleChatList.get(7).getName());
        TextView textView8 = view.findViewById(R.id.chat_8);
        textView8.setText(peopleChatList.get(7).getChat());
        ImageView imageView8 = view.findViewById(R.id.image_8);
        imageView8.setImageResource(peopleChatList.get(7).getImageId());

        TextView people_9 = view.findViewById(R.id.people_9);
        people_9.setText(peopleChatList.get(8).getName());
        TextView textView9 = view.findViewById(R.id.chat_9);
        textView9.setText(peopleChatList.get(8).getChat());
        ImageView imageView9 = view.findViewById(R.id.image_9);
        imageView9.setImageResource(peopleChatList.get(8).getImageId());

        TextView people_10 = view.findViewById(R.id.people_10);
        people_10.setText(peopleChatList.get(9).getName());
        TextView textView10 = view.findViewById(R.id.chat_10);
        textView10.setText(peopleChatList.get(9).getChat());
        ImageView imageView10 = view.findViewById(R.id.image_10);
        imageView10.setImageResource(peopleChatList.get(9).getImageId());

        TextView people_11 = view.findViewById(R.id.people_11);
        people_11.setText(peopleChatList.get(10).getName());
        TextView textView11 = view.findViewById(R.id.chat_11);
        textView11.setText(peopleChatList.get(10).getChat());
        ImageView imageView11 = view.findViewById(R.id.image_11);
        imageView11.setImageResource(peopleChatList.get(10).getImageId());

        TextView people_12 = view.findViewById(R.id.people_12);
        people_12.setText(peopleChatList.get(11).getName());
        TextView textView12 = view.findViewById(R.id.chat_12);
        textView12.setText(peopleChatList.get(11).getChat());
        ImageView imageView12 = view.findViewById(R.id.image_12);
        imageView12.setImageResource(peopleChatList.get(11).getImageId());

        TextView people_13 = view.findViewById(R.id.people_13);
        people_13.setText(peopleChatList.get(12).getName());
        TextView textView13 = view.findViewById(R.id.chat_13);
        textView13.setText(peopleChatList.get(12).getChat());
        ImageView imageView13 = view.findViewById(R.id.image_13);
        imageView13.setImageResource(peopleChatList.get(12).getImageId());

        TextView people_14 = view.findViewById(R.id.people_14);
        people_14.setText(peopleChatList.get(13).getName());
        TextView textView14 = view.findViewById(R.id.chat_14);
        textView14.setText(peopleChatList.get(13).getChat());
        ImageView imageView14 = view.findViewById(R.id.image_14);
        imageView14.setImageResource(peopleChatList.get(13).getImageId());

        TextView people_15 = view.findViewById(R.id.people_15);
        people_15.setText(peopleChatList.get(14).getName());
        TextView textView15 = view.findViewById(R.id.chat_15);
        textView15.setText(peopleChatList.get(14).getChat());
        ImageView imageView15 = view.findViewById(R.id.image_15);
        imageView15.setImageResource(peopleChatList.get(14).getImageId());

        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView5.setOnClickListener(this);
        textView6.setOnClickListener(this);
        textView7.setOnClickListener(this);
        textView8.setOnClickListener(this);
        textView9.setOnClickListener(this);
        textView10.setOnClickListener(this);
        textView11.setOnClickListener(this);
        textView12.setOnClickListener(this);
        textView13.setOnClickListener(this);
        textView14.setOnClickListener(this);
        textView15.setOnClickListener(this);




        //设置TabHost组件
        final TabHost tabHost = view.findViewById(R.id.cr_tabhost);
        //初始化TabHost容器
        tabHost.setup();
        //创建第一个Tab页面
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1").setIndicator("动态").setContent(R.id.cr_tab_01);
        //添加第一个标签页
        tabHost.addTab(tab1);
        //创建第二个Tab页面
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2").setIndicator("圈子").setContent(R.id.cr_tab_02);
        //添加第二个Tab页面
        tabHost.addTab(tab2);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chat_1:
                Intent intent = new Intent(getActivity(), PeopleChatActivity.class);
                intent.putExtra("id", 2);
                startActivity(intent);
                break;
            case R.id.chat_2:
                Toast.makeText(getActivity(), "成功2", Toast.LENGTH_SHORT).show();
                break;
                
        }
    }


    //设置病人头像和各种信息
    public void setDate(View view) {
        peopleChatList = DataSupport.findAll(PeopleChat.class);
        if (peopleChatList.size()>5) {
            //DataSupport.deleteAll(PeopleChat.class, "id < ?", "100");
            peopleChatList = DataSupport.findAll(PeopleChat.class);
        } else {

            String[] names = {"15702456985","15896788850","13969652586","与一","枯木"
                    ,"15398080200","天涯","13996850330","CC","奋斗人生"
                    ,"17455562855","16598840023","苦涩咖啡","18995002028","15879633029"};
            int[] ids = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            String[] chats = {"查晚上睡不熟怎么办 总是惊醒",
                    "口渴厉害，血糖又不高，饭后口渴得很，特别是夜里","昨天刚做完腋臭手术。把绷带拆了","消炎液可以擦脸部吗，脸上有皮外伤",
                    "拉尿拉出的是白色液体要看什么科","昨天早上被铁片割伤，铁片看起来没有生锈，会不会得破伤风啊","我在私人医院做完包皮手术，医生叫我连续几天来医院换药",
                    "一个多月的婴儿！之前医生说是肺炎！现在炎症好了！","牙齿上面的肉里面长了一块一块的黑色的东西，在肉里面","九个月小孩能吃抗病毒糖浆吗？说明书上写的孕妇哺乳期妇女禁用",
                    "慢性食管炎怎么治疗食管炎停了药就发作","老年人糖尿病9天没拉大便","小孩一个月都会有几次偶尔脚手发麻是什么原因引起的",
                    "婴儿小腿肚肌肉有硬块怎么回事阿？？？宝宝刚出生21天。谢谢","紫钉这个病怎么治我想知道。"};
            int[] imagesIds = {R.drawable.a1_people,R.drawable.a1_people,R.drawable.a1_people,R.drawable.people4,R.drawable.people5,
                    R.drawable.a1_people,R.drawable.people1,R.drawable.a1_people,R.drawable.people2,R.drawable.a1_people
                    ,R.drawable.a1_people,R.drawable.a1_people,R.drawable.people3,R.drawable.a1_people,R.drawable.a1_people};
            for(int i=0;i<chats.length;i++) {
                PeopleChat peopleChat = new PeopleChat();
                peopleChat.setId(ids[i]);
                peopleChat.setName(names[i]);
                peopleChat.setChat(chats[i]);
                peopleChat.setImageId(imagesIds[i]);
                peopleChat.save();
                peopleChatList.add(peopleChat);
            }
        }

    }
}


