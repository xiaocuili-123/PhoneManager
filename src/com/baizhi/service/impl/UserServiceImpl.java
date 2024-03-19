package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.dao.impl.UserDaoImpl;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;


public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {

        return userDao.selectByUsernameAndPassword(username, password);

    }

    @Override
    public boolean register(String username, String password1, String password2) {
        //判断是否为空串
        if (username.equals("") || password1.equals("") || password2.equals("")) {
            return false;
        }
        //判断两次输入的密码是否一致
        if (password1.equals(password2)) {
            //两次密码相同，调用dao的添加方法
            UserDao userDao = new UserDaoImpl();
            userDao.insertUser(new User(null, username, password1));
            return true;
        } else {
            return false;
        }
    }
}
