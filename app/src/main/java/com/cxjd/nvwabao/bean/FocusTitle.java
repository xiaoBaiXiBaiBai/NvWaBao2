package com.cxjd.nvwabao.bean;

/**
 * Created by abu on 2017/10/8.
 */

public class FocusTitle {
    public static final int TITLE_STATE_IS=1;
    public static final int TITLE_STATE_NO=0;
    public static final int TITLE_CHECKED=1;
    public static final int TITLE_NOCHECKED=0;
    private String titleName;
    private int titleState;
    private int title_check;

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getTitleState() {
        return titleState;
    }

    public void setTitleState(int titleTag) {
        this.titleState = titleTag;
    }

    public int getTitle_check() {
        return title_check;
    }

    public void setTitle_check(int title_check) {
        this.title_check = title_check;
    }

    public FocusTitle(String titleName, int titleState, int title_check) {
        this.titleName = titleName;
        this.titleState = titleState;
        this.title_check=title_check;

    }

    public FocusTitle() {
    }
}
