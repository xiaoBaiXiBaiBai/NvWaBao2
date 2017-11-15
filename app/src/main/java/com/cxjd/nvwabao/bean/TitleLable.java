package com.cxjd.nvwabao.bean;


import org.litepal.crud.DataSupport;

/**
 * Created by abu on 2017/11/15.
 */

public class TitleLable extends DataSupport {
    private String titleName;
    private String titleCategery;
    private int title_check;
    private String titleLable;

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleCategery() {
        return titleCategery;
    }

    public void setTitleCategery(String titleCategery) {
        this.titleCategery = titleCategery;
    }

    public int getTitle_check() {
        return title_check;
    }

    public void setTitle_check(int title_check) {
        this.title_check = title_check;
    }

    public String getTitleLable() {
        return titleLable;
    }

    public void setTitleLable(String titleLable) {
        this.titleLable = titleLable;
    }

    public TitleLable(String titleName, String titleCategery, int title_check, String titleLable) {
        this.titleName = titleName;
        this.titleCategery = titleCategery;
        this.title_check = title_check;
        this.titleLable = titleLable;
    }

    public TitleLable() {
    }
}
