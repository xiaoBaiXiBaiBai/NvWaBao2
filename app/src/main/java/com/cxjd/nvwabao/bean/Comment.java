package com.cxjd.nvwabao.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 评论对象
 */
public class Comment {
    private int id;
    @SerializedName("content")
    public String mContent; // 评论内容
    private String create_time;
    private int father_comment_id;
    private int reply_obj_id;
    @SerializedName("author")
    public User mCommentator; // 评论者
    @SerializedName("replyPerson")
    public User mReceiver; // 接收者（即回复谁）

    public Comment(User mCommentator, String mContent, User mReceiver) {
        this.mCommentator = mCommentator;
        this.mContent = mContent;
        this.mReceiver = mReceiver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getFather_comment_id() {
        return father_comment_id;
    }

    public void setFather_comment_id(int father_comment_id) {
        this.father_comment_id = father_comment_id;
    }

    public int getReply_obj_id() {
        return reply_obj_id;
    }

    public void setReply_obj_id(int reply_obj_id) {
        this.reply_obj_id = reply_obj_id;
    }

    public User getmCommentator() {
        return mCommentator;
    }

    public void setmCommentator(User mCommentator) {
        this.mCommentator = mCommentator;
    }

    public User getmReceiver() {
        return mReceiver;
    }

    public void setmReceiver(User mReceiver) {
        this.mReceiver = mReceiver;
    }
}
