package com.zhangzhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@MapperScan("com.zhangzhi.mapper")
@SpringBootApplication
public class MycartApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycartApplication.class, args);
    }

}
