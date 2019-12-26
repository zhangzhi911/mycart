package com.zhangzhi.mapper;

import com.zhangzhi.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {

    int insert(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKey(Permission record);

    List<Permission> selectAll();
}