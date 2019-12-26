package com.zhangzhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MyUser {

    private Integer userId;

    private String loginName;

    private String password;

    private String name;

    private String avatar;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private Integer sex;
}
