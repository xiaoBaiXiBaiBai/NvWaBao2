package com.cxjd.nvwabao.bean;

/**
 * Created by abu on 2017/11/24.
 */

public class TitleContentBean {
    private int id;
    private String imageAddress;
    private String tittle;
    private String content;
    private String url;

    public TitleContentBean(int id, String imageAddress, String tittle, String content, String url) {
        this.id = id;
        this.imageAddress = imageAddress;
        this.tittle = tittle;
        this.content = content;
        this.url = url;
    }

    public TitleContentBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
