package com.cxjd.nvwabao.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.fragment.DragGridLayout;

import java.util.ArrayList;
import java.util.List;

public class ChannelActivity extends AppCompatActivity {


    private DragGridLayout showGridLayout;
    private DragGridLayout hideGridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        initCustom();
    }

    private void initCustom() {
        showGridLayout = (DragGridLayout) findViewById(R.id.dgl_main_show);
        showGridLayout.setResource(R.drawable.selector_textbg, 5, 5);
        showGridLayout.setEnableDrag(false);
        List<String> items = new ArrayList<>();
        items.add("安眠");
        items.add("安神");
        items.add("安胎");
        items.add("保护肝脏");
        items.add("保护神经");
        items.add("保护视力");
        items.add("保护胃粘膜");
        items.add("保护心脑血管");
        items.add("保护心血管");
        items.add("保护血管");
        items.add("保护眼睛");
        items.add("保胎");
        items.add("补充营养");
        items.add("补碘");
        items.add("补钙");
        items.add("补精");
        items.add("补脑");
        items.add("补脾益肾");
        items.add("补肾");
        items.add("补虚");
        items.add("补血");
        items.add("促进生长发育");
        items.add("促进生育功能");
        items.add("促进食欲");
        items.add("促进消化");
        items.add("促进血液循环");
        items.add("促进胰岛素分泌");
        items.add("促进婴幼儿大脑发育");
        items.add("促睡眠");
        items.add("促消化");
        items.add("催乳");
        items.add("调节免疫功能 ");
        items.add("调节免疫功能 ");
        items.add("调节肾脏功能 ");
        items.add("调理月经 ");
        items.add("防癌");
        items.add("防便秘");
        items.add("防感冒");
        items.add("防感染");
        items.add("防脱发");
        items.add("防晕车");
        items.add("防治肝炎");
        items.add("防治高血压");
        items.add("防治高血脂");
        items.add("防治骨质疏松");
        items.add("防治冠心病");
        items.add("防治坏血病");
        items.add("防治甲状腺肿");
        items.add("防治口腔溃疡");
        items.add("防治老年痴呆");
        items.add("防治贫血症");
        items.add("防治肾结石");
        items.add("防治糖尿病");
        items.add("治心肌梗死");
        items.add("防治心血管疾病");
        items.add("防治心脏病");
        items.add("防治血管僵化");
        items.add("防治夜盲症");
        items.add("防中风");
        items.add("丰胸");
        items.add("妇幼保健");
        items.add("改善肺功能");
        items.add("护肤");
        items.add("护肝");
        items.add("护心");
        items.add("护眼");
        items.add("缓解尿频");
        items.add("缓解疲劳");
        items.add("活血");
        items.add("活血化痰");
        items.add("甲状腺");
        items.add("减肥");
        items.add("健骨");
        items.add("健脾");
        items.add("健体");
        items.add("健胃");
        items.add("键脾胃");
        items.add("降三高");
        items.add("降血糖");
        items.add("降血压");
        items.add("降血脂");
        items.add("解毒");
        items.add("解酒");
        items.add("解渴");
        items.add("解暑");
        items.add("抗癌");
        items.add("抗病菌");
        items.add("抗辐射");
        items.add("抗感染");
        items.add("抗过敏");
        items.add("抗寒");
        items.add("抗菌");
        items.add("抗凝血");
        items.add("抗衰老");
        items.add("抗抑郁");
        items.add("抗肿瘤");
        items.add("扩张血管");
        items.add("利尿");
        items.add("美容");
        items.add("美胸");
        items.add("美颜");
        items.add("免疫力");
        items.add("明目");
        items.add("排毒");
        items.add("排结石");
        items.add("排石");
        items.add("强筋通络");
        items.add("强身健体");
        items.add("强腰");
        items.add("强壮骨骼");
        items.add("清肝利水");
        items.add("清热");
        items.add("驱虫");
        items.add("祛斑");
        items.add("祛痰");
        items.add("润肠");
        items.add("润肺");
        items.add("生发");
        items.add("瘦身");
        items.add("缩尿止带");
        items.add("提高免疫力");
        items.add("提神");
        items.add("通便");
        items.add("通经活络");
        items.add("通乳");
        items.add("痛经");
        items.add("维护骨骼健康");
        items.add("乌发");
        items.add("消化");
        items.add("消口臭");
        items.add("消水肿");
        items.add("消炎");
        items.add("消肿");
        items.add("延年益寿");
        items.add("益肾");
        items.add("益智");
        items.add("有益肾脏");
        items.add("有益心血管健康");
        items.add("预防动脉硬化");
        items.add("月经");
        items.add("增进食欲");
        items.add("增强记忆");
        items.add("增强免疫力");
        items.add("增强人体免疫力");
        items.add("镇静");
        items.add("止带");
        items.add("止咳");
        items.add("止渴");
        items.add("止呕");
        items.add("止痛");
        items.add("止泻");
        items.add("止遗补精");
        items.add("助消化");
        items.add("壮阳");
        items.add("滋阴");









        showGridLayout.setItems(items);
       /* hideGridLayout = (DragGridLayout) findViewById(R.id.dgl_main_bottom);
        hideGridLayout.setEnableDrag(false);
        hideGridLayout.setResource(R.drawable.selector_textbg, 5, 5);
        List<String> items1 = new ArrayList<>();
        items1.add("家居");
        items1.add("奇石");
        items1.add("螺蛳粉");
        items1.add("情感");
        items1.add("文化");
        items1.add("体育");
        items1.add("汽车");
        items1.add("本地号");
        items1.add("爆料");
        items1.add("时政");
        items1.add("美女");
        items1.add("公益");
        items1.add("公民榜样");
        items1.add("亲子");
        items1.add("社会");
        items1.add("舌尖柳州");
        items1.add("开心一刻");
        items1.add("居柳州");
        hideGridLayout.setItems(items1);*/

        //设置点击事件
        showGridLayout.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                //当点击时，将返回的TextView从showGridLayout容器中删除，在添加到hideGridLayout中
                /*showGridLayout.removeView(tv);
                hideGridLayout.addItem(tv.getText().toString());*/
                Log.e("TextView",tv.getText().toString());
                Intent intent = new Intent(ChannelActivity.this,FoodListActivity.class);
                intent.putExtra("listName",tv.getText().toString());
                startActivity(intent);
            }
        });

      /*  hideGridLayout.setOnItemClickListener(new DragGridLayout.OnItemClickListener() {
            @Override
            public void onItemClick(TextView tv) {
                hideGridLayout.removeView(tv);
                showGridLayout.addItem(tv.getText().toString());
            }
        });*/


    }
}
