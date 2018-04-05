package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.CircleAdapter;
import com.cxjd.nvwabao.bean.CirPingLun;
import com.cxjd.nvwabao.bean.Circles;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 项目名： NvWaBao2
 * 包名：   com.cxjd.nvwabao.Activity
 * 文件名： CirclesMainPage
 * 创建者： LC
 * 创建时间： 2018/3/28 16:05
 * 描述：   圈子主页面
 */
public class CirclesMainPage extends AppCompatActivity implements AbsListView.OnScrollListener{

    //用户群体编号
    private int id;

    //标题
    TextView zhuYe;

    //圈子实例
    Circles circles;

    //圈子头像
    ImageView head;

    //圈子名称
    TextView  name;

    //今日新帖
    TextView new_Tie;

    //总人数
    TextView users;

    //总帖数
    TextView ties;

    //适配器
    CircleAdapter adapter;

    //用户评论集合
    private List<CirPingLun> listQuan = new ArrayList<>();
    //第一次刷新之后增加出来的部分
    private List<CirPingLun> listQuan01 = new ArrayList<>();
    //第二次刷新后增加出来的部分
    private List<CirPingLun> listQuan02 = new ArrayList<>();
    //第三次刷新后增加出来的部分
    private List<CirPingLun> listQuan03 = new ArrayList<>();
    //第四次刷新增加出来的部分
    private List<CirPingLun> listQuan04 = new ArrayList<>();

    //圈子主页全部评论
    private ListView listViewQuan;

    //评论底部刷新
    private View footerView;

    //刷新组件
    private SwipeRefreshLayout mySRL;

    //设置一个最大的数据条目,超过即不再加载
    private int MaxDateNum;

    //用来表示可显示的最后一条数据的索引
    private int lastVisibleIndex;

    //用来装评论数据的LinerLayout
    private LinearLayout ll_textView;
    //评论布局
    private View ll_pinglun;

    //handler
    private final Handler refreshHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 2:
                    listQuan01 = DataSupport.where("from = ?",circles.getTitle()).limit(5).offset(5).find(CirPingLun.class);
                    for (CirPingLun cpl: listQuan01 ){
                        listQuan.add(cpl);
                    }
                    //通知listView刷新数据
                    adapter.notifyDataSetChanged();

                    break;
                case 4:
                    listQuan02 = DataSupport.where("from = ?",circles.getTitle()).limit(5).offset(10).find(CirPingLun.class);
                    for (CirPingLun cpl: listQuan02){
                        listQuan.add(cpl);
                    }
                    //通知listView刷新数据
                    adapter.notifyDataSetChanged();
                    break;
                case 6:
                    listQuan03 = DataSupport.where("from = ?",circles.getTitle()).limit(5).offset(15).find(CirPingLun.class);
                    for (CirPingLun cpl: listQuan03){
                        listQuan.add(cpl);
                    }
                    //通知listView刷新数据
                    adapter.notifyDataSetChanged();
                    break;
                case 8:
                    listQuan04 = DataSupport.where("from = ?",circles.getTitle()).limit(5).offset(20).find(CirPingLun.class);
                    for (CirPingLun cpl: listQuan04){
                        listQuan.add(cpl);
                    }
                    //通知listView刷新数据
                    adapter.notifyDataSetChanged();
                    new LoadDataThread().start();
                    Toast.makeText(CirclesMainPage.this,"刷新太频繁啦，服务器忙不过来啦",Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }

        }
    };

    //计算加载次数
    int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circles_main_page);
        initView();
        initDate();
        initListView();
        initListView01();
        initListView02();
    }

    private void initListView02() {
        ListView listViewNew = findViewById(R.id.cir_new_list);
        final List<CirPingLun> newList = DataSupport.where("from = ?",circles.getTitle()).where("liuYanShu = 0").find(CirPingLun.class);


        CircleAdapter adapter02 = new CircleAdapter(this,R.layout.cir_circles_main_item,newList);
        listViewNew.setAdapter(adapter02);
        listViewNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                CirPingLun cirPingLun = newList.get(position);
                Intent intent = new Intent(CirclesMainPage.this,TieZiXiangQing.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("cirPingLun",cirPingLun);
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });
    }

    private void initListView01() {
        final List<CirPingLun> remenList = DataSupport.where("from = ?",circles.getTitle()).where("liuYanShu = 7").find(CirPingLun.class);
        CircleAdapter adapter01 = new CircleAdapter(this,R.layout.cir_circles_main_item,remenList);
        ListView listView = findViewById(R.id.cir_remen_list);
        listView.setAdapter(adapter01);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                CirPingLun cirPingLun = remenList.get(position);
                Intent intent = new Intent(CirclesMainPage.this,TieZiXiangQing.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("cirPingLun",cirPingLun);
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });
    }




    private void initDate() {
        String[] name = {"东风破","小南斯","史密斯","小敏","汝丽","啊喵","豆豆","詹姆斯","勒布朗","西瓜郎","韦德","沈飞","马湖",
                         "中国心","JR·史密斯","文馨","爱国","问天阁","阿斯各","嘎斯","格洛克","李刚","伽罗","更健康","鬼鬼"};

        String[] address = {"福建省泉州市","黑龙江省哈尔滨市","北京市","河南省周口市","江苏省苏州市","上海市","台湾省台北市",
                            "云南省大理市","广西省北海市","海南省海口市","四川省巴中市","新疆省乌鲁木齐","河北省邯郸市",
                            "河南省新乡市","河南省商丘市","重庆市","四川省成都市","辽宁省大连市","西藏省拉萨市","宁夏省银川市","内蒙古呼和浩特市","吉林省长春市",
                            "河北省石家庄市","山东省济南市","江苏省南京市"};

        String[] pinglun01 = {"请问有谁知道预约挂号的流程么？哪位医生帮忙下","请问有谁知道哪位大夫可以治疗脑干梗，在线等","肺科医院哪个医生看肺炎比较好，求推荐",
                              "看耳膜穿孔省里哪个医生好","经常胸闷，晚上睡不着觉，有什么治疗方法么？","脸上有痘痘，找了很多医生都不行，有谁推荐下么？",
                              "每天晚上头疼，去协和医院看过了，效果不好，有哪位名医可以治么？","晚上经常失眠，我应该怎么办","协和医院哪位医院治前列腺效果好",
                              "请问大姨妈来的时候痛经严重，痛得打滚，应该怎么办？有医生能解决下么","请问肚子胀，肠胃不好，经常便秘，有医生推荐么？",
                              "请问哪位医生可以治疗脑淤血","白癜风去哪家医院好些？","腰椎酸痛哪里看比较好啊？","牙龈包住了牙齿谁看的好啊？求推荐",
                              "请问哪位大夫可以治小儿麻痹的？","皮肤痘痘黑头多，想请教大家哪家医院哪个医生好，谢谢","皮肤痒好长一段时间，哪位朋友推荐一下医生",
                              "我鼻窦炎很痛苦，记忆力下降，有哪位医生可医治的求推荐","吃关节保健品，关节更疼了，求医生","哪位医生可以治理月经不调","肚子痛了一个月，求推荐医生",
                              "求推荐治疗鼻炎好的医生","肩膀疼痛难忍，求推荐医生，谢谢","求治理痛经，谢谢","哪位朋友推荐一位心理医生，谢谢"};

        String[] pinglun02 = {"我现在是做美容美体的，现在已经有一年多，左手手腕处有明显肿胀，而且还很疼，梳头，握拳明显僵，手腕微微发痛。想问下这是什么症状，已经有十天左右",
                              "用洗面奶洗完脸，应该先抹祛痘药还是先抹美白，还是先缩小毛孔的？还是先处理黑头？白芙泥有没有用？怎么美白？丰胸的东西该不该买？",
                              "我做的假体已经两年多，但效果不理想，还可以打玻尿酸吗？还有鼻子也短，能打玻尿酸改善吗？","丰胸美体怎么做效果好？","请问医生男女穴位都是一样的吗？",
                              "目前最好的缩阴产品有哪些","你好，我想隆胸，做玻尿酸注射的，请问要多少费用 谢谢医生","女朋友在爱爱时候阴道干涩没有水怎么解决",
                              "我特别喜欢打扮自己。家庭条件也好，经常去美容美体，同学们劝我年纪轻轻的做些这个不好，我总是不听最近想要去纹唇 ","最近喜欢上跟同事去美容院做面部护理，但是美容院推荐我做一个精油开背的疗程，请问美容院的开背有什么好处？ ",
                              "想问进行透明质酸注射美容效果好吗？","女人下面没水，为什么下面很干","一笑就有鱼尾纹怎么办","哺乳期怎么样呢，有人用过吗，效果好吗，用过的说说看，咋么样，剖腹产多少久能用？ ",
                              "我想知道脸上长老年斑怎么治，或者平时要怎么护理皮肤呢？","我的胸部从小发育就不好，一直小小的，到了现在也没长大多少，为此非常烦恼。经常有人叫我小馒头，飞机场之类的外号，听了真不是滋味。一直就想丰胸的，可是不懂吃哪些食物啊，身边的朋友也没有什么经验。 ",
                              "超声刀去皱怎么样，有效的去皱方法","希望医生建议一下用什么护肤品有效，泉诗曼是否可信","有祛雀斑成功的吗，怎样才能去除雀斑","一个月做一次电波拉皮可以吗？",
                              "去鱼尾纹的最有效方法，如何淡化鱼尾纹","玻尿酸选进口的还是国产的？","年龄大了慢慢的都开始有皱纹了，特别是脸上的鱼尾纹挺明显的 ",
                              "我想用最好最有效的方式祛除蝴蝶斑。希望你们可以给于我帮助 ","想用超声刀去皱纹又不知道想过怎么样？去除之后会反弹吗？"};

        String[] pinglun03 = {"有没有宝妈断奶一年没来例假的","子宫内膜增生不脱落经血怎么治疗","有没有得盆腔炎的，屁股两边盆骨位置酸痛怎么办","月经反反复复不干净什么原因",
                              "请问每个月来月经，第一天都会便秘，要怎么治疗","阴道炎老是反反复复，看不好，怎么办","子宫直肠腋窝积液该如何治疗",
                              "支原体阳性，还有毒菌，有什么药管用","阴道炎总是复发，看不好","乳腺增生结块大去咨询谁呀？","你好，我想请问一下，四岁的小孩来月经是怎么回事",
                              "上环后，月经一直拖尾，怎么办？","子宫腺肌症疼痛难忍，省中医院和省妇幼保健院看得不好，该怎么办","修复处女膜手术，有什么推荐的么","子宫肌瘤3年，怎么办",
                              "去武汉看妇科，哪家医院好些","乳头内陷，应该怎么办","怀孕两个月了，腰疼屁股疼，该怎么办","月经迟一个月没来怎么办","腹部天天疼痛难忍怎么办","非月经出血怎么办",
                              "同房后阴道口辣疼辣疼的，是什么原因？","来月经前几天胃疼，乳房胀痛怎么办","乳房硬块怎么办","产后30天，下体疼痛难忍怎么办"};

        String[] pinglun04 = {"怀孕32天，不想要这个宝宝，在孕妇检查说孕囊近右侧，有点大，不适合人流，请问药物流产需要清宫手术么？","习惯性流产，想保住这个宝宝，该怎么办","今天去做了一个B超说是先兆性流产，有人懂么",
                              "怀孕了胎停一次生化两次，该怎么办，求好心人帮忙","做爱前应该做哪些措施才能防止怀孕","清宫一个半月还没有月经！怎么会是，急死了，不知道怎么办",
                              "宫外孕，hcg从4800降到3200，只是不容易啊，持久战，怎么办","人流必须带身份证么？","在医院观察了四天，宫外孕，还没有结果，我该怎么办",
                              "宫外孕可以用试纸测出来么？","输卵管堵塞，还能怀上宝宝么","人流需要开证明么？两个月","请问人流一次多少钱","怀孕可以就坐么？",
                              "人流一天之后可不可以用黄苦洗液","丈夫不在身边照顾，孕妇可以碰凉水么？","感冒可不可以做人流手术","吃了避孕药为什么还是怀上了孩子",
                              "有没有人知道厦门哪里的医院好，我想人流","三年夫妻生活没有怀上宝宝，我该怎么办","用了避孕套还是怀孕了怎么办","打胎可以么","怎样堕胎对身体影响最小","怀孕期间不能吃什么食物","孕妇可以吃辣的么？"};

        String[] pinglun05 = {"我爸六十多岁，有高血压，昨天量了血压160低压100，这几天小腿肿胀会与高血压有关么？","我高血压150，低压110，请你有什么办法么？吃什么药好？",
                              "吃中药，可不可以吃胡萝卜","高血压，尿检出来蛋白质一个加，什么意思","25岁，高血压140多，头晕，晚上睡觉有时会胸口闷闷的，要紧不","血压药，两个专家一个让吃，一个不让",
                              "钾有点高该吃什么","高血脂应该怎么办","我有高血压请问该吃什么药，两年了","我特别瘦，怀疑自己有高血脂，该怎么办","高血脂，和有高血压真的不可以办理健康证吗",
                              "男30岁，有高血压，但是不太清楚是肾引起","我的高压180低压89怎么治疗","我头晕高血压高血压都是由啥引起的应该检查","近1个月才发现我的低压100高压120这",
                              "血压170/110，怎么治疗","请问医生，高血压症经过药的波依定","医生，我父亲的血压高的时候达到180","患高血压四年了，现在出现胸闷背心酸痛",
                              "最近两天量血压，血压计显示心率不齐","无症状，单纯载脂蛋白低，请问是什么原因？","高压128低压91，有没有办法快速降压","每天一片降压药现在血压低于正常该·如何办",
                              "我是高血压病人血压不太高我十年前有过脑血","我的高血压居高不下有什么好的治疗方法吗"};


        String[] pinglun06 = {"经常会觉得口渴，一天喝2L水","吃饭吃得多人目前很瘦，检查血糖12∶86","怀孕第一次做B超需要空腹吗","糖尿病吃降血糖药为什么吐",
                              "做无创dna需要空腹吗","我有隐藏性糖尿病，我爸爸和爷爷都有糖尿病","怀孕31周了检查血糖是5.58医生说太高","孕妇血糖高可以吃什么水果吗",
                              "我是糖尿病人，请问我可以山楂干泡水喝吗","我今年50岁。前段时间测空腹血糖为7","糖尿病人能吃低聚果糖的保健品吗","血糖值是7.0算是糖尿病严重吗",
                              "餐前7.8餐后19.5这是糖尿病吗","血糖6.8怎么样做才能降低到6","我的血糖在10以下每天吃一颗二甲霜瓜","男19岁血糖17现在在打门冬胰岛素效果不明显",
                              "你在网上开的治疗糖尿病的中药的剂量是多少","请问流健颗粒这种药，对治疗糖尿病有没有效","白参血糖高，比较容易上火的人可不可以吃呢",
                              "发病有三四个月了，这两天检测出来是糖尿病","我想咨询一下血糖4个加号严重么","糖化血红蛋白5.6，能确诊没有糖尿病吗？","糖尿病人可以可以吃杏仁吗",
                              "糖尿病可以吃面包吗？都可以吃什么不可以吃","我婆婆经常头晕，迷惑"};

        String[] pinglun07 = {"备孕期间注意事项！怎么提高怀孕几率的呢？","我这么久都没怀孕。而且月经这个月迟迟不来。而且检查到还没有怀孕","备孕半年还没有怀孕,怎么回事?",
                              "您好我一直在用康王洗头!但是最近想备孕!是否停止!要停止多久才可以怀孕呢?","五号来的月经,几号同房最容易怀孕?","备孕期间可以做CT吗?",
                              "我今年35岁,有过一个小孩,已经十岁了。现在已经有半年没有避孕了,夫妻生活正常,为什么还是不能怀孕呢?","没有任何不适,准备怀孕前应注意什么?孕前应做哪些检查?",
                              "在备孕,不知是否怀孕,上次来月经是11月27号。现在吃太极牌益母草会不会导致流产?","叶酸是要怀孕吃还是备孕的时候吃的呢?","医生你好,我们想要二胎两三年了一直没要上,想要知道该怎么办?",
                              "正在备孕阶段,但是还没有怀孕。假如在同一个月时间刚吃完一盒舒肝健胃丸之后发现自己怀孕了,以后会对宝宝有影响吗?","备孕期,如果怀孕了的话,可以趴着睡吗?有没有什么影响?",
                              "准备怀孕,去医院办健康证,可以拍X胸片吗?","医生您好,我和老公备孕一年了,还是没有怀孕,到底正常吗?","备孕或怀孕是否可以多吃一些坚果?",
                              "我月经上个月15号来,这几天总是困想睡觉,特别能吃,胸部起青筋明显,请问会是怀孕吗?","请问准备怀孕要吃蛋白粉吗?","结婚2年多了,婚后一直备孕,却不怀孕,这是为什么?备孕期间怎样容易受孕成功呢?",
                              "对备孕不太了解,怎么备孕的呢?一直想怀孕,采取什么措施?","怎么注意饮食调节身体?我都不知道怎么是备孕,指导一下啊!","备孕的时候该怎么丛比较好点的呢?",
                              "您好,我在备孕,优生优育,鱼油是什么时候开始吃?会有副作用吗?什么牌子的好,摄入量多少合适","做核磁共振检查对准备怀孕的人有什么危害,我准备怀孕,对以后宝宝有影响吗?我准备怀孕,对以后宝宝有影响吗?",
                              "月经正常,有点点痛经,平时就是白带异常,黄色,有异味,有轻度宫颈糜烂。很想要个孩子,请问医生怎样才能快速怀孕?"};

        String[] pinglun08 = {"我和我老公结婚以后,都有三年了,但是一直都没怀孕,不孕不育可以治疗吗?","我女朋友要求在婚前做个婚前检查,以来可以保障我们俩都是健康的,而来也可以为我们将来要孩子多好准备工作，婚检可以检查出不孕不育吗?",
                              "我今年都已经三十岁了,跟我老公结婚也有五六年了,之前是因为不想要孩子,现在年纪大了,想要孩子了,却总是怀不上,总是在家里想是不是患上了不孕",
                              "我和我老公的感情很好,就是结婚好几年没有孩子,我们也都没有避孕啊,我不敢让老公陪我去医院检查,我就怕我有不孕了,请问女性一般不育是什么问题?得了要怎么办",
                              "我以前得过盆腔炎,医生说这种炎症不是很好治疗,不过我后来确实治好了,但是我还是想查查不孕不育,不知道都要做哪些检查啊? ","我和老公谈了3年的恋爱,现在走进了婚姻的殿堂,非常幸福,但是我们一直有个困扰,就是这几天在一起我们没有避孕,但是我也没有怀孕,是什么原因造成我们不孕不育啊?",
                              "结婚一年多了,没采取避孕措施,没有怀孕的迹象,好想要个宝宝啊,想到医院检查一下。希望得到的帮助:不孕不育要检查哪些项目?"," 我刚刚结婚不到半年的,这期间一直在要小孩的,可是也没有怀孕了，结婚后同房多长时间不怀孕才属于是不孕不育呢?",
                              "多少年以上不避孕没怀孕才算不孕不育?","一般人工流产并发症较多,可以导致不孕症,也可导致慢性盆腔炎;月经异常;继发不孕;子宫内膜异位症。 查看更多关于 打胎过一次会导致不孕不育吗?",
                              "请问如何检查女性不孕不育?患者女28多年前有过人流经历... 健康咨询描述: 请问如何检查女性不孕不育?","我今年35岁了,结婚已经10年,一直都没有怀上小孩,有人说这个可以用中药进行调理,请问不孕不育可以用中药调理好吗?",
                              "我结婚3年了,一直没有孩子,医生说我是胖的原因,也许她就是没有看明白我的病,我听有人说21步排查法,我也想去看看,不孕不育21步排查法,是什么?",
                              "怎么样才是不孕不育呢?","我从二十岁就开始和我的老公同居了,但是我们一直没有采取避孕措施也没有吃药怎么就是没有生育呢,我看起来是比较健康的,怎么会导致不孕不育呢?",
                              "手机辐射会造成不孕不育吗？","因为忙于事业,我和老婆都是三十多岁了,才准备要孩子的,可是现在又是二年过去了,老婆一直没有怀上,也不知道是不是我们的身体有问题了,不孕不育可以自测吗",
                              "请问女性不孕不育检查什么时候去检查合适?","我结婚2年了,一直没有生小孩,得了不孕不育哦,烦死了,老公很生气呢,经常给我脸色看啊!我都委屈死了,去哪能看好这个病呢?",
                              "结婚2年,不孕不育要不要做宫腹腔镜手术?","都已经结婚2年了,为什么还是不孕啊?这该怎么办呢?","不孕不育的症状都有哪些的呢?","得了不孕不育应该注意什么？",
                              "我都结婚两年了，一直也没怀孕，家里人着急了，催着我去医院检查，我感觉自己没有毛病，但是人们做在背后指指点点的。我想咨询一下不孕不育症在线专家，不育不孕的原因有哪些呢？想得到怎样的帮助：导致不孕不育症的原因有哪些呢？",
                              "发生不孕不育女性要检查哪些项目呢？"};

        String[] pinglun09 = {"中医养生有什么说法,有推荐的书吗?","有大半年了，睡眠质量一直不太好，主要表现为入睡困难，容易惊醒。最近一个星期好像更加严重了，浑身燥热，想贴个冰凉的东西冰一冰。翻来覆水，难以入睡",
                              "我想问一下，网上中医养生调理，治疗男性病的中医，有可信度吗","中医养生馆在什么地方?有给指点下 的吗? 曾经的治疗:御药行中医养生馆在什么地方?有给指点下 的吗?",
                              "按照中医养生理论,春天的合理作息应该是怎样的?能否详细一说,谢谢啦?","中医养生有哪些，具体一些要注意什么","最近上班都骑着摩托车，由于春天的原因把脸上的皮肤都吹的黄黄的，还很干，长了很多的皱纹、在眼角上还长了星星点点的小斑点，怎么样才能要我把皮肤变好？",
                              "我想知道一些美容一些方面的知识，可以充实一下子自己，在就是什么方法能把我的脸能变好点？","一直在寻找治月子病的老中医万分感谢",
                              "请问一下中医上面的腠理是什么意思？今天看了一本医学书。上面有一个腠理这个词，还请老中医帮助了","现在的中医都没用吗?我也不算大病就是治不",
                              "季节性过敏性鼻炎怎么办？","养生精片可以长期服用吗？会不会对它产生依赖性？","我去中医院看过,医生说是荨麻疹,瘾疹病,开了中药和西药,西药维c钙胶囊.地氯雷他定片.花蛇解痒胶囊,没吃之前痒得晚上睡不好,吃了之后晚上好多了,可是症状还是没变,身上时不时起红块,真难受,怎么才能好 ",
                              "中医中的“排毒养生”到底是什么含义？","补肾，壮阳，求中医中药泡茶养生配方上","现在的中医望闻问切准吗?  怎么我看了几个老中医病都没好呢!不算重病!只是病复杂点!",
                              "鸡内金对脾虚有无帮助？","耳朵上部分碰有点疼？是什么原因呢？","中医说的痹症是怎么得的","中国最好的治肿瘤的中医是谁？不要官方认可的那种，而是要真正历害的 ",
                              "请问中医动态治疗法是什么？","如果得了股藓怎么才能根治？中医又是怎么用","湿气问题喝茯苓薏仁粉好吗","中医说的\"相火\"是指什么? "};

        String[] pinglun10 = {"肩周炎是怎样产生的？前两年的得了一次，后来好了，不知道什么原因又严重了，右臂只能勉强抬到水平，就很疼痛，了解一下病因","肩周炎是什么原因引起的？",
                              "肩周炎好了以后还会再复发吗？左肩四年前肩周炎疼了三年才好，肘部疼一年多，今年腕部肿痛半年多，近几天肩膀又有些疼。",
                              "我左肩及肘关节疼痛,不能抬高和甩后。医生鉴定是肩周炎。 曾经的治疗:一个多月还未好 想得到帮助:吃什么药?贴和搽什么药膏?",
                              "五十肩和肩周炎的区别有哪些？","肩周炎能治愈吗，哪种治疗方法好，周期多长","肩周炎会影响乳房吗","肩周炎严重会有什么后果？",
                              "我看肩周炎治疗的方法那么多，什么比较有效？","肩周炎都好长时间了。肩周炎治疗费用是多少？","患上了肩周炎，可能是受风受寒导致。右肩抬到一定高度就会啪啪啪响！疼痛难忍！怎么治疗，才25岁。",
                              "我妈50岁了，有肩周炎，没有治疗过，在家偶尔服用消炎药。肩周炎疼痛吃什么药缓解","得了肩周炎，颈椎病需要补钙吗？得了肩周炎，颈椎病需要补钙吗？",
                              "最近一直右肩、背酸痛，我想检查一下，看是不是肩周炎，请问挂什么科？","肩周炎目前最佳治疗方法","早上起来时候尤为严重，晚上都睡不好觉，怎么办？怎么治疗？",
                              "TDP烤灯可以治疗肩周炎等病吗？","劳累引起了肩周炎，我想知道该怎么治疗比较好啊？治疗肩周炎好的医院是哪几家","我患了肩周炎，每天疼得难受，去医院看过，吃药治疗没效果。",
                              "肩周炎会自己好吗？要多久？","肩周炎打封闭针用的是什么药物？是不是要打到关节腔中？","中医院治疗肩周炎怎么样？","对于肩周炎有什么好办法治疗？？",
                              "肩周炎怎么回事？怎么治疗才行？","如何治疗肩周炎，有哪些注意事项？"};

        String[] pinglun11 = {"男人长期没有性生活会有什么不好影响 ？会不会诱发男科病什么的？","男人的性病有哪几种？性病的症状前兆是什么？","最近阴茎不勃起，勃起不硬，两分钟就射精，射完精睾丸酸疼，有事睾丸也会有些不是，请问这是怎么回事？",
                              "包皮和龟头粘连了，只能漏出半个龟头了，怎么办呢","阴茎勃起后不一直刺激就容易疲软！是什么症状？需要吃什么药？吃多久？",
                              "怎么确定自己得了什么男性疾病","最近一月手淫过度，阴囊感觉潮湿，龟头瘙痒，有异味。晨起无力，腰酸背痛。请问是什么情况？",
                              "如何预防男性疾病？","大约有一周了小便疼痛但是今天发现有白色分泌物龟头红肿请问是什么病因","请问，我有尿道感染吃过头孢克肟分散片和左氧氟沙星片，对精子有影响没有？我媳妇明天排卵期可以同房吗？",
                              "你好，请问精子的量减少了是怎么回事啊？该怎么办才能使精子数量越来越多？","前出现红点,但是没有感觉,增多了一点,我不知道这是不是病 请问这是病吗 请问可以用红霉素眼药膏擦吗? ",
                              "平时的应酬比较多，这段时间喝了很多的酒，感觉尿频、尿急，我还以为是喝太多酒引起的，听说我这种情况可能是生殖器系统急性，心里面十分的担心，想了解一下男性生殖器系统疾病.",
                              "21岁，男，感觉最近一段时间下边有点疼痛，感觉总是尿不干净，今天又出现黄色的，和脓似的，请问怎么回事？","我的包皮处靠里面的一侧经常发痒 旁边还一团有白点 不知是怎么回事",
                              "手淫几年，造成男性疾病能治疗吗？能的话怎么治疗，多长时间能好","男朋友最近，总感觉尿不尽，是不是有前列腺炎啊，希望给个专家，解说解说，谢谢",
                              "房事时间短，阴茎短小，还有包茎，急急急啊","今天射了精在厕所留着可是好像一直没有液化，液化了就像水一样消失的了嘛？","射精感觉无力，时间短，有手淫的习惯，最近一个月感觉，那方面不行了，以前还行，包皮有点长 ",
                              "我手淫的强忍没有射出来，然后我睾丸有点不舒服，有种挤压睾丸的那种感觉，怎么办啊？","昨天一个年轻的同事得了心梗，虽然没有要命，不过也挺吓人的，才三十出头就得这个病让我们很害怕了，想问一下现在的男性最容易得的病是什么病呢？",
                              "第一，我包皮过长，48岁还有没有必要做手术。   第二，由于特殊原因现在感觉生殖器变小了，怎么改善，谢谢","我老公最近一段时间总是说他阴茎很红，而且肿，我们就一直没有性生活，我也不明白他是得了什么病，叫他去医院检查，他也不去，他说不好意思",
                              "男朋友最近身体不太舒服，我这个星期请了假想陪他去医院检查一下身体。由于对男科疾病知识的匮乏，我们不太了解如果去了应该看哪个科。想问问男科都包括哪些疾病。"};


//        //删除数据库
//        DataSupport.deleteAll(CirPingLun.class);

        //创建数据库
        Connector.getDatabase();

        if(DataSupport.where("from = ?",circles.getTitle()).find(CirPingLun.class).size() < 1){
            List list = Arrays.asList(name);
            Collections.shuffle(list);
            List addressList = Arrays.asList(address);
            Collections.shuffle(addressList);
            for(int i=0; i<name.length; i++){
                //打乱name的顺序
                CirPingLun cirPingLun = new CirPingLun();
                cirPingLun.setName((String)list.get(i));
                cirPingLun.setAddress((String)addressList.get(i));
                cirPingLun.setFrom(circles.getTitle());
                if(i<3){
                    cirPingLun.setLiuYanShu("0");
                    cirPingLun.setZans("0");
                } else if(i < 7){
                    cirPingLun.setLiuYanShu("1");
                    cirPingLun.setZans("1");
                } else if (i < 18){
                    cirPingLun.setLiuYanShu("4");
                    cirPingLun.setZans("2");
                } else if(i < 25){
                    cirPingLun.setLiuYanShu("7");
                    cirPingLun.setZans("5");
                }
                switch (circles.getId()){
                    case 0 :
                        cirPingLun.setPinglun(pinglun01[i]);
                        break;
                    case 1 :
                        cirPingLun.setPinglun(pinglun02[i]);
                        break;
                    case 2 :
                        cirPingLun.setPinglun(pinglun03[i]);
                        break;
                    case 3 :
                        cirPingLun.setPinglun(pinglun04[i]);
                        break;
                    case 4 :
                        cirPingLun.setPinglun(pinglun05[i]);
                        break;
                    case 5 :
                        cirPingLun.setPinglun(pinglun06[i]);
                        break;
                    case 6 :
                        cirPingLun.setPinglun(pinglun07[i]);
                        break;
                    case 7 :
                        cirPingLun.setPinglun(pinglun08[i]);
                        break;
                    case 8 :
                        cirPingLun.setPinglun(pinglun09[i]);
                        break;
                    case 9 :
                        cirPingLun.setPinglun(pinglun10[i]);
                        break;
                    case 10 :
                        cirPingLun.setPinglun(pinglun11[i]);
                        break;
                    default:
                        break;
                }
                cirPingLun.save();
            }
        }
        listQuan = DataSupport.where("from = ?",circles.getTitle()).limit(5).offset(0).find(CirPingLun.class);
    }

    private void initListView() {
        adapter = new CircleAdapter(this,R.layout.cir_circles_main_item,listQuan);
        listViewQuan = findViewById(R.id.cir_main_list);
        //listView底部刷新布局
        footerView = getLayoutInflater().inflate(R.layout.loading_layout,null);
        //向listView中加入底部布局
        listViewQuan.addFooterView(footerView);
        listViewQuan.setAdapter(adapter);
        //绑定监听器
        listViewQuan.setOnScrollListener(this);
        //listView的点击事件
        listViewQuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                CirPingLun cirPingLun = listQuan.get(position);
                Intent intent = new Intent(CirclesMainPage.this,TieZiXiangQing.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("cirPingLun",cirPingLun);
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        //初始化TabHost
        final TabHost tabHost = findViewById(R.id.cir_main_tabhost);
        //初始化TabHost容器
        tabHost.setup();

        //创建第一个Tab页面
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1").setIndicator("全部").setContent(R.id.cir_main_tab01);
        //添加第一个标签页
        tabHost.addTab(tab1);
        //创建第二个Tab页面
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2").setIndicator("热门").setContent(R.id.cir_main_tab02);
        //添加第二个Tab页面
        tabHost.addTab(tab2);
        //创建第三个Tab页面
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3").setIndicator("最新").setContent(R.id.cir_main_tab03);
        tabHost.addTab(tab3);

        //拿出布局里的众多控件
        zhuYe = findViewById(R.id.fragment_title);
        head = findViewById(R.id.iv_cr_main_head);
        name = findViewById(R.id.cr_main_tv_title);
        new_Tie = findViewById(R.id.cr_new_tie);
        users = findViewById(R.id.cr_chengyuan);
        ties = findViewById(R.id.cr_ties);
        //取出intent传递过来的对象
        Intent intent = getIntent();
        circles = (Circles)intent.getSerializableExtra("circles");
        //初始化页面
        zhuYe.setText("圈子主页");
        head.setImageResource(circles.getHeadId());
        name.setText(circles.getTitle());
        Log.i("hihihihi",circles.getTitle());
        new_Tie.setText(circles.getGengXin());
        users.setText(circles.getChengYuan());
        ties.setText(circles.getTieZi());
        id = circles.getId();
    }


    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
         //只要滑动状态就会改变
         //滑到底部自动刷新
         if(i%2==0&&i<=8){
             new LoadDataThread().start();
         }
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
           //减去最后一个加载中那条
           lastVisibleIndex = firstVisibleItem + visibleItemCount -1;
    }

    /**
     * 模拟加载数据的线程
     */
    class LoadDataThread extends Thread {

        @Override
        public void run() {
            if(i!=8){
                i++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshHandler.sendEmptyMessage(i);
            }else{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }

}
