package com.cxjd.nvwabao.bean;

import java.io.Serializable;

/**
 * Created by abu on 2017/10/17.
 */

public class NewsTitleBean implements Serializable {
     private String titleName;
     private int ImageId;
     private String datefrom;
     private String touchtime;

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(String datefrom) {
        this.datefrom = datefrom;
    }

    public String getTouchtime() {
        return touchtime;
    }

    public void setTouchtime(String touchtime) {
        this.touchtime = touchtime;
    }

    public NewsTitleBean(String titleName, int imageId, String datefrom, String touchtime) {
        this.titleName = titleName;
        ImageId = imageId;
        this.datefrom = datefrom;
        this.touchtime = touchtime;
    }

}
