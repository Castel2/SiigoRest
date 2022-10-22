package com.test.rest.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("data")
    @Expose
    private UserData data;

    @SerializedName("support")
    @Expose
    private  UserSupport support;

    public UserResponse(UserData data, UserSupport support) {
        this.data = data;
        this.support = support;
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public UserSupport getSupport() {
        return support;
    }

    public void setSupport(UserSupport support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }
}
