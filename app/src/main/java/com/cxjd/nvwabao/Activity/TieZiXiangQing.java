package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.CircleAdapter;
import com.cxjd.nvwabao.bean.CirPingLun;
import com.cxjd.nvwabao.bean.PingLunPeople;
import com.cxjd.nvwabao.bean.User;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 项目名： NvWaBao2
 * 包名：   com.cxjd.nvwabao.Activity
 * 文件名： TieZiXiangQing
 * 创建者： LC
 * 创建时间： 2018/3/30 20:39
 * 描述：   TODO
 */
public class TieZiXiangQing extends AppCompatActivity {


    //圈子评论对象
    private CirPingLun cirPingLun;

    //帖子详情中的评论列表
    private ListView pingLunListView;
    //评论列表中的回复列表
    private ListView huiFuListView;

    //帖子详情下的评论
    private List<PingLunPeople> listPingLun = new ArrayList<PingLunPeople>();

    private String[][] huifu = {{"可以找一下北京协和医院赵春刚医生", "这种问题需要谨慎，推荐哈尔滨第四附属医院李镇江医生", "北京地坛医院刘鹏医生",
            "极力推荐河北胜利医院王太利院长","求医这种问题，还是先百度一下吧", "建议你不要网上找，登门拜访比较靠谱", "李医生，18845143397", "我也有相同的问题同求",
            "找到了告诉我一下哈", "您可以到医院问一下，毕竟本地的方便", "河南同仁堂马海峰医生", "山西人民医院董建刚医生相当负责"},

            {"美貌是一生的财富，建议咨询专业医师", "我也遇到了相关的问题", "解决了么？求分享啊", "可以试一下\"太太安\"", "我老婆也有这些问题，咋办",
                    "推荐每天吃一些西红柿，对你有帮助", "女娲宝可以搜啊，试试看啊", "女娲宝可以的，我用过效果很明显", "一定多休息，少熬夜", "一般是因为调理周期紊乱，建议饮食要规律"},

            {"女人对自己好一些，做一下全面检查", "做一下身体检查吧", "让你老公多买点好吃的", "身体不适从月经上最能体会到，建议多吃些补血的视频",
                    "推荐女娲宝的养生模块", "这种问题比较敏感，建议找医生询问", "我也遇到了相关的问题，可以一起探讨啊", "北京协和医院可以的", "女性疾病找北京协和医院啊", "您的问题比较严重，建议直接去医院看一下"},

            {"哎，出来混早晚是要还的，对自己好点", "我建议你们夫妻俩都去检查一下", "女人的身体比较敏感，需要好好调养", "北京协和医院妇产科可以一试", "我也遇到相关的问题",
                    "还不想要孩子，可是怀孕了，好烦人", "有人知道怎么怀双胞胎么", "你的情况比较严重啊", "不要着急，去医院咨询一下吧", "好烦，好烦。女人好苦"},

            {"少吃盐,WHO建议每人每日食盐量不超过6g", "可以做做足疗", "多吃含钙和钾较多的蔬菜，比如菠菜", "可以多做一些头部按摩",
                    "可以在女娲宝里搜索一下", "建议找相关医师咨询", "茶疗法,可以适当喝茶", "要多吃水果和蔬菜", "建议补充优质蛋白，不要吃猪肉",
                    "不要喝酒，喝酒最容易升血压"},

            {"含糖的尽量不吃", "水果就不要想了", "甜品碰就是死啊，呜呜呜", "建议多吃五谷杂粮", "多吃豆制品", "南瓜很好的，吃着甜，其实降血糖",
                    "千万不要熬夜，多休息", "建议找一个医师咨询一下", "化整为零，少吃多餐", "吃干不吃稀"},

            {"好想做妈妈啊", "要早睡早起，提高身体状况", "天呐，闭经之后就是加速衰老，我该怎么办啊", "神养：心情愉快，性格开朗", "动养：要经常参加体育锻炼",
                    "注意保持良好的心理状态", "多晒太阳", "记得规划有孩子之后的蓝图哈", "做好准备哈，加油", "停用避孕药哈，不要用，伤身体"},

            {"不孕的原因很多，建议去医院检查一下", "大部分是输卵管堵塞了", "可以选择体外受精", "试管婴儿啊？还可以做双胞胎呢", "考虑一下药物治疗吧",
                    "有可能是另一位的问题", "做一个系统性的检查吧", "找一个专业的医师咨询一下吧", "我也遇到过这样的问题", "苦恼啊，哎,都离婚了"},

            {"坚持锻炼，早睡早起", "养生我还是信任中医", "是药三分毒，建议合理饮食，多做运动", "如果条件允许的话，买一台跑步机吧",
                    "中医养生贵在养德，这是健康和长寿的最重要条件", "有规律的运动", "保持精神、情感、以及心理上的健康", "人要健康长寿，清志调畅是一个重要条件",
                    "养生求静，使身心处于万虑皆息独存一念的境地", "可以定期做一下拔罐或者刮痧"},

            {"建议做一个X线检查", "对肩关节做一个MRI检查吧", "建议自我按摩", "老毛病了，都十多年了", "多做运动，建议少吃药", "针灸！！",
                    "建议约一个医师好好聊一下", "不是什么大毛病，坚持锻炼。可以的", "不要放弃啊，我也是，坚持会好的", "祝你好运"},

            {"男性疾病近期比较多", "洁身自号啊", "讲究卫生，勤换洗", "我老公也有这些问题", "北京现代男科", "做一些相关的锻炼，爱护鸡鸡",
                    "药物治疗的话，建议多吃一些鞭", "减少手淫", "找个女朋友吧", "建议去医院咨询一下"}
    };

    private String[] names = {"林冲", "小白", "赵敏", "无悔", "芝芝", "笑笑", "小胖", "小哥哥", "凉风", "菲儿", "江哥", "仁奎", "东哥"};

    private String[] datas = {"一小时前", "三小时前", "五小时前", "五小时前", "八小时前", "1天前", "2天前"};

    //评论名字
    private TextView pName;
    //评论时间
    private String time;
    //评论内容
    private String pingLun;
    //回复人姓名
    private String huiFuName;
    //回复人评论内容
    private String huiFuText;

    //评论按钮
    private ImageView imageViewPingLun;
    //点赞按钮
    private ImageView imageViewZans;
    //评论数字
    private TextView pingLunCount;
    //点赞数字
    private TextView zanCount;
    //是否点击评论
    private boolean isClickPingLun = false;
    //是否点击点赞
    private boolean isClickZan = false;
    //是否已经点过赞
    private boolean isClickZanEd = false;

    //返回评论内容
    private String returnText;
    //是否评论完毕
    private boolean isNewPingLun = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cir_main_tiezixiangqing);
        initView();
        initDate();
        initListView();
    }

    private void initView() {
        //设置标题
        TextView text = findViewById(R.id.fragment_title);
        text.setText("帖子详情");

        //获得布局控件
        TextView name = findViewById(R.id.cr_xiangqing_pinglun_name);
        TextView address = findViewById(R.id.cr_xiangqing_pinglun_address);
        TextView textView = findViewById(R.id.cir_tv_xiangqing_pinglun);
        TextView from = findViewById(R.id.cir_main_xiangqing_from);
        TextView pingLunShu = findViewById(R.id.cir_main_tiezi_pinglun);
        TextView zans = findViewById(R.id.cir_main_tiezi_dianzan);
        //评论按钮
        imageViewPingLun = findViewById(R.id.cir_xiangqing_pinglun);
        //点赞按钮
        imageViewZans = findViewById(R.id.cir_xiangqing_zans);
        //评论数量
        pingLunCount = findViewById(R.id.cir_main_tiezi_pinglun);
        //点赞数量
        zanCount = findViewById(R.id.cir_main_tiezi_dianzan);

        imageViewPingLun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClickPingLun = true;
                onResume();
            }
        });
        imageViewZans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClickZan = true;
                onResume();
            }
        });


        //获得Intent传递过来的圈子评论用户对象
        Intent intent = getIntent();
        cirPingLun = (CirPingLun) intent.getSerializableExtra("cirPingLun");

        name.setText(cirPingLun.getName());
        address.setText(cirPingLun.getAddress());
        textView.setText(cirPingLun.getPinglun());
        from.setText(cirPingLun.getFrom());
        pingLunShu.setText(cirPingLun.getLiuYanShu());
        zans.setText(cirPingLun.getZans());
    }

    private void initDate() {
        //创建数据库
        Connector.getDatabase();

        //当前评论者来自的圈子
        String from = cirPingLun.getFrom();

        if (DataSupport.where("name = ?", cirPingLun.getName()).find(PingLunPeople.class).size() < 1) {
            //留言数
            int q = Integer.parseInt(cirPingLun.getLiuYanShu());

            //数组转变为集合
            String[] str;
            if (from.equals("就医帮帮团")) {
                str = huifu[0];
            } else if (from.equals("美容美体")) {
                str = huifu[1];
            } else if (from.equals("妇科疾病")) {
                str = huifu[2];
            } else if (from.equals("避孕流产")) {
                str = huifu[3];
            } else if (from.equals("高血压")) {
                str = huifu[4];
            } else if (from.equals("糖尿病")) {
                str = huifu[5];
            } else if (from.equals("备孕怀孕")) {
                str = huifu[6];
            } else if (from.equals("不孕不育")) {
                str = huifu[7];
            } else if (from.equals("中医养生")) {
                str = huifu[8];
            } else if (from.equals("肩周炎")) {
                str = huifu[9];
            } else {
                str = huifu[10];
            }

            List pingjiaList = Arrays.asList(str);
            List nameList = Arrays.asList(names);
            //打乱集合顺序
            Collections.shuffle(pingjiaList);
            Collections.shuffle(nameList);

            for (int i = 0; i < q; i++) {
                //打乱name的顺序
                PingLunPeople pingLunPeople = new PingLunPeople();
                pingLunPeople.setName((String) nameList.get(i));
                pingLunPeople.setData(datas[i]);
                pingLunPeople.setPingLun((String) pingjiaList.get(i));
                listPingLun.add(pingLunPeople);
                pingLunPeople.save();
            }
        }
    }

    private void initListView() {
        //帖子详情评论ListView
        pingLunListView = findViewById(R.id.cir_main_lv_pinglun_huifu);
        //评论适配器
        CircleAdapter adapterPing = new CircleAdapter(this, R.layout.cir_main_huifu_item, listPingLun,2);
        //绑定适配器
        pingLunListView.setAdapter(adapterPing);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!zanCount.getText().toString().isEmpty()){
            if (isClickPingLun) {
                isClickPingLun = false;
                isNewPingLun = true;
                Intent intent = new Intent(TieZiXiangQing.this, com.cxjd.nvwabao.Activity.CirPingLun.class);
                startActivity(intent);
            } else if (isClickZan == true && isClickZanEd == false) {
                //设置赞的数值加一
                int i = Integer.parseInt(zanCount.getText().toString()) + 1;
                zanCount.setText(i + "");
                cirPingLun.setZans(i+"");
                cirPingLun.save();
                isClickZanEd = true;
                isClickZan = false;
            } else if (isClickZanEd == true && isNewPingLun==false) {
                Toast.makeText(TieZiXiangQing.this, "每个人只能点一次赞哦", Toast.LENGTH_SHORT).show();
            } else if (isNewPingLun){
                isNewPingLun = false;
                PingLunPeople pingLunPeople = DataSupport.findLast(PingLunPeople.class);
                listPingLun.add(0, pingLunPeople);
                initListView();
            }

        }


    }

}
