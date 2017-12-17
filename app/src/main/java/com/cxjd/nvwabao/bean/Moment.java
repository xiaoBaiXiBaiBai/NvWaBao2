package com.cxjd.nvwabao.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * 评论对象
 */
public class Moment {
    @SerializedName("id")
    private int momentId;
    @SerializedName("content")
    public String mContent;
    @SerializedName("create_time")
    private String create_time;
    @SerializedName("author")
    private User author;
    private int reply_obj_id;
    @SerializedName("comments")
    public List<Comment> mComment; // 评论列表
    private int father_comment_id;
    private String replyPerson;
    private int praise_num;
    private boolean is_user_praise;

    public boolean isIs_user_praise() {
        return is_user_praise;
    }

    public void setIs_user_praise(boolean is_user_praise) {
        this.is_user_praise = is_user_praise;
    }

    public int getPraise_num() {
        return praise_num;
    }

    public void setPraise_num(int praise_num) {
        this.praise_num = praise_num;
    }

    public int getMomentId() {
        return momentId;
    }

    public void setMomentId(int momentId) {
        this.momentId = momentId;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getReply_obj_id() {
        return reply_obj_id;
    }

    public void setReply_obj_id(int reply_obj_id) {
        this.reply_obj_id = reply_obj_id;
    }

    public List<Comment> getmComment() {
        return mComment;
    }

    public void setmComment(List<Comment> mComment) {
        this.mComment = mComment;
    }

    public int getFather_comment_id() {
        return father_comment_id;
    }

    public void setFather_comment_id(int father_comment_id) {
        this.father_comment_id = father_comment_id;
    }

    public String getReplyPerson() {
        return replyPerson;
    }

    public void setReplyPerson(String replyPerson) {
        this.replyPerson = replyPerson;
    }

    public Moment(String mContent, ArrayList<Comment> mComment) {
        this.mComment = mComment;
        this.mContent = mContent;
    }

    public Moment() {
    }
}
