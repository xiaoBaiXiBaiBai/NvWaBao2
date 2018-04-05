package com.cxjd.nvwabao.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * 项目名： NvWaBao2
 * 包名：   com.cxjd.nvwabao.bean
 * 文件名： PingLunPeople
 * 创建者： LC
 * 创建时间： 2018/4/1 21:11
 * 描述：   TODO
 */
public class PingLunPeople extends DataSupport implements Serializable {

    private String name;

    private String data;

    private String pingLun;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPingLun() {
        return pingLun;
    }

    public void setPingLun(String pingLun) {
        this.pingLun = pingLun;
    }

}
