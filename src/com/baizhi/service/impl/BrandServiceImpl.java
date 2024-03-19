package com.baizhi.service.impl;

import com.baizhi.dao.BrandDao;
import com.baizhi.dao.impl.BrandDaoImpl;
import com.baizhi.entity.Brand;
import com.baizhi.service.BrandService;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    BrandDao brandDao=new BrandDaoImpl();
    @Override
    public List<Brand> findBrand() {
        return brandDao.selectAllBrand();
    }

    @Override
    public void insertBrand(Brand brand) {
        brandDao.insertBrand(brand);
    }

    @Override
    public void deleteBrandById(Integer brandId) {
        brandDao.deleteBrandById(brandId);
    }
}
