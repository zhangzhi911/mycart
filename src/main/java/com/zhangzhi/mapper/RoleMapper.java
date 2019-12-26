package com.zhangzhi.mapper;


import com.zhangzhi.entity.Role;
import com.zhangzhi.entity.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> findByPage(String name);

    List<Role> selectAll();
}