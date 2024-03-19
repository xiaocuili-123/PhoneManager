package com.baizhi.dao;

import com.baizhi.entity.Phone;
import com.baizhi.service.PhoneService;

import java.util.List;

public interface PhoneDao {
    List <Phone> selectAllPhone();
    void deletePhoneById(Integer phoneId);
    void insertOnePhone(Phone phone);
    Phone selectPhoneById(Integer phoneId);
    void updatePhoneById(Phone phone);
    void deletePhoneByBrandId(Integer brandId);
}
