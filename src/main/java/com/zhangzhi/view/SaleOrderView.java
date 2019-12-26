package com.zhangzhi.view;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class SaleOrderView {

    private Integer salOrId;
    private Integer userId;
    private Date ordDate;
    private BigDecimal totalSum;
    private Integer province;
    private Integer city;
    private Integer area;

    private String provinceName;
    private String cityName;
    private String areaName;

    private List<SalDetailView> details;
}