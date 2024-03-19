package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {
    User selectByUsernameAndPassword(String username, String password);
    void insertUser(User user);
}
