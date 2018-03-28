package com.cxjd.nvwabao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.cxjd.nvwabao.Activity.PeopleSendTieActivity;
import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.CircleFragmentAdapter;
import com.cxjd.nvwabao.bean.PeopleChat;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 李超 on 2017/10/29.
 */

public class CircleFragment extends Fragment implements View.OnClickListener {

    private List<PeopleChat> peopleChatList = new ArrayList<>();
    private ListView list_people;
    private CircleFragmentAdapter circleFragmentAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle,container,false);

        //设置病人信息
        setDate(view);

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



        //list_people.setOnItemClickListener(this);//废弃点击事件  换为adapter中 item内部多个点击事件


        System.out.println("数量为---------------------------------"+peopleChatList.size());

        initview(view);

        return view;
    }

    private void initview(View view) {
        TextView titile = (TextView) view.findViewById(R.id.fragment_title);
        titile.setText("动态");

        ImageView sendTie = (ImageView) view.findViewById(R.id.circle_send_tie);
        sendTie.setOnClickListener(this);



        list_people = (ListView)view.findViewById(R.id.list_people);

        //关联数据和子布局
        circleFragmentAdapter = new CircleFragmentAdapter(getActivity(), R.layout.fragment_circle_context, peopleChatList);
        //绑定数据和适配器
        list_people.setAdapter(circleFragmentAdapter);

    }


    //废弃点击事件  换为adapter中 item内部多个点击事件
/*    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        PeopleChat peopleChat = peopleChatList.get(position);

        Intent intent = new Intent(getActivity(), PeopleChatActivity.class);
        Bundle bundle = new Bundle();

        bundle.putInt("id", peopleChat.getPeopleId());
        intent.putExtras(bundle);

        startActivity(intent);
    }*/


    //设置病人头像和各种信息
    public void setDate(View view) {

        if (peopleChatList != null || !peopleChatList.isEmpty()) {
            peopleChatList.clear();
        }

        peopleChatList = DataSupport.findAll(PeopleChat.class);

        if (peopleChatList.size() < 5) {
            String[] names = {"15702456985", "15896788850", "13969652586", "与一", "枯木"
                    , "15398080200", "天涯", "13996850330", "CC", "奋斗人生"
                    , "17455562855", "16598840023", "苦涩咖啡", "18995002028", "15879633029"};
            int[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            String[] chats = {"查晚上睡不熟怎么办 总是惊醒",
                    "口渴厉害，血糖又不高，饭后口渴得很，特别是夜里", "昨天刚做完腋臭手术。把绷带拆了", "消炎液可以擦脸部吗，脸上有皮外伤",
                    "拉尿拉出的是白色液体要看什么科", "昨天早上被铁片割伤，铁片看起来没有生锈，会不会得破伤风啊", "我在私人医院做完包皮手术，医生叫我连续几天来医院换药",
                    "一个多月的婴儿！之前医生说是肺炎！现在炎症好了！", "牙齿上面的肉里面长了一块一块的黑色的东西，在肉里面", "九个月小孩能吃抗病毒糖浆吗？说明书上写的孕妇哺乳期妇女禁用",
                    "慢性食管炎怎么治疗食管炎停了药就发作", "老年人糖尿病9天没拉大便", "小孩一个月都会有几次偶尔脚手发麻是什么原因引起的",
                    "婴儿小腿肚肌肉有硬块怎么回事阿？？？宝宝刚出生21天。谢谢", "紫钉这个病怎么治我想知道。"};
            int[] imagesIds = {R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people, R.drawable.people4, R.drawable.people5,
                    R.drawable.a1_people, R.drawable.people1, R.drawable.a1_people, R.drawable.people2, R.drawable.a1_people
                    , R.drawable.a1_people, R.drawable.a1_people, R.drawable.people3, R.drawable.a1_people, R.drawable.a1_people};

            int[] zans = {1, 2, 1, 1, 1, 2, 3, 1, 4, 1, 1, 2, 3, 1, 5};

            String[] infos = {"还好咯","去死吧","222","333",""
                    ,"aa","vv","ssss","mmm","杀杀杀"
                    ,"啊啊啊","买买买","来来来","方法","试试"};
            for (int i = 0; i < chats.length; i++) {
                PeopleChat peopleChat = new PeopleChat();
                System.out.println(ids[i]);
                peopleChat.setPeopleId(ids[i]);
                peopleChat.setName(names[i]);
                peopleChat.setChat(chats[i]);
                peopleChat.setImageId(imagesIds[i]);
                peopleChat.setZan(zans[i]);
                peopleChat.setInfo(infos[i]);
                peopleChat.save();
                peopleChatList.add(peopleChat);
                System.out.println(peopleChat.getPeopleId());
            }

            Collections.reverse(peopleChatList);
        } else {
            //清空 PeopleChat 表使用
            /*DataSupport.deleteAll(PeopleChat.class, "id < ?", "10000");
            System.out.println("进入删除");*/
            Collections.reverse(peopleChatList);

            /*for (int i = 0;i<peopleChatList.size();i++) {
                System.out.println("id循环+"+peopleChatList.get(i).getPeopleId());
            }*/
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.circle_send_tie:
                Intent intent = new Intent(getActivity(), PeopleSendTieActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        setDate(getView());
        initview(getView());

    }
}


