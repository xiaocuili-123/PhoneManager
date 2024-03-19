package com.baizhi.dao.impl;

import com.baizhi.dao.PhoneDao;
import com.baizhi.entity.Phone;
import com.baizhi.util.JDBCUtils3;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    @Override
    public List<Phone> selectAllPhone() {
        List<Phone> phoneList=new ArrayList();
        try {
            conn=JDBCUtils3.getConnection();
            pstm= conn.prepareStatement("select p.*,b.brand_name from t_phone p left join t_brand b on p.brand_id = b.brand_id");
            rs=pstm.executeQuery();
            while (rs.next()){
                int phoneId = rs.getInt("phone_id");
                String phoneName = rs.getString("phone_name");
                double price = rs.getDouble("price");
                int state = rs.getInt("state");
                int brandId = rs.getInt("brand_id");
                String brandName = rs.getString("brand_name");
                phoneList.add(new Phone(phoneId,phoneName,new BigDecimal(price),state,brandId,brandName));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils3.close(conn,pstm,rs);
        }
        return phoneList;
    }

    @Override
    public void deletePhoneById(Integer phoneId) {
        try {
            conn=JDBCUtils3.getConnection();
            pstm= conn.prepareStatement("delete from t_phone where phone_id=?");
            pstm.setInt(1,phoneId);
            int i=pstm.executeUpdate();
            System.out.println("受影响行数："+i);
        }catch (Exception e){
        e.printStackTrace();
        }finally {
        JDBCUtils3.close(conn,pstm,rs);
        }
    }

    @Override
    public void insertOnePhone(Phone phone) {
        try {
            conn=JDBCUtils3.getConnection();
            pstm= conn.prepareStatement("insert into t_phone values (null,?,?,?,?)");
            pstm.setString(1,phone.getPhoneName());
            pstm.setBigDecimal(2,phone.getPrice());
            pstm.setInt(3,phone.getState());
            pstm.setInt(4,phone.getBrandId());
            int i=pstm.executeUpdate();
            System.out.println("受影响行数："+i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils3.close(conn,pstm,rs);
        }
    }

    @Override
    public Phone selectPhoneById(Integer phoneId) {
        Phone phone=null;
        try {
            conn=JDBCUtils3.getConnection();
            pstm= conn.prepareStatement("select *from t_phone where phone_id=?");
            pstm.setInt(1,phoneId);
            rs=pstm.executeQuery();
            while (rs.next()){
                //int phoneId1 = rs.getInt("phone_id");
                String phoneName = rs.getString("phone_name");
                double price = rs.getDouble("price");
                int state = rs.getInt("state");
                int brandId = rs.getInt("brand_id");
                phone=new Phone(phoneId,phoneName,new BigDecimal(price),state,brandId,null);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils3.close(conn,pstm,rs);
        }
        return phone;
    }

    @Override
    public void updatePhoneById(Phone phone) {
        try {
            conn=JDBCUtils3.getConnection();
            pstm= conn.prepareStatement("update t_phone set phone_name=?,price=?,state=?,brand_id=? where phone_id=?");
            pstm.setString(1,phone.getPhoneName());
            pstm.setBigDecimal(2,phone.getPrice());
            pstm.setInt(3,phone.getState());
            pstm.setInt(4,phone.getBrandId());
            pstm.setInt(5,phone.getPhoneId());
            int i=pstm.executeUpdate();
            System.out.println("受影响行数："+i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils3.close(conn,pstm,rs);
        }
    }

    @Override
    public void deletePhoneByBrandId(Integer brandId) {
        try {
            conn=JDBCUtils3.getConnection();
            pstm= conn.prepareStatement("delete from t_phone where brand_id=?");
            pstm.setInt(1,brandId);
            int i=pstm.executeUpdate();
            System.out.println("受影响行数："+i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils3.close(conn,pstm,rs);
        }
    }
}


