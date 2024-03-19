package com.baizhi.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Phone implements Serializable {
    private Integer phoneId;
    private String phoneName;
    private BigDecimal price;
    private Integer state;
    private Integer brandId;
    private String brandName;


    public Phone(){}

    public Phone(Integer phoneId, String phoneName, BigDecimal price, Integer state, Integer brandId, String brandName) {
        this.phoneId = phoneId;
        this.phoneName = phoneName;
        this.price = price;
        this.state = state;
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    @Override
    public String toString() {
        return "Phone{" +
                "phoneId=" + phoneId +
                ", phoneName='" + phoneName + '\'' +
                ", price=" + price +
                ", state=" + state +
                ", brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}


