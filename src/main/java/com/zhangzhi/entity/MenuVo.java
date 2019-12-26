package com.zhangzhi.entity;

import lombok.Data;

@Data
public class MenuVo {
    private Integer menuId;

    private String name;

    private String path;

    private Integer parentId;
}