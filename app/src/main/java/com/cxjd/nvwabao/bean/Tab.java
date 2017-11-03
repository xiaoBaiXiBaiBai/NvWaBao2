package com.cxjd.nvwabao.bean;

/**
 * Created by 李超 on 2017/10/29.
 *
 * TabSpec的封装类，每一个底部菜单块都是一个TabSpec
 *
 */

public class Tab {
    //每个菜单块的描述
    private int titile;
    //菜单块儿的图片
    private int icon;
    //每个菜单块对应的碎片
    private Class fragment;

    public int getTitile() {
        return titile;
    }

    public void setTitile(int titile) {
        this.titile = titile;
    }

    public Tab(int titile, int icon, Class fragment) {
        this.titile = titile;
        this.icon = icon;
        this.fragment = fragment;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
