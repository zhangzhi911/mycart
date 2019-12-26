package com.zhangzhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class Employee {
    private  Integer uid;
    private  String name;
    private  String mobile;
    private  String department;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date entry_date;


    private List<Salary> childrend;
}