package com.cxjd.nvwabao.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by 白 on 2018/3/20.
 *
 * 圈子的聊天列表
 */

public class PeopleChat extends DataSupport{

    private int peopleId;       //实际作为 帖子主键  并非用户主键
    private String name;        //名称
    private int imageId;        //个人图片
    private String chat;        //病情描述
    private String info;        //个人信息
    private int coldImage;      //病情图片
    private int zan;            //点赞数量
    private String address;     //地址
    private Boolean zanAble;    //是否可以点赞

    private String from;        //来自哪个圈子


    public PeopleChat() {

    }

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    public PeopleChat(int imageId, String chat) {
        super();
        this.imageId = imageId;
        this.chat = chat;
    }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getColdImage() {
        return coldImage;
    }

    public void setColdImage(int coldImage) {
        this.coldImage = coldImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getZanAble() {
        return zanAble;
    }

    public void setZanAble(Boolean zanAble) {
        this.zanAble = zanAble;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
