package com.baizhi.dao;

import com.baizhi.entity.Brand;

import java.util.List;

public interface BrandDao {
    List<Brand> selectAllBrand();
    void insertBrand(Brand brand);
    void deleteBrandById(Integer brandId);
}
