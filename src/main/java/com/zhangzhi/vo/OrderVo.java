package com.zhangzhi.vo;


import com.zhangzhi.entity.saldetail;
import lombok.Data;

import java.util.List;

@Data
public class OrderVo {

    private List<saldetail> details;
    private Integer province;
    private Integer city;
    private Integer area;
}
