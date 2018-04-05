package com.cxjd.nvwabao.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * 项目名： NvWaBao2
 * 包名：   com.cxjd.nvwabao.bean
 * 文件名： CirPingLun
 * 创建者： LC
 * 创建时间： 2018/3/28 21:51
 * 描述：   各个圈的评论用户类
 */
public class CirPingLun extends DataSupport implements Serializable {

    private String name;

    private String address;

    private String pinglun;

    private String from;

    private String liuYanShu;

    private String zans;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinglun() {
        return pinglun;
    }

    public void setPinglun(String pinglun) {
        this.pinglun = pinglun;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getLiuYanShu() {
        return liuYanShu;
    }

    public void setLiuYanShu(String liuYanShu) {
        this.liuYanShu = liuYanShu;
    }

    public String getZans() {
        return zans;
    }

    public void setZans(String zans) {
        this.zans = zans;
    }
}
