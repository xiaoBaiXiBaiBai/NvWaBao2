package com.cxjd.nvwabao.bean;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.DataSupport;

/**
 * 用户
 */
public class User extends DataSupport{
    @SerializedName("id")
    public long mId; // id
    @SerializedName("user_name")
    public String mName; // 用户名
    @SerializedName("user_pwd")
    public String password;
    @SerializedName("user_phone")
    private String accountNumbers;

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountNumbers() {
        return accountNumbers;
    }

    public void setAccountNumbers(String accountNumbers) {
        this.accountNumbers = accountNumbers;
    }

    public User(long mId, String mName) {
        this.mId = mId;
        this.mName = mName;
    }

    public User() {
    }
}
