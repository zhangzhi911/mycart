package com.zhangzhi.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Salary {

    private Integer id;
    private Integer uid;
    private BigDecimal salary_base = new BigDecimal(0);
    private BigDecimal salary_subsidy = new BigDecimal(0);
    private BigDecimal salary_bonus = new BigDecimal(0);
    private BigDecimal salary_extra = new BigDecimal(0);
    private Integer year;
    private Integer month;
}