package com.zhangzhi.mapper;


import com.zhangzhi.entity.UserRole;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    public void deleteByUserId(Integer userId);

    List<Integer> selectByUserId(Integer userId);
}