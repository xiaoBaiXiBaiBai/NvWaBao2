package com.cxjd.nvwabao.bean;

import java.io.Serializable;

/**
 * 项目名： NvWaBao2
 * 包名：   com.cxjd.nvwabao.bean
 * 文件名： Circles
 * 创建者： LC
 * 创建时间： 2018/3/26 14:10
 * 描述：   圈子的圈子实体类
 */
public class Circles implements Serializable{

    private int id;

    private int headId;

    private String title;

    private String gengXin;

    private String chengYuan;

    private String tieZi;

    public Circles(int headId,String title, String gengXin, String chengYuan, String tieZi,int id) {
        this.id = id;
        this.headId = headId;
        this.title = title;
        this.gengXin = gengXin;
        this.chengYuan = chengYuan;
        this.tieZi = tieZi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeadId() {
        return headId;
    }

    public void setHeadId(int headId) {
        this.headId = headId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGengXin() {
        return gengXin;
    }

    public void setGengXin(String gengXin) {
        this.gengXin = gengXin;
    }

    public String getChengYuan() {
        return chengYuan;
    }

    public void setChengYuan(String chengYuan) {
        this.chengYuan = chengYuan;
    }

    public String getTieZi() {
        return tieZi;
    }

    public void setTieZi(String tieZi) {
        this.tieZi = tieZi;
    }

}
