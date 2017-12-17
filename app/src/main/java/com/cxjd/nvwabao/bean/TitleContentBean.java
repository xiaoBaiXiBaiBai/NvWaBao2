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
    private int praise_num;
    private boolean is_user_praise;
    private int scan_num;

    public int getScan_num() {
        return scan_num;
    }

    public void setScan_num(int scan_num) {
        this.scan_num = scan_num;
    }

    public int getPraise_num() {
        return praise_num;
    }

    public void setPraise_num(int praise_num) {
        this.praise_num = praise_num;
    }

    public boolean isIs_user_praise() {
        return is_user_praise;
    }

    public void setIs_user_praise(boolean is_user_praise) {
        this.is_user_praise = is_user_praise;
    }

    public TitleContentBean(int id, String imageAddress, String tittle, String content, String url, int praise_num, boolean is_user_praise) {
        this.id = id;
        this.imageAddress = imageAddress;
        this.tittle = tittle;
        this.content = content;
        this.url = url;
        this.praise_num = praise_num;
        this.is_user_praise = is_user_praise;
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
