package com.baizhi.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;
    private String username;
    private String password;

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Integer userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
}
