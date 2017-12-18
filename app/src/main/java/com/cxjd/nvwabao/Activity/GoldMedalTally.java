package com.cxjd.nvwabao.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.CaFragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.FeFragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.FolicAcidFragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.KaFragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.MineralSubstace;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.PiFragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.ProteinFragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.SugarFragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.Vitamin;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.VitaminAFragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.VitaminB;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.VitaminB12Fragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.VitaminB1Fragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.VitaminB2Fragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.VitaminB6Fragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.VitaminC;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.VitaminD;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.VitaminE;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.VitaminHFragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.VitaminK;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.VitaminP;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.XiFragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.ZhiFangFragment;
import com.cxjd.nvwabao.fragment.findFunctions.goldMedalTally.ZnFragment;

public class GoldMedalTally extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold_medal_tally);

        replaceFragment(new ProteinFragment());

        //创建一个BaseExpandableListAdapter
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {

            //五大分类
            private String[] armTypes = new String[]{"蛋白质", "脂肪", "碳水\n化合物", "矿物质", "维生素\n(无B)", "B族\n维生素"};
            //各个项的子项
            private String[][] arms = new String[][]{
                    {},
                    {},
                    {},
                    {"钙", "铁", "磷", "锌", "硒", "钾"},
                    {"维生素A", "维生素C", "维生素D", "维生素E", "维生素K", "维生素P"},
                    {"维生素B1", "维生素B2", "维生素B6", "维生素B12", "维生素H", "叶酸"}
            };

            /**
             * 返回包含的组列表项的数量
             *
             * @return
             */
            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            /**
             * 返回特定组所包含的子列表项的数量
             *
             * @param i
             * @return
             */
            @Override
            public int getChildrenCount(int i) {
                return arms[i].length;
            }


            /**
             * 获取指定组位置处的组数据
             *
             * @param i
             * @return
             */
            @Override
            public Object getGroup(int i) {
                return armTypes[i];
            }

            /**
             * 获取指定位置、指定子列表项处的子列表项数据
             *
             * @param i
             * @param i1
             * @return
             */
            @Override
            public Object getChild(int i, int i1) {
                return arms[i][i1];
            }

            //获得指定组位置
            @Override
            public long getGroupId(int i) {
                return i;
            }

            /**
             * 获得组位置处的子项位置
             *
             * @param i
             * @param i1
             * @return
             */
            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }

            /**
             * ??????????????????
             *
             * @return
             */
            @Override
            public boolean hasStableIds() {
                return true;
            }

            /**
             * 该方法决定每个组选项的外观
             *
             * @param groupPosition
             * @param isExpanded
             * @param view
             * @param viewGroup
             * @return
             */
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
                LinearLayout l1 = new LinearLayout(GoldMedalTally.this);
                l1.setOrientation(LinearLayout.VERTICAL);
                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());;
                //设置字体为粗体
                TextPaint tp = textView.getPaint();
                tp.setFakeBoldText(true);
                l1.addView(textView);
                return l1;
            }

            /**
             * 该方法决定每个子选项的外观
             *
             * @param groupPosition
             * @param childPosition
             * @param isLastChild
             * @param view
             * @param viewGroup
             * @return
             */
            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition).toString());
                textView.setTextSize(15);
                return textView;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }

            private TextView getTextView(){
                AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200);
                TextView textView = new TextView(GoldMedalTally.this);
                textView.setLayoutParams(layoutParams);
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(20);
                return textView;
            }

        };

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.list);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long id) {
                    switch (groupPosition) {
                        case 0:
                            replaceFragment(new ProteinFragment());
                            break;
                        case 1:
                            replaceFragment(new ZhiFangFragment());
                            break;
                        case 2:
                            replaceFragment(new SugarFragment());
                            break;
                        case 3 :
                            replaceFragment(new MineralSubstace());
                            break;
                        case 4 :
                            replaceFragment(new Vitamin());
                            break;
                        case 5 :
                            replaceFragment(new VitaminB());
                            break;
                        default:
                            break;
                    }
                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                if(groupPosition == 3){
                    switch (childPosition){
                        case 0 :
                            replaceFragment(new CaFragment());
                            break;
                        case 1 :
                            replaceFragment(new FeFragment());
                            break;
                        case 2 :
                            replaceFragment(new PiFragment());
                            break;
                        case 3 :
                            replaceFragment(new ZnFragment());
                            break;
                        case 4 :
                            replaceFragment(new XiFragment());
                            break;
                        case 5 :
                            replaceFragment(new KaFragment());
                            break;
                        default:
                            break;
                    }
                } else if(groupPosition == 4){
                    switch (childPosition){
                        case 0 :
                            replaceFragment(new VitaminAFragment());
                            break;
                        case 1 :
                            replaceFragment(new VitaminC());
                            break;
                        case 2 :
                            replaceFragment(new VitaminD());
                            break;
                        case 3 :
                            replaceFragment(new VitaminE());
                            break;
                        case 4 :
                            replaceFragment(new VitaminK());
                            break;
                        case 5 :
                            replaceFragment(new VitaminP());
                            break;
                        default:
                            break;
                    }
                } else if (groupPosition == 5) {
                    switch (childPosition){
                        case 0 :
                            replaceFragment(new VitaminB1Fragment());
                            break;
                        case 1 :
                            replaceFragment(new VitaminB2Fragment());
                            break;
                        case 2 :
                            replaceFragment(new VitaminB6Fragment());
                            break;
                        case 3 :
                            replaceFragment(new VitaminB12Fragment());
                            break;
                        case 4 :
                            replaceFragment(new VitaminHFragment());
                            break;
                        case 5 :
                            replaceFragment(new FolicAcidFragment());
                            break;
                        default:
                            break;
                    }
                }

                return false;

            }
        });

    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.right_goldMedalTally_fragment,fragment);
        fragmentTransaction.commit();
    }

}
