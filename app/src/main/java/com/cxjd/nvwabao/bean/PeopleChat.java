package com.cxjd.nvwabao.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by 白 on 2018/3/20.
 *
 * 圈子的聊天列表
 */

public class PeopleChat extends DataSupport{

    private int id;
    private String name;        //名称
    private int imageId;        //个人图片
    private String chat;        //病情描述
    private String info;        //个人信息
    private int coldImage;      //病情图片

    public PeopleChat() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
