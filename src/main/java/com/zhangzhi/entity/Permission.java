package com.zhangzhi.entity;

import lombok.Data;

@Data
public class Permission {
    private Integer permissionId;
    private String name;
    private String value;
    private String remark;
    private Integer parentId;
}