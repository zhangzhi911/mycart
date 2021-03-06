package com.zhangzhi.view;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SalaryView {

    private Integer id;
    private Integer uid;
    private String name;
    private BigDecimal salary_base = new BigDecimal(0);
    private BigDecimal salary_subsidy = new BigDecimal(0);
    private BigDecimal salary_bonus = new BigDecimal(0);
    private BigDecimal salary_extra = new BigDecimal(0);
    private Integer year;
    private Integer month;
    private  BigDecimal total=new BigDecimal(0);
    private BigDecimal avgtotal=new BigDecimal(0);

}