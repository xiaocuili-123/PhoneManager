package com.baizhi.entity;

import java.io.Serializable;

public class Brand implements Serializable {
    private Integer brandId;
    private String brandName;
    private Integer phoneNum;

    public Brand(){}

    public Brand(Integer brandId, String brandName, Integer phoneNum) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.phoneNum = phoneNum;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }
}
