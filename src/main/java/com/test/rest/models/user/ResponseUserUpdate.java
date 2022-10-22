package com.test.rest.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseUserUpdate {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("job")
    @Expose
    private String job;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    public ResponseUserUpdate() {
    }

    public ResponseUserUpdate(String name, String job, String updatedAt) {
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ResponseUserUpdate{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
