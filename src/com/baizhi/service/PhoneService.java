package com.baizhi.service;

import com.baizhi.entity.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> findAllPhone();
    void deleteOnePhone(Integer phoneId);
    void addPhone(Phone phone);
    Phone findPhoneById(Integer phoneId);
    void updatePhone(Phone phone);
    void deleteByBrandId(Integer brandId);

}
