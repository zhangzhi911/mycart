package com.zhangzhi.entity;

import lombok.Data;

@Data
public class RolePermission {

    private Integer rolePermissionId;

    private Integer roleId;

    private Integer permissionId;
}