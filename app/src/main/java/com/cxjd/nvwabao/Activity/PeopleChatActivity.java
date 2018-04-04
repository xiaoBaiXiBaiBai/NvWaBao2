package com.cxjd.nvwabao.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import com.cxjd.nvwabao.R;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.nvwabao.adapter.PeopleChatAdapter;
import com.cxjd.nvwabao.bean.PeopleChat;
import com.cxjd.nvwabao.bean.PeopleReturn;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 白 on 2018/3/20.
 *
 * 回复列表
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

    private PeopleChatAdapter peopleChatAdapter;

    //进度条
    private ProgressDialog progressDialog;

    //是否允许点赞
    Boolean zanAble = true;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1_activity_people_chat_item);

/*        //淡入淡出需要
        getWindow().setEnterTransition(new Fade().setDuration(1000));
        getWindow().setExitTransition(new Fade().setDuration(1000));*/

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        peopleId =bundle.getInt("id");
        Log.i("peopletest", "onCreate: 获取的用户id为"+peopleId);

        //病人收到的回复
        select(peopleId);

        System.out.println("编号"+peopleId);
        System.out.println("ssssssssssssss"+peopleChat.getPeopleId()+"----"+peopleChat.getChat());

        initview();

        //  列表 单项点击按钮
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

    private void initview(){

        if (selectList != null||!selectList.isEmpty()) {
            selectList.clear();
        }
        //读取 或 初始化 数据
        getData();
        //病人收到的回复集合 获取
        select(peopleId);
        //个人 帖子加载
        ImageView imageView = (ImageView) findViewById(R.id.people_image);
        imageView.setImageResource(peopleChat.getImageId());

        TextView people_name = (TextView) findViewById(R.id.people_name);
        people_name.setText(peopleChat.getName());
        TextView people_chat = (TextView) findViewById(R.id.people_chat);
        people_chat.setText(peopleChat.getChat());
        TextView peple_zan = (TextView) findViewById(R.id.people_zan);
        String zan = peopleChat.getZan() + "";
        peple_zan.setText(zan);
        TextView peopleAddress = (TextView) findViewById(R.id.people_address);
        peopleAddress.setText(peopleChat.getAddress());

        ImageView peopleZanAdd = (ImageView) findViewById(R.id.people_zan_add);
        peopleZanAdd.setOnClickListener(this);

        ImageView ask = (ImageView) findViewById(R.id.ask);
        ask.setOnClickListener(this);


        //回复帖子列表加载
        //关联数据和子布局
        lvPeopleChat = (ListView) findViewById(R.id.lvPeopleChat);
        peopleChatAdapter = new PeopleChatAdapter(this, R.layout.a1_people_chat_item, selectList);

        lvPeopleChat.setAdapter(peopleChatAdapter);  //绑定数据和适配器

    }

    private void getData() {

        peopleReturnList = DataSupport.findAll(PeopleReturn.class);
        System.out.println("peopleReturnList数量"+peopleReturnList.size());

        if (peopleReturnList.size() < 1) {
            int[] returnIds = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13,14,15,16,17,18,19,20,21};
            int[] peopleIds = {15, 15, 2, 2, 13, 13, 13, 4, 5, 6, 6, 7,8,9,10,10,11,12,3,14,1};
            int[] imageIds = {R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people
                    , R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people
                    , R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people
                    , R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people
                    , R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people, R.drawable.a1_people
                    , R.drawable.a1_people};   //图片存储
            String[] returnChats = {"你好，根据你的描述患有宫颈息肉，宫颈息肉取活检做病理之后的话要五天才能出病理结果。耐心等待，大多妇科大夫凭经验还是能够判断息肉的性质的。",
                    "建议您宫颈息肉手术后禁同房及盆浴两个月的。必须保持心情舒畅，生活规律。保证睡眠",
                    " 这种情况不能排除是新生儿宫内感染的情况，建议继续给予抗生素抗感染治疗，宝宝出生的时候有缺氧的情况吗？",
                    "如果现在白细胞计数超过1.8万，就属于严重感染，最好使用头孢类药物抗感染治疗，配合给孩子多喝水促进代谢。",
                    "你好！如果平素月经周期规律，怀孕孕周及预产期的推算是从末次月经来潮的第一天算起的，你现在怀孕80多天了，快3个月了，可以做超声检查了",

                    "月经周期规律的情况下怀孕是从末次月经的第一天开始算的，一般四十天可以做B超确定是否宫内妊娠",
                    "在停经35天以上做B超能看出怀孕与否，怀孕期间营养要全面，心情要舒畅。",
                    "您好，请问您所说的情况使用日用品而引起颜面部的发红发痒及水肿，多是引起的过敏反应。最好是先用温开水洗净面部，外用镇静止痒的vb6软膏。口服抗过敏药物地氯雷他定同时服用钙剂。",
                    "你好：根据你的症状描述，没有图片，并结合年龄段，这个需要考虑就是青春痘，称为痤疮。阿达帕林是祛角质的，会引起脱皮，为正常反应的。",
                    "一般的患者属于甲亢患者，使用的药物属于激素一类的药物，是不可以进行哺乳",

                    "建议调整好心情，保持外阴清洁干燥禁刺激性食物，禁烟酒，哺乳期口服优甲乐没有多大影响，心情放松。",
                    "你好，根据你的描述，这种情况是不会怀孕的，月经结束后面的5天属于安全期，不需要服用紧急避孕药，紧急避孕药是有副作用的，平时尽量少用"
                    ,"这种情况建议你最好做个腹部彩超，可能是盆腔炎，首先要注意休息，可以口服的头孢类的药物，加上喹诺酮类的药物。一定要注意卫生！一般用药一周左右，慢慢就会好的"
                    ,"全麻手术是要插管子的，插管子的时候，一般有经验的医院都不至于造成咽喉部的损伤，除非是病人昏迷，抢救不配合的情况也有造成想的可能性，这也是没有办法的办法，为了救命，就顾不得这些了"
                    ,"孩子应该是由于缺乏微量元素，或者是由于缺钙引起的，可以使用维生素d"

                    ,"这个问题是因为宝宝不注意饮食卫生或缺乏微量元素引起的"
                    ,"你好，根据你的描述考虑，中年男性目前出现腰膝酸痛，伴随新功能下降建议你可以到医院做一个激素，六项检测，看是不是出现雄性激素分泌较少，可以口服金匮肾气丸和睾酮片，进行调理身体。"
                    ,"你好，建议你去正规的完美专卖店购买芦荟胶涂抹，平时不要用手去碰，饮食清淡，不要吃辛辣刺激的食物，保证大小便通畅很重要"
                    ,"一般出现反复发烧说明宝宝体内有炎症引起的，首先注意退烧，建议也要消炎，多喝水，同时用毛巾反复按摩宝宝的身体，物理降温.祝你健康"
                    ,"你好，如果平时月经规律，在应该来月经的前2天开始服用黄体酮。每天两次，每次1片。服用至可以来月经的前一天。会有恶心头晕，不要紧的，停育就好了"
                    ," 男性在青春期发育期间，荷尔蒙水平增高，最容易引起出痘，所以您要减少辛辣食物的刺激，不要抽烟喝酒，这才能缓解你的痘痘。"};
            String[] returnNames = {"王秀杰", "王丽", "张玉艳", "郭秋焕"
                    , "杨敏", "孙慧", "刘豹", "李宝屏"
                    , "席娟娟", "刘建芝", "韩丹", "高国静"
                    ,"郭晴","孙旭红","朱成浩","丁波"
                    ,"潘烈","黄晶华","张艳赏","何海平"
                    ,"宋红岩"};

            for (int i = 0; i < returnIds.length; i++) {                  //将数据添加到集合中

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
        } else {

            /*DataSupport.deleteAll(PeopleReturn.class);
            System.out.println("已删除所有回复");*/

           /* List<PeopleReturn> list = DataSupport.findAll(PeopleReturn.class);
            System.out.println("数量" + list.size());
            for (int i=0;i<list.size();i++) {
                System.out.println("删除后"+list.get(i));
            }*/

        }

    }



    //筛选出 单个聊天的回复集合
    private void select(int peopleId) {
        for(int i=peopleReturnList.size()-1;i>=0;i--) {
            if (peopleReturnList.get(i).getPeopleId() == peopleId) {
                selectList.add(peopleReturnList.get(i));
            }
            System.out.println(peopleReturnList.get(i));
        }

        List<PeopleChat> peopleChats = DataSupport.findAll(PeopleChat.class);

        ForA:  for (int i=0;i<peopleChats.size();i++) {
               if (peopleId == peopleChats.get(i).getPeopleId()) {
                   peopleChat = peopleChats.get(i);
                    break ForA;
                 }
                }
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

                if (zanAble) {
                    zanAble = false;
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
                    progressDialog.setProgress(100);
                    progressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            progressDialog.dismiss();
                        }
                    });
                    progressDialog.show();

                    //刷新使用
                    onResume();
                } else {
                    Toast.makeText(PeopleChatActivity.this, "只能点赞一次", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.ask:
                Intent returnPeople = new Intent(PeopleChatActivity.this, PeopleChatOneActivity.class);
                returnPeople.putExtra("id", peopleId);
                startActivity(returnPeople);
                break;

        }

    }



    //销毁进度条 Dialog
    @Override
    protected void onDestroy() {
        if(progressDialog != null) {
            progressDialog.dismiss();
        }
        super.onDestroy();
    }

    //新刷新方法
    @Override
    protected void onResume() {
        super.onResume();
        initview();
    }
    /*    //刷新页面 废弃
    private void refresh(View view) {
        Intent add = new Intent(PeopleChatActivity.this, PeopleChatActivity.class);
        String id = peopleChat.getPeopleId() + "";
        Bundle bundle=new Bundle();
        bundle.putString("id",id);
        add.putExtras(bundle);
        startActivity(add,ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        finish();

    }*/
}
