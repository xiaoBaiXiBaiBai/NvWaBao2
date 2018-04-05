package com.cxjd.nvwabao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
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

    private List<PeopleChat> peopleChatList = new ArrayList<>(); //总数据
    private List<PeopleChat> someList = new ArrayList<>();      //取部分数据  每次刷新都增加
    private ListView list_people;
    private CircleFragmentAdapter circleFragmentAdapter;

    private View footer;    //底部刷新

    private ProgressBar footProgressBar;

    //是否加载标示
    int isLoading = 1;

    TextView loading_text;


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

        //加底部刷新
        addListViewFooterView();
        list_people.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                // 当不滚动时
                if (scrollState == SCROLL_STATE_IDLE) {
                    //判断是否滚动到底部
                    if (isLoading == 1 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                List<PeopleChat> otherList = new ArrayList<>();
                                for (int i = peopleChatList.size() - 10; i <= peopleChatList.size() - 8; i++) {
                                    otherList.add(peopleChatList.get(i));
                                }
                                someList.addAll(otherList);
                                circleFragmentAdapter.notifyDataSetChanged();
                                Log.i("testUpdate", "run: 进入 1");

                            }
                        }, 3000);
                        isLoading++;
                        System.out.println("进入刷新   +++++++" + someList.size());
                        return;
                    } else  if (isLoading == 2 && absListView.getLastVisiblePosition() == absListView.getCount() - 1){

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                List<PeopleChat> otherList = new ArrayList<>();
                                for (int i = peopleChatList.size() - 7; i <= peopleChatList.size() - 5; i++) {
                                    otherList.add(peopleChatList.get(i));
                                }
                                someList.addAll(otherList);
                                circleFragmentAdapter.notifyDataSetChanged();
                                Log.i("testUpdate", "run: 进入 2");

                            }
                        }, 6000);

                        System.out.println("进入刷新   +++++++" + someList.size());
                        isLoading++;

                        return;
                    }else if (isLoading == 3 && absListView.getLastVisiblePosition() == absListView.getCount() - 1){
                        loading_text.setText("网络环境较差！");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                List<PeopleChat> otherList = new ArrayList<>();
                                for (int i = peopleChatList.size() - 4; i <= peopleChatList.size() - 3; i++) {
                                    otherList.add(peopleChatList.get(i));
                                }
                                someList.addAll(otherList);
                                circleFragmentAdapter.notifyDataSetChanged();
                                Log.i("testUpdate", "run: 进入 3");

                            }
                        }, 10000);
                        isLoading++;


                        return;
                    }else if (isLoading == 4 && absListView.getLastVisiblePosition() == absListView.getCount() - 1){
                        loading_text.setText("网络环境较差！");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                List<PeopleChat> otherList = new ArrayList<>();
                                for (int i = peopleChatList.size() - 2; i <= peopleChatList.size() - 1; i++) {
                                    otherList.add(peopleChatList.get(i));
                                }
                                someList.addAll(otherList);
                                circleFragmentAdapter.notifyDataSetChanged();
                                Log.i("testUpdate", "run: 进入 4");

                            }
                        }, 15000);
                        isLoading++;

                        return;
                    }
                }

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });

        return view;
    }

    private void initview(View view) {
        TextView titile = (TextView) view.findViewById(R.id.fragment_title);
        titile.setText("动态");

        ImageView sendTie = (ImageView) view.findViewById(R.id.circle_send_tie);
        sendTie.setOnClickListener(this);

        loading_text = (TextView) view.findViewById(R.id.loading_text);

        list_people = (ListView)view.findViewById(R.id.list_people);

        //关联数据和子布局
        circleFragmentAdapter = new CircleFragmentAdapter(getActivity(), R.layout.fragment_circle_context, someList);
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

        if (peopleChatList.size() < 1) {
            String[] names = {"15702456985", "15896788850", "13969652586", "与一", "枯木"
                    , "15398080200", "天涯", "13996850330", "CC", "奋斗人生"
                    , "17455562855", "16598840023", "苦涩咖啡", "18995002028", "15879633029"};
            int[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            String[] chats = {"油性皮肤毛孔粗大容易长痘痘印都有点多了每次长了一颗好了别处又会长一颗",
                    "孩子刚出生几个小时，检查结果是血象高的离谱41.1，而且不怎么爱动，是怎么回事呢？",
                    "3岁女儿发烧过度在重病科，已经从卫辉医院转移到郑州医院了，我都快吓得不行了，已经住院2天了，1天半没醒没吃饭，我都快崩溃了",
                    "用盐洗脸，脸肿了，还发红，还热，是怎么回事，在家应该用些什么？",
                    "脸蛋靠鼻子眼睛位置上长痘痘，怎么办啊？是青春痘吗？阿达帕林凝胶用过但是额头还行，脸上起皮…",

                    "我怀孕期间TSH偏高，一直吃优甲乐。现在哺乳期，42天检查结果是4.7显示有点高。母乳有影响吗？",
                    "这几个月月经都是推迟的，上次来月经是1/22，这次是3/24，月经刚过两天，今天发生关系，会不会怀孕?需不需要吃紧急避孕药?！",
                    "骨盆疼，尿道骨头疼，大胯疼什么原因，有时小肚子也跟着疼，不知道怎么回事",
                    "全麻手术插管子会伤害咽喉部位吗？如果伤害了几天会好？如果伤害了咽喉部位，手术后三天内吃了食物万一食物中有病毒，会进入咽喉部位伤害的粘膜处吗？",
                    "宝宝的头发有圈枕秃，查了微量元素钙并不缺少，医生建议吃鱼肝油和维D促进钙吸收。去药店买药师说维D跟鱼肝油是同一种营养物质。可以给他吃维D3吗？",

                    "出现腰酸痛,下腹部胀痛,尿黄,尿不尽,尿分叉,龟头和睾丸凉,附睾坠痛,性功能明显减退问问用些什么药",
                    "我在嘴唇下面长了一个风刺，然后嘴唇都是肿的，下巴，脸也有些肿了，去诊所，医生说吃消炎药就行了，让它慢慢好，但是真的很疼，请问应该怎么办？",
                    "我是1月8号月经结束，目前已怀孕多久了，什么时候可以去做b超",
                    "怎样服用黄体酮推迟月经一天吃多少我买的是一粒100毫克应该怎么吃。"
                    ,"宫颈息肉，3型转化区，之前有宫颈炎、盆腔积液，其他有甲亢，身体虚"
                    };
            int[] imagesIds = {R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people
                    , R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people
                    , R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people};

            int[] zans = {1, 2, 1, 1, 1, 2, 3, 1, 4, 1, 1, 2, 3, 1, 5};

            /*String[] infos = {"还好咯","去死吧","222","333",""
                    ,"aa","vv","ssss","mmm","杀杀杀"
                    ,"啊啊啊","买买买","来来来","方法","试试"};*/
            String[] address = {"合肥市","长春市","南京市","杭州市","沈阳市"
                    ,"福州市","杭州市","南昌市","广安市","青岛市"
                    ,"聊城市","福州市","福州市","西安市","大庆市"};

            String[] from = {"就医帮帮团","亲子育儿","妇科疾病","美容美体","美容美体"
                    ,"备孕怀孕","妇科疾病","男人帮","就医帮帮团","就医帮帮团"
                    ,"男人帮","美容美体","就医帮帮团","妇科疾病","就医帮帮团"};

            for (int i = 0; i < chats.length; i++) {
                PeopleChat peopleChat = new PeopleChat();
                System.out.println(ids[i]);
                peopleChat.setPeopleId(ids[i]);
                peopleChat.setName(names[i]);
                peopleChat.setChat(chats[i]);
                peopleChat.setImageId(imagesIds[i]);
                peopleChat.setZan(zans[i]);
                //peopleChat.setInfo(infos[i]);
                peopleChat.setAddress(address[i]);
                peopleChat.setFrom(from[i]);
                peopleChat.setZanAble(true);
                peopleChat.save();
                peopleChatList.add(peopleChat);
                System.out.println(peopleChat.getPeopleId());
            }

            Collections.reverse(peopleChatList);
            if (someList != null || !someList.isEmpty()) {
                someList.clear();
            }
            for (int i = 0;i<=peopleChatList.size()-11;i++) {
                someList.add(peopleChatList.get(i));
            }
        } else {
            //清空 PeopleChat 表使用
           /* DataSupport.deleteAll(PeopleChat.class);
            System.out.println("进入删除"+peopleChatList.size());*/
            Collections.reverse(peopleChatList);
            if (someList != null || !someList.isEmpty()) {
                someList.clear();
            }
            for (int i = 0;i<=peopleChatList.size()-11;i++) {
                someList.add(peopleChatList.get(i));
            }
            for (int i = 0;i<peopleChatList.size();i++) {
                System.out.println("id循环+"+peopleChatList.get(i).getPeopleId());
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.circle_send_tie:
                //发帖
                Intent intent = new Intent(getActivity(), PeopleSendTieActivity.class);
                startActivity(intent);
                break;
        }
    }


    //返回此页面刷新
    @Override
    public void onResume() {
        super.onResume();
        setDate(getView());
        initview(getView());
        isLoading = 1;
    }


    private void addListViewFooterView() {
        footer = getActivity().getLayoutInflater().inflate(R.layout.a1_activity_chat_update, null);
        list_people.addFooterView(footer);
    }

    /*合并准备*/}


