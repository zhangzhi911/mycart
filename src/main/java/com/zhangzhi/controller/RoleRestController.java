package com.zhangzhi.controller;

import com.zhangzhi.annotation.Pagable;
import com.github.pagehelper.PageInfo;
import com.zhangzhi.entity.Role;
import com.zhangzhi.service.ActivityService;
import com.zhangzhi.service.PermissionService;
import com.zhangzhi.service.RoleService;
import com.zhangzhi.vo.TreeNode;
import com.zhangzhi.vo.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleRestController {


    @Autowired
    private PermissionService permissionService;


    @Autowired
    private RoleService roleService;


    @Autowired
    private ActivityService activityService;


    //    角色
    @Pagable
    @RequestMapping("/rest/role/list")
    public PageInfo<Role> list(String name) {
        return roleService.findByPage(name);
    }



    @RequestMapping("/rest/role/roles")
    public List<Role> roles() {
        return roleService.roles();
    }


    @RequestMapping("/rest/role/save")
    public UserException save(Role role){
        roleService.save(role);
        return UserException.SUCCESS;
    }

    @RequestMapping("/rest/role/update")
    public UserException update(Role role){
        roleService.update(role);
        return UserException.SUCCESS;
    }

//    删除
    @RequestMapping("/rest/role/delete")
    public UserException delete(@RequestParam("roleId") List<Integer> roleId){
        roleService.delete(roleId);
        return UserException.SUCCESS;
    }

    //    权限列表
    @RequestMapping("/rest/permission/treeData")
    public UserException treeData(Integer roleId) {
        List<Integer> selectedPermissions = permissionService.selectPermissions(roleId);
        List<TreeNode> treeNodes = permissionService.treeData();

        Map<String, Object> data = new HashMap<>();
//        用map存起来
        data.put("selectedPermissions", selectedPermissions);
        data.put("treeNodes", treeNodes);
        return UserException.success(data);
    }
    //    设置权限
    @RequestMapping("/rest/permission/savePermissions")
    public boolean savePermissions(Integer roleId, @RequestParam(value="permissions", required = false) List<Integer> permissions) {
        permissionService.savePermissions(roleId, permissions);
        return true;
    }

    @RequestMapping("/rest/user/saveRoles")
    public UserException saveRoles(Integer userId, @RequestParam("roleIds") List<Integer> roleIds) {
        activityService.saveRoles(userId, roleIds);
        return UserException.SUCCESS;
    }

}