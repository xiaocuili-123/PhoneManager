package com.baizhi.test;

import com.baizhi.dao.BrandDao;
import com.baizhi.dao.impl.BrandDaoImpl;
import com.baizhi.entity.Brand;
import org.junit.Test;

import java.util.List;

public class BrandDaoTest {
  BrandDao brandDao = new BrandDaoImpl();
  @Test
  public void testBrandSelect(){
      List<Brand> brands = brandDao.selectAllBrand();
      for (Brand brand : brands){
          System.out.println(brand);
      }
  }
  @Test
    public void testinsertBrand(){
      Brand brand = new Brand(null, "oppo", null);
      brandDao.insertBrand(brand);
  }
}
