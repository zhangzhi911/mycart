package com.zhangzhi.mapper;


import com.zhangzhi.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer rolePermissionId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rolePermissionId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    void deleteByRoleId(Integer id);

    List<Integer> selectByRoleId(Integer roleId);

    List<String> selectPermissionByUserId(Integer roleId);

}