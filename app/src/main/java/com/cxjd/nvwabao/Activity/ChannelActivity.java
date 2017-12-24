package com.cxjd.nvwabao.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.fragment.DragGridLayout;

import java.util.ArrayList;
import java.util.List;

public class ChannelActivity extends AppCompatActivity {
    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3, view4, view5,view6,view7,view8,view9,view10,view11,view12,view13,view14,view15,view16,view17,view18,view19,view20,view21,view22,view23,view24,view25,view26;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TextView tx ;



    private DragGridLayout showGridLayoutA,showGridLayoutB,showGridLayoutC,showGridLayoutD,showGridLayoutE,showGridLayoutF,showGridLayoutG,showGridLayoutH,showGridLayoutI,showGridLayoutJ,showGridLayoutK,showGridLayoutL,showGridLayoutM,showGridLayoutN,showGridLayoutO,showGridLayoutP,showGridLayoutQ,showGridLayoutR,showGridLayoutS,showGridLayoutT,showGridLayoutU,showGridLayoutV,showGridLayoutW,showGridLayoutX,showGridLayoutY,showGridLayoutZ;
    private DragGridLayout hideGridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);



        mViewPager = (ViewPager) findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        mInflater = LayoutInflater.from(this);
        view1 = mInflater.inflate(R.layout.channel_a, null);
        view2 = mInflater.inflate(R.layout.channel_a, null);
        view3 = mInflater.inflate(R.layout.channel_a, null);
        view4= mInflater.inflate(R.layout.channel_a, null);
        view5 = mInflater.inflate(R.layout.channel_a, null);
        view6 = mInflater.inflate(R.layout.channel_a, null);
        view7 = mInflater.inflate(R.layout.channel_a, null);
        view8 = mInflater.inflate(R.layout.channel_a, null);
        view9 = mInflater.inflate(R.layout.channel_a, null);
        view10 = mInflater.inflate(R.layout.channel_a, null);
        view11 = mInflater.inflate(R.layout.channel_a, null);
        view12 = mInflater.inflate(R.layout.channel_a, null);
        view13 = mInflater.inflate(R.layout.channel_a, null);
        view14 = mInflater.inflate(R.layout.channel_a, null);
        view15 = mInflater.inflate(R.layout.channel_a, null);
        view16 = mInflater.inflate(R.layout.channel_a, null);
        view17 = mInflater.inflate(R.layout.channel_a, null);
        view18 = mInflater.inflate(R.layout.channel_a, null);
        view19 = mInflater.inflate(R.layout.channel_a, null);
        view20 = mInflater.inflate(R.layout.channel_a, null);
        view21 = mInflater.inflate(R.layout.channel_a, null);
        view22 = mInflater.inflate(R.layout.channel_a, null);
        view23 = mInflater.inflate(R.layout.channel_a, null);
        view24 = mInflater.inflate(R.layout.channel_a, null);
        view25 = mInflater.inflate(R.layout.channel_a, null);
        view26 = mInflater.inflate(R.layout.channel_a, null);
        initCustom();

        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);
        mViewList.add(view5);
        mViewList.add(view6);
        mViewList.add(view7);
        mViewList.add(view8);
        mViewList.add(view9);
        mViewList.add(view10);
        mViewList.add(view11);
        mViewList.add(view12);
        mViewList.add(view13);
        mViewList.add(view14);
        mViewList.add(view15);
        mViewList.add(view16);
        mViewList.add(view17);
        mViewList.add(view18);
        mViewList.add(view19);
        mViewList.add(view20);
        mViewList.add(view21);
        mViewList.add(view22);
        mViewList.add(view23);
        mViewList.add(view24);
        mViewList.add(view25);
        mViewList.add(view26);




        //添加页卡标题
        mTitleList.add("A");
        mTitleList.add("B");
        mTitleList.add("C");
        mTitleList.add("D");
        mTitleList.add("E");
        mTitleList.add("F");
        mTitleList.add("G");
        mTitleList.add("H");
        mTitleList.add("I");
        mTitleList.add("J");
        mTitleList.add("K");
        mTitleList.add("L");
        mTitleList.add("M");
        mTitleList.add("N");
        mTitleList.add("O");
        mTitleList.add("P");
        mTitleList.add("Q");
        mTitleList.add("R");
        mTitleList.add("S");
        mTitleList.add("T");
        mTitleList.add("U");
        mTitleList.add("V");
        mTitleList.add("W");
        mTitleList.add("X");
        mTitleList.add("Y");
        mTitleList.add("Z");






        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(3)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(4)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(5)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(6)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(7)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(8)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(9)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(10)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(11)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(12)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(13)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(14)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(15)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(16)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(17)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(18)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(19)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(20)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(21)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(22)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(23)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(24)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(25)));




        ChannelActivity.MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置可以滑动
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器


    }

    private void initCustom() {
        showGridLayoutA = (DragGridLayout)view1. findViewById(R.id.dgl_main_show);
        showGridLayoutA.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutA.setEnableDrag(false);
        List<String> items = new ArrayList<>();
        items.add("安眠");
        items.add("安神");
        items.add("安胎");


        showGridLayoutA.setItems(items);

        //设置点击事件
        showGridLayoutA.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }

        });

        showGridLayoutB = (DragGridLayout)view2. findViewById(R.id.dgl_main_show);
        showGridLayoutB.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutB.setEnableDrag(false);
        List<String> itemsB = new ArrayList<>();

        itemsB.add("保护肝脏");
        itemsB.add("保护神经");
        itemsB.add("保护视力");
        itemsB.add("保护胃粘膜");
        itemsB.add("保护心脑血管");
        itemsB.add("保护心血管");
        itemsB.add("保护血管");
        itemsB.add("保护眼睛");
        itemsB.add("保胎");
        itemsB.add("补充营养");
        itemsB.add("补碘");
        itemsB.add("补钙");
        itemsB.add("补精");
        itemsB.add("补脑");
        itemsB.add("补脾益肾");
        itemsB.add("补肾");
        itemsB.add("补虚");
        itemsB.add("补血");

        showGridLayoutB.setItems(itemsB);

        //设置点击事件
        showGridLayoutB.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });

        showGridLayoutC = (DragGridLayout)view3. findViewById(R.id.dgl_main_show);
        showGridLayoutC.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutC.setEnableDrag(false);
        List<String> itemsC = new ArrayList<>();


        itemsC.add("促进生长发育");
        itemsC.add("促进生育功能");
        itemsC.add("促进食欲");
        itemsC.add("促进消化");
        itemsC.add("促进血液循环");
        itemsC.add("促进胰岛素分泌");
        itemsC.add("促进婴幼儿大脑发育");
        itemsC.add("促睡眠");
        itemsC.add("促消化");
        itemsC.add("催乳");

        showGridLayoutC.setItems(itemsC);

        //设置点击事件
        showGridLayoutC.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutD = (DragGridLayout)view4. findViewById(R.id.dgl_main_show);
        showGridLayoutD.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutD.setEnableDrag(false);
        List<String> itemsD = new ArrayList<>();


        showGridLayoutD.setItems(itemsD);

        //设置点击事件
        showGridLayoutD.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });

        showGridLayoutE = (DragGridLayout)view5. findViewById(R.id.dgl_main_show);
        showGridLayoutE.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutE.setEnableDrag(false);
        List<String> itemsE = new ArrayList<>();

        showGridLayoutE.setItems(itemsE);

        //设置点击事件
        showGridLayoutE.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });

        showGridLayoutF = (DragGridLayout)view6. findViewById(R.id.dgl_main_show);
        showGridLayoutF.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutF.setEnableDrag(false);
        List<String> itemsF = new ArrayList<>();
        itemsF.add("防癌");
        itemsF.add("防便秘");
        itemsF.add("防感冒");
        itemsF.add("防感染");
        itemsF.add("防脱发");
        itemsF.add("防晕车");
        itemsF.add("防治肝炎");
        itemsF.add("防治高血压");
        itemsF.add("防治高血脂");
        itemsF.add("防治骨质疏松");
        itemsF.add("防治冠心病");
        itemsF.add("防治坏血病");
        itemsF.add("防治甲状腺肿");
        itemsF.add("防治口腔溃疡");
        itemsF.add("防治老年痴呆");
        itemsF.add("防治贫血症");
        itemsF.add("防治肾结石");
        itemsF.add("防治糖尿病");
        itemsF.add("防治心肌梗死");
        itemsF.add("防治心血管疾病");
        itemsF.add("防治心脏病");
        itemsF.add("防治血管僵化");
        itemsF.add("防治夜盲症");
        itemsF.add("防中风");
        itemsF.add("丰胸");
        itemsF.add("妇幼保健");
        showGridLayoutF.setItems(itemsF);

        //设置点击事件
        showGridLayoutF.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });

        showGridLayoutG = (DragGridLayout)view7. findViewById(R.id.dgl_main_show);
        showGridLayoutG.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutG.setEnableDrag(false);
        List<String> itemsG = new ArrayList<>();
        itemsG.add("改善肺功能");
        showGridLayoutG.setItems(itemsG);

        //设置点击事件
        showGridLayoutG.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutH = (DragGridLayout)view8. findViewById(R.id.dgl_main_show);
        showGridLayoutH.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutH.setEnableDrag(false);
        List<String> itemsH = new ArrayList<>();
        itemsH.add("护肤");
        itemsH.add("护肝");
        itemsH.add("护心");
        itemsH.add("护眼");
        itemsH.add("缓解尿频");
        itemsH.add("缓解疲劳");
        itemsH.add("活血");
        itemsH.add("活血化瘀");
        showGridLayoutH.setItems(itemsH);

        //设置点击事件
        showGridLayoutH.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });

        showGridLayoutI = (DragGridLayout)view9. findViewById(R.id.dgl_main_show);
        showGridLayoutI.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutI.setEnableDrag(false);
        List<String> itemsI = new ArrayList<>();

        showGridLayoutI.setItems(itemsI);

        //设置点击事件
        showGridLayoutI.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutJ = (DragGridLayout)view10. findViewById(R.id.dgl_main_show);
        showGridLayoutJ.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutJ.setEnableDrag(false);
        List<String> itemsJ = new ArrayList<>();
        itemsJ.add("甲状腺");
        itemsJ.add("减肥");
        itemsJ.add("健骨");
        itemsJ.add("健脾");
        itemsJ.add("健体");
        itemsJ.add("健胃");
        itemsJ.add("键脾胃");
        itemsJ.add("降三高");
        itemsJ.add("降血糖");
        itemsJ.add("降血压");
        itemsJ.add("降血脂");
        itemsJ.add("解毒");
        itemsJ.add("解酒");
        itemsJ.add("解渴");
        itemsJ.add("解暑");
        showGridLayoutJ.setItems(itemsJ);

        //设置点击事件
        showGridLayoutJ.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutK = (DragGridLayout)view11. findViewById(R.id.dgl_main_show);
        showGridLayoutK.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutK.setEnableDrag(false);
        List<String> itemsK = new ArrayList<>();
        itemsK.add("抗癌");
        itemsK.add("抗病毒");
        itemsK.add("抗辐射");
        itemsK.add("抗感染");
        itemsK.add("抗过敏");
        itemsK.add("抗寒");
        itemsK.add("抗菌");
        itemsK.add("抗凝血");
        itemsK.add("抗衰老");
        itemsK.add("抗抑郁");
        itemsK.add("抗肿瘤");
        itemsK.add("扩张血管");
        showGridLayoutK.setItems(itemsK);

        //设置点击事件
        showGridLayoutK.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutL = (DragGridLayout)view12. findViewById(R.id.dgl_main_show);
        showGridLayoutL.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutL.setEnableDrag(false);
        List<String> itemsL = new ArrayList<>();
        itemsL.add("利尿");
        showGridLayoutL.setItems(itemsL);

        //设置点击事件
        showGridLayoutL.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutM = (DragGridLayout)view13. findViewById(R.id.dgl_main_show);
        showGridLayoutM.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutM.setEnableDrag(false);
        List<String> itemsM = new ArrayList<>();
        itemsM.add("美容");
        itemsM.add("美胸");
        itemsM.add("美颜");
        itemsM.add("免疫力");
        itemsM.add("明目");
        showGridLayoutM.setItems(itemsM);

        //设置点击事件
        showGridLayoutM.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutN = (DragGridLayout)view14. findViewById(R.id.dgl_main_show);
        showGridLayoutN.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutN.setEnableDrag(false);
        List<String> itemsN = new ArrayList<>();

        showGridLayoutN.setItems(itemsN);

        //设置点击事件
        showGridLayoutN.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutO = (DragGridLayout)view15. findViewById(R.id.dgl_main_show);
        showGridLayoutO.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutO.setEnableDrag(false);
        List<String> itemsO = new ArrayList<>();

        showGridLayoutO.setItems(itemsO);

        //设置点击事件
        showGridLayoutO.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutP = (DragGridLayout)view16. findViewById(R.id.dgl_main_show);
        showGridLayoutP.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutP.setEnableDrag(false);
        List<String> itemsP = new ArrayList<>();
        itemsP.add("排毒");
        itemsP.add("排结石");
        itemsP.add("排石");
        showGridLayoutP.setItems(itemsP);

        //设置点击事件
        showGridLayoutP.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutQ = (DragGridLayout)view17. findViewById(R.id.dgl_main_show);
        showGridLayoutQ.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutQ.setEnableDrag(false);
        List<String> itemsQ = new ArrayList<>();
        itemsQ.add("强筋通络");
        itemsQ.add("强身健体");
        itemsQ.add("强腰");
        itemsQ.add("强壮骨骼");
        itemsQ.add("清肝利水");
        itemsQ.add("清热");
        itemsQ.add("驱虫");
        itemsQ.add("祛斑");
        itemsQ.add("祛痰");
        showGridLayoutQ.setItems(itemsQ);

        //设置点击事件
        showGridLayoutQ.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutR = (DragGridLayout)view18. findViewById(R.id.dgl_main_show);
        showGridLayoutR.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutR.setEnableDrag(false);
        List<String> itemsR = new ArrayList<>();
        itemsR.add("润肠");
        itemsR.add("润肺");
        showGridLayoutR.setItems(itemsR);

        //设置点击事件
        showGridLayoutR.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutS = (DragGridLayout)view19. findViewById(R.id.dgl_main_show);
        showGridLayoutS.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutS.setEnableDrag(false);
        List<String> itemsS = new ArrayList<>();
        itemsS.add("生发");
        itemsS.add("瘦身");
        itemsS.add("缩尿止带");
        showGridLayoutS.setItems(itemsS);

        //设置点击事件
        showGridLayoutS.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutT = (DragGridLayout)view20. findViewById(R.id.dgl_main_show);
        showGridLayoutT.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutT.setEnableDrag(false);
        List<String> itemsT = new ArrayList<>();
        itemsT.add("提高免疫力");
        itemsT.add("调节免疫功能 ");
        itemsT.add("调节免疫功能 ");
        itemsT.add("调节肾脏功能 ");
        itemsT.add("调理月经 ");
        itemsT.add("提神");
        itemsT.add("通便");
        itemsT.add("通经活络");
        itemsT.add("通乳");
        itemsT.add("痛经");
        showGridLayoutT.setItems(itemsT);

        //设置点击事件
        showGridLayoutT.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutU = (DragGridLayout)view21. findViewById(R.id.dgl_main_show);
        showGridLayoutU.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutU.setEnableDrag(false);
        List<String> itemsU = new ArrayList<>();

        showGridLayoutU.setItems(itemsU);

        //设置点击事件
        showGridLayoutU.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutV = (DragGridLayout)view22. findViewById(R.id.dgl_main_show);
        showGridLayoutV.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutV.setEnableDrag(false);
        List<String> itemsV = new ArrayList<>();

        showGridLayoutV.setItems(itemsV);

        //设置点击事件
        showGridLayoutV.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutW = (DragGridLayout)view23. findViewById(R.id.dgl_main_show);
        showGridLayoutW.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutW.setEnableDrag(false);
        List<String> itemsW = new ArrayList<>();
        itemsW.add("维护骨骼健康");
        itemsW.add("乌发");
        showGridLayoutW.setItems(itemsW);

        //设置点击事件
        showGridLayoutW.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutX = (DragGridLayout)view24. findViewById(R.id.dgl_main_show);
        showGridLayoutX.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutX.setEnableDrag(false);
        List<String> itemsX = new ArrayList<>();
        itemsX.add("消化");
        itemsX.add("消口臭");
        itemsX.add("消水肿");
        itemsX.add("消炎");
        itemsX.add("消肿");
        showGridLayoutX.setItems(itemsX);

        //设置点击事件
        showGridLayoutX.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutY = (DragGridLayout)view25. findViewById(R.id.dgl_main_show);
        showGridLayoutY.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutY.setEnableDrag(false);
        List<String> itemsY = new ArrayList<>();
        itemsY.add("延年益寿");
        itemsY.add("益肾");
        itemsY.add("益智");
        //items.add("有益肾脏");
        itemsY.add("有益心血管健康");
        itemsY.add("预防动脉硬化");
        itemsY.add("月经");
        showGridLayoutY.setItems(itemsY);

        //设置点击事件
        showGridLayoutY.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });
        showGridLayoutZ = (DragGridLayout)view26. findViewById(R.id.dgl_main_show);
        showGridLayoutZ.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayoutZ.setEnableDrag(false);
        List<String> itemsZ = new ArrayList<>();
        itemsZ.add("增进食欲");
        itemsZ.add("增强记忆");
        itemsZ.add("增强免疫力");
        itemsZ.add("增强人体免疫力");
        itemsZ.add("镇静");
        //  items.add("止带");
        itemsZ.add("止咳");
        itemsZ.add("止渴");
        itemsZ.add("止呕");
        itemsZ.add("止痛");
        itemsZ.add("止泻");
        itemsZ.add("止遗补精");
        itemsZ.add("助消化");
        itemsZ.add("壮阳");
        itemsZ.add("滋阴");
        showGridLayoutZ.setItems(itemsZ);

        //设置点击事件
        showGridLayoutZ.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                //tv.setTextColor(Color.parseColor("#00bfff"));
                tx = tv;
                tx.setTextColor(Color.parseColor("#00bfff"));
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodList3Activity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);

            }
        });
    }

    //ViewPager适配器
    class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));//添加页卡
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);//页卡标题
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (tx!=null){
            tx.setTextColor(Color.parseColor("#808080"));
        }

    }
}
