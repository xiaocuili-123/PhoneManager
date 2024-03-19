package com.baizhi.dao.impl;

import com.baizhi.dao.BrandDao;
import com.baizhi.entity.Brand;
import com.baizhi.util.JDBCUtils3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BrandDaoImpl implements BrandDao {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    @Override
    public List<Brand>  selectAllBrand() {
        List<Brand> brands = new ArrayList<>();
        try {
            conn= JDBCUtils3.getConnection();
            pstm=conn.prepareStatement("SELECT b.*,count(p.brand_id) phoneNum FROM t_brand b LEFT JOIN t_phone p ON b.brand_id = p.brand_id group by b.brand_id");
            rs=pstm.executeQuery();
            while (rs.next()){
                int brandId = rs.getInt("brand_id");
                String brandName = rs.getString("brand_name");
                int phoneNum = rs.getInt("phoneNum");
                brands.add(new Brand(brandId,brandName,phoneNum));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils3.close(conn,pstm,rs);
        }
        return brands;
    }

    @Override
    public void insertBrand(Brand brand) {
        try {
            conn= JDBCUtils3.getConnection();
            pstm=conn.prepareStatement("insert into t_brand values(null,?)");
            pstm.setString(1,brand.getBrandName());
            int i =pstm.executeUpdate();
            System.out.println("受影响行数："+i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils3.close(conn,pstm,rs);
        }
    }

    @Override
    public void deleteBrandById(Integer brandId) {
        try {
            conn=JDBCUtils3.getConnection();
            pstm=conn.prepareStatement("delete from t_brand where brand_id=? ");
            pstm.setInt(1,brandId);
            int i = pstm.executeUpdate();
            System.out.println("受影响行数："+i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils3.close(conn,pstm,rs);
        }
    }
}
