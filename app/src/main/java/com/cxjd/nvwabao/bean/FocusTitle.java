package com.cxjd.nvwabao.bean;

/**
 * Created by abu on 2017/10/8.
 */

public class FocusTitle {
    private String titleName;
    private String titleState;
    private int title_check;
    public static final int TITLE_ISCHECKED=1;
    public static final int TITLE_NOCHECKED=0;

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleState() {
        return titleState;
    }

    public void setTitleState(String titleTag) {
        this.titleState = titleTag;
    }

    public int getTitle_check() {
        return title_check;
    }

    public void setTitle_check(int title_check) {
        this.title_check = title_check;
    }

    public FocusTitle(String titleName, String titleState, int title_check) {
        this.titleName = titleName;
        this.titleState = titleState;
        this.title_check=title_check;

    }

    public FocusTitle() {
    }
}
