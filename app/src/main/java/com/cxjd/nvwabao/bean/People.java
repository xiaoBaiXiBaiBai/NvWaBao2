package com.cxjd.nvwabao.bean;

/**
 * Created by Administrator on 2017/12/3.
 */

public class People {
    private  String name;
    private  int imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public People(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }
}
