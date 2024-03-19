package com.baizhi.dao.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.JDBCUtils3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    @Override
    public User selectByUsernameAndPassword(String username, String password) {
       User user=null;
       try {
           conn=JDBCUtils3.getConnection();
           String sql="select * from t_user where username=? and password=?";
           pstm=conn.prepareStatement(sql);
           pstm.setString(1,username);
           pstm.setString(2,password);
           rs=pstm.executeQuery();
           while (rs.next()){
               int userId = rs.getInt("user_id");
               user=new User(userId,username,password);
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           JDBCUtils3.close(conn,pstm,rs);
       }
        return user;
    }

    @Override
    public void insertUser(User user) {
        try {
            conn= JDBCUtils3.getConnection();
            String sql="insert into t_user values(null,?,?)";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            int i= pstm.executeUpdate();
            System.out.println("受影响行数："+i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils3.close(conn,pstm,rs);
        }

    }
}
