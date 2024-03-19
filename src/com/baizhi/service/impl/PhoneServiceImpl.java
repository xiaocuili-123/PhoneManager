package com.baizhi.service.impl;

import com.baizhi.dao.PhoneDao;
import com.baizhi.dao.impl.PhoneDaoImpl;
import com.baizhi.entity.Phone;
import com.baizhi.service.PhoneService;
import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    private PhoneDao phoneDao=new PhoneDaoImpl();
    @Override
    public List<Phone> findAllPhone() {
        return phoneDao.selectAllPhone();
    }

    @Override
    public void deleteOnePhone(Integer phoneId) {
        phoneDao.deletePhoneById(phoneId);

    }

    @Override
    public void addPhone(Phone phone) {
        phoneDao.insertOnePhone(phone);
    }

    @Override
    public Phone findPhoneById(Integer phoneId) {
        return phoneDao.selectPhoneById(phoneId);
    }

    @Override
    public void updatePhone(Phone phone) {
        phoneDao.updatePhoneById(phone);
    }

    @Override
    public void deleteByBrandId(Integer brandId) {
        phoneDao.deletePhoneByBrandId(brandId);
    }
}
