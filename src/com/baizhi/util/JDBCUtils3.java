package com.baizhi.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCUtils3 {
    private static Properties prop =new Properties();
//书写静态代码块，将读取配置文件操作放在静态代码块
    static {
        try {
            InputStream in = JDBCUtils3.class.getResourceAsStream("/jdbc.properties");
            prop.load(in);
            in.close();
            //获取驱动
            String driverClassName = prop.getProperty("driverClassName");
            Class.forName(driverClassName);
            //System.out.println("driverClassName="+driverClassName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            String url = prop.getProperty("url");
            conn = DriverManager.getConnection(url,username,password);
//            System.out.println("username="+username);
//            System.out.println("password="+password);
//            System.out.println("url="+url);
        }catch (Exception e){
            e.printStackTrace();
        }
      return conn;
    }
    public static void close(Connection conn, PreparedStatement pstm, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (pstm!=null){
            try {
                pstm.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}

