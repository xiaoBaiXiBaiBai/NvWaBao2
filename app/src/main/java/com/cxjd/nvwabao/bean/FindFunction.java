package com.cxjd.nvwabao.bean;

/**
 * Created by 李超 on 2017/11/6.
 *
 * 发现页面中功能的抽象
 *
 */

public class FindFunction {
    //功能图片id
    private int imageId;

    public FindFunction( int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

}
