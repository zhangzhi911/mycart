package com.zhangzhi.view;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SalDetailView {

    private Integer sDetailId;
    private Integer salOrId;
    private Integer gsId;
    private Integer salNum;
    private BigDecimal amount;

    private String gsName;
}
