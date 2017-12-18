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
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.DF;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Fat;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.MineralSubstance;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.MineralSubstance_I;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.MineralSubstance_ca;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.MineralSubstance_co;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.MineralSubstance_cu;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.MineralSubstance_f;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.MineralSubstance_fe;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.MineralSubstance_geAndNi;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.MineralSubstance_mg;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.MineralSubstance_p;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.MineralSubstance_znAndMn;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Protein;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Sugar;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Vitamin;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Vitamin_A;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Vitamin_B1;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Vitamin_B12;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Vitamin_B2;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Vitamin_B6;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Vitamin_C;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Vitamin_D;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Vitamin_E;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Vitamin_K;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Vitamin_fansuan;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Vitamin_yesuan;
import com.cxjd.nvwabao.fragment.findFunctions.sevenNutriens.Water;

/**
 * Created by 李超 on 2017/12/14.
 */

public class SevenNutriens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_seven_nutriens);

        replaceFragment(new Protein());

        //创建一个BaseExpandableListAdapter
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {

            //五大分类
            private String[] armTypes = new String[]{"蛋白质", "脂肪", "糖类", "水", "矿物质", "膳食纤维","维生素"};
            //各个项的子项
            private String[][] arms = new String[][]{
                    {},
                    {},
                    {},
                    {},
                    {"钙", "铁", "磷", "碘","铜", "镁", "氟","铝","锌与锰","铬与镍"},
                    {},
                    {"维生素A", "维生素B1", "维生素B2", "维生素B6", "维生素B12","维生素C", "维生素D", "维生素E", "维生素K", "叶酸","泛酸"}
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
                LinearLayout l1 = new LinearLayout(SevenNutriens.this);
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
                TextView textView = new TextView(SevenNutriens.this);
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
                        replaceFragment(new Protein());
                        break;
                    case 1:
                        replaceFragment(new Fat());
                        break;
                    case 2:
                        replaceFragment(new Sugar());
                        break;
                    case 3 :
                        replaceFragment(new Water());
                        break;
                    case 4 :
                        replaceFragment(new MineralSubstance());
                        break;
                    case 5 :
                        replaceFragment(new DF());
                        break;
                    case 6 :
                        replaceFragment(new Vitamin());
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
                if(groupPosition == 4){
                    switch (childPosition){
                        case 0 :
                            replaceFragment(new MineralSubstance_ca());
                            break;
                        case 1 :
                            replaceFragment(new MineralSubstance_fe());
                            break;
                        case 2 :
                            replaceFragment(new MineralSubstance_p());
                            break;
                        case 3 :
                            replaceFragment(new MineralSubstance_I());
                            break;
                        case 4 :
                            replaceFragment(new MineralSubstance_cu());
                            break;
                        case 5 :
                            replaceFragment(new MineralSubstance_mg());
                            break;
                        case 6 :
                            replaceFragment(new MineralSubstance_f());
                            break;
                        case 7 :
                            replaceFragment(new MineralSubstance_co());
                            break;
                        case 8 :
                            replaceFragment(new MineralSubstance_znAndMn());
                            break;
                        case 9 :
                            replaceFragment(new MineralSubstance_geAndNi());
                            break;
                        default:
                            break;
                    }
                } else if(groupPosition == 6){
                    switch (childPosition){
                        case 0 :
                            replaceFragment(new Vitamin_A());
                            break;
                        case 1 :
                            replaceFragment(new Vitamin_B1());
                            break;
                        case 2 :
                            replaceFragment(new Vitamin_B2());
                            break;
                        case 3 :
                            replaceFragment(new Vitamin_B6());
                            break;
                        case 4 :
                            replaceFragment(new Vitamin_B12());
                            break;
                        case 5 :
                            replaceFragment(new Vitamin_C());
                            break;
                        case 6 :
                            replaceFragment(new Vitamin_D());
                            break;
                        case 7 :
                            replaceFragment(new Vitamin_E());
                            break;
                        case 8 :
                            replaceFragment(new Vitamin_K());
                            break;
                        case 9 :
                            replaceFragment(new Vitamin_yesuan());
                            break;
                        case 10 :
                            replaceFragment(new Vitamin_fansuan());
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
        fragmentTransaction.replace(R.id.right_sevenNutriens_fragment,fragment);
        fragmentTransaction.commit();
    }

}
