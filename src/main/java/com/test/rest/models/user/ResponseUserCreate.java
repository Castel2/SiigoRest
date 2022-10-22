package com.test.rest.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseUserCreate {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("job")
    @Expose
    private String job;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    public ResponseUserCreate(String name, String job, Integer id, String createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ResponseUserCreate{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", id=" + id +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
