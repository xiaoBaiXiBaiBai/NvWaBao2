package com.cxjd.nvwabao.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by 白 on 2018/3/23.
 */

public class PeopleReturn extends DataSupport{
    private int returnId;           //回复者id
    private int peopleId;           //对应提问者id

    private String returnName;      //回复者名称
    private String returnChat;      //回复内容
    private int imageId;            //回复者头像

    public int getReturnId() {
        return returnId;
    }

    public void setReturnId(int returnId) {
        this.returnId = returnId;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    public String getReturnName() {
        return returnName;
    }

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    public String getReturnChat() {
        return returnChat;
    }

    public void setReturnChat(String returnChat) {
        this.returnChat = returnChat;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
