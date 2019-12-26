package com.zhangzhi.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangzhi.entity.Employee;
import com.zhangzhi.entity.MyUser;
import com.zhangzhi.entity.Permission;
import com.zhangzhi.entity.UserRole;
import com.zhangzhi.mapper.*;
import com.zhangzhi.vo.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityService {

    @Autowired
    private ActivityMapper activityMapper;
//用于MIapper

    @Autowired
    private RolePermissionMapper rolePermissionMapper;
//权限Mapper

    @Autowired
    private UserRoleMapper userRoleMapper;
//角色Mapper

    @Autowired
    private EmployeeMapper employeeMapper;
//    员工Mapper


    public PageInfo<MyUser> findUser(MyUser myUser) {
        List<MyUser> users = activityMapper.findUser(myUser);
        return new PageInfo<>(users);
    }

    public List<Integer> roles(Integer userId) {
        return userRoleMapper.selectByUserId(userId);
    }

    //    添加用户
    public int insertUser(MyUser myUser, Employee employee) {

        activityMapper.insertUser(myUser);
        Integer userId = myUser.getUserId();
        System.out.println("来添加了"+userId);
        employee.setUid(userId);
        employee.setName(myUser.getName());
        employeeMapper.insertEmployee(employee);
        return userId;
    }



    //    修改用户
    public int updateUser(MyUser myUser) {
        return activityMapper.updateUser(myUser);
    }

    //    删除用户
    public int deleteUser(List<Integer> id) {
        employeeMapper.DeleteEmployee(id);
        return activityMapper.deleteUser(id);
    }

    //    修改用户


    //    登录用户
    public UserException findByUser(MyUser myUser) throws Exception {

        if (StringUtils.isEmpty((myUser.getName()))) {
            return UserException.errer("用户不为空");
        }
        if (StringUtils.isEmpty((myUser.getPassword()))) {
            return UserException.errer("密码不为空");
        }
        MyUser us = activityMapper.findByUser(myUser);
        if (us != null) {
            List<String> permissions = rolePermissionMapper.selectPermissionByUserId(us.getUserId());
            Map<String, Object> map = new HashMap<>();
            map.put("user", us);
            map.put("permissions", permissions);
            return UserException.success(map);
        } else {
            return UserException.errer("用户名或密码错误");
        }

    }

    public void saveRoles(Integer userId, List<Integer> roleIds) {
        userRoleMapper.deleteByUserId(userId);
        for (Integer roleId : roleIds) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoleMapper.insert(userRole);
        }
    }
}
