package com.zhangzhi.entity;

import java.math.BigDecimal;
import java.util.Date;

public class saleorder {
    private Integer salorid;

    private Integer userid;

    private Date orddate;

    private BigDecimal totalsum;

    private Integer province;

    private Integer city;

    private Integer area;

    public Integer getSalorid() {
        return salorid;
    }

    public void setSalorid(Integer salorid) {
        this.salorid = salorid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getOrddate() {
        return orddate;
    }

    public void setOrddate(Date orddate) {
        this.orddate = orddate;
    }

    public BigDecimal getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(BigDecimal totalsum) {
        this.totalsum = totalsum;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}