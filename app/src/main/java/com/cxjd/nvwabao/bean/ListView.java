package com.cxjd.nvwabao.bean;

/**
 * Created by 李超 on 2017/12/1.
 */

/**
 *
 *  该类是左边列表选项的抽象类
 *
 */


public class ListView {

    //选项的名字
    private String name;

    //选项的图片,备用项
    //private int imageId;

    public ListView(String name) {
        this.name = name;
       // this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

}
