package com.zhangzhi.entity;

import java.math.BigDecimal;


public class saldetail {
    private Integer sdetailid;

    private Integer salorid;

    private Integer gsid;

    private Integer salnum;

    private BigDecimal amount;

    public Integer getSdetailid() {
        return sdetailid;
    }

    public void setSdetailid(Integer sdetailid) {
        this.sdetailid = sdetailid;
    }

    public Integer getSalorid() {
        return salorid;
    }

    public void setSalorid(Integer salorid) {
        this.salorid = salorid;
    }

    public Integer getGsid() {
        return gsid;
    }

    public void setGsid(Integer gsid) {
        this.gsid = gsid;
    }

    public Integer getSalnum() {
        return salnum;
    }

    public void setSalnum(Integer salnum) {
        this.salnum = salnum;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}