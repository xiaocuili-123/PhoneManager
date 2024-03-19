package com.baizhi.service;

import com.baizhi.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findBrand();
    void insertBrand(Brand brand);
    void deleteBrandById(Integer brandId);
}
