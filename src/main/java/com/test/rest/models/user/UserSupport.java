package com.test.rest.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserSupport {

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("text")
    @Expose
    private String text;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "UserSupport{" +
                "url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
