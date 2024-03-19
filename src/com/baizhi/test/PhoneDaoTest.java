package com.baizhi.test;

import com.baizhi.dao.PhoneDao;
import com.baizhi.dao.impl.PhoneDaoImpl;
import com.baizhi.entity.Phone;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class PhoneDaoTest {
    PhoneDao phoneDao = new PhoneDaoImpl();
    @Test

    public void testSelectAllPhone(){

        List<Phone> phones = phoneDao.selectAllPhone();
        for (Phone phone:
             phones) {
            System.out.println(phone);
        }
    }
    @Test
    public void testDelete(){
        phoneDao.deletePhoneById(3);
    }
    @Test
    public void testSelectPhoneById(){
        Phone phone=phoneDao.selectPhoneById(1);
        System.out.println(phone);
    }
    @Test
    public void testInsertPhone(){
        phoneDao.insertOnePhone(new Phone(null,"samsung23",new BigDecimal(5999),1,4,null));
    }
    @Test
    public void testUpdatePhone(){
        Phone phone = new Phone(1,"iPhone15promax暗夜紫",new BigDecimal(19999),0,1,null);
        phoneDao.updatePhoneById(phone);
    }
    @Test
    public void testdeleteByBrandId(){
        phoneDao.deletePhoneByBrandId(1);
    }
}
