package com.zhangzhi.service;

import com.github.pagehelper.PageInfo;
import com.zhangzhi.entity.Role;
import com.zhangzhi.mapper.RoleMapper;
import com.zhangzhi.mapper.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    public PageInfo<Role> findByPage(String name) {
        List<Role> list = roleMapper.findByPage(name);
        return new PageInfo<>(list);
    }

    public void save(Role role) {
        roleMapper.insertSelective(role);
    }

//查询所


    public void update(Role role) {
//        Role dbRole = roleMapper.selectByPrimaryKey(role.getRoleId());
//        dbRole.setName(role.getName());
//        dbRole.setPassword(role.getPassword());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public void delete(List<Integer> roleId) {
        for(Integer id : roleId) {
            rolePermissionMapper.deleteByRoleId(id);
            roleMapper.deleteByPrimaryKey(id);
        }
    }
    public List<Role> roles() {
        return roleMapper.selectAll();
    }
}
