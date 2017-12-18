package com.cxjd.nvwabao.mainActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.bean.Tab;
import com.cxjd.nvwabao.fragment.CircleFragment;
import com.cxjd.nvwabao.fragment.FindFragment;
import com.cxjd.nvwabao.fragment.HomeFragment;
import com.cxjd.nvwabao.fragment.InformationFragment;
import com.cxjd.nvwabao.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private long exitTime = 0;
    //读取布局layout文件
    private LayoutInflater mInflater;
    //底部导航栏
    private FragmentTabHost mTabhost;
    //把底部导航栏中的菜单块存放在集合中
    private List<Tab> mTabs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化底部导航栏
        initTab();
    }





    private void initTab() {
        Tab tab_home = new Tab(R.string.home, R.drawable.selector_icon_home, HomeFragment.class);
        Tab tab_information = new Tab(R.string.information, R.drawable.selector_icon_information, InformationFragment.class);
        Tab tab_find = new Tab(R.string.find, R.drawable.selector_icon_find, FindFragment.class);
        Tab tab_circle = new Tab(R.string.circle, R.drawable.selector_icon_circle, CircleFragment.class);
        Tab tab_mine = new Tab(R.string.mine, R.drawable.selector_icon_mine, MineFragment.class);

        //将实例化好的Tab添加到集合中
        mTabs.add(tab_home);
        mTabs.add(tab_information);
        mTabs.add(tab_find);
        mTabs.add(tab_circle);
        mTabs.add(tab_mine);

        //准备LayoutInflater
        mInflater = LayoutInflater.from(this);
        //找到FragmentTabHost
        mTabhost = (FragmentTabHost) this.findViewById(R.id.tabhost);
        //装载Fragment
        mTabhost.setup(this,getSupportFragmentManager(), R.id.realtabcontent);

        for(Tab tab : mTabs){
            //增加TabSpec，newTabSpec中的String参数是用来区分Tab的
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitile()));

            //增加指示器indicator,内部参数是我们准备好的View
            tabSpec.setIndicator(buildIndicator(tab));

            //最后一步，将配置好的TabSpec放入底部导航栏
            mTabhost.addTab(tabSpec,tab.getFragment(),null);
        }

        //去掉导航栏中的分割线
        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        //默认选中的第一个是首页
        mTabhost.setCurrentTab(0);

    }

    /**
     * 把导航栏中的TabSpec一个一个完善，属性都加上
     * @param tab  --  菜单块的实例
     * @return 返回，菜单块视图
     */
    private View buildIndicator(Tab tab) {
        //准备好底部导航栏中的图片布局
        //用Inflater找到布局文件
        View view = mInflater.inflate(R.layout.tab_indicator,null);
        //找到布局文件中的具体组件，图片组件
        ImageView img = view.findViewById(R.id.icon_tab);
        //向图片组件中添加图片
        img.setImageResource(tab.getIcon());
        return view;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis() - exitTime) > 2000){
                Toast.makeText(this, "再按一次退出应用程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }else{
                finish();
                System.exit(0);
            }
            return true;
        }
        return true;
    }
}
