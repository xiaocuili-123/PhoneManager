package com.baizhi.test;

import com.baizhi.dao.UserDao;
import com.baizhi.dao.impl.UserDaoImpl;
import com.baizhi.entity.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testSelectUser(){
        UserDao userDao = new UserDaoImpl();
        User user = userDao.selectByUsernameAndPassword("崔云皓", "123456");
        System.out.println(user);
    }
}
