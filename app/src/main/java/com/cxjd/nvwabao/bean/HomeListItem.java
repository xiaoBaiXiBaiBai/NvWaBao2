package com.cxjd.nvwabao.bean;

/**
 * Created by 李超 on 2017/11/3.
 *
 * 首页列表信息的抽象类
 *
 */

public class HomeListItem {
    private int home_list_imageId;
    private String content;
    private int count;
    private String title;

    public HomeListItem(int home_list_imageId, String content, int count, String title) {
        this.home_list_imageId = home_list_imageId;
        this.content = content;
        this.count = count;
        this.title = title;
    }

    public int getHome_list_imageId() {
        return home_list_imageId;
    }

    public void setHome_list_imageId(int home_list_imageId) {
        this.home_list_imageId = home_list_imageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
