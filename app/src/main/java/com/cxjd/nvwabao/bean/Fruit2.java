package com.cxjd.nvwabao.bean;

/**
 * Created by Administrator on 2017/12/3.
 */

public class Fruit2 {
    private  String name;
    private  String imageUrl;
    private String content_url;
    private String  kind;

    public String getIconUrl() {
        return content_url;
    }

    public void setIconUrl(String iconUrl) {
        this.content_url = iconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageId() {
        return imageUrl;
    }

    public void setImageId(String imageId) {
        this.imageUrl = imageId;
    }

    public Fruit2(String name, String imageId,String content_url,String  kind) {
        this.name = name;
        this.imageUrl = imageId;
        this.content_url = content_url;
        this.kind = kind;
    }
}
