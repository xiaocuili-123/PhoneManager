package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    User login(String username,String password);
    boolean register(String username,String password1,String password2);
}
