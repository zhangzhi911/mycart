package com.zhangzhi.service;

import com.zhangzhi.entity.Permission;
import com.zhangzhi.entity.RolePermission;
import com.zhangzhi.mapper.PermissionMapper;
import com.zhangzhi.mapper.RolePermissionMapper;
import com.zhangzhi.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionService  {

    @Autowired

    private  PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

//    用于回显查询的
    public List<Integer> selectPermissions(Integer roleId) {
        return rolePermissionMapper.selectByRoleId(roleId);
    }

    public List<TreeNode> treeData() {
        // 1. 以列表形式查询所有的权限
        List<Permission> permissions = permissionMapper.selectAll();
        // 2. 创建权限的父子关系
        Map<Integer, List<Permission>> permissionMap = new HashMap<>();

        // 3. 遍历并整理父子权限的关系，key为父节点ID，value为子结点对象列表
        for (Permission permission : permissions) {
            Integer parentId = permission.getParentId();

            List<Permission> children = permissionMap.get(parentId);

            if (children == null) {
//                如果是子节点的话指定一个父id  空孩子
                children = new ArrayList<>();
                permissionMap.put(parentId, children);
//            遍历出来的都是空的，将数据 key 所对应的value先弄好
            }


            children.add(permission);
//            最后在将这个对象进行赋值
        }

        // 4. 处理根结点
        List<TreeNode> roots = new ArrayList<>();


        List<Permission> rootPermissions = permissionMap.get(0);

        if (rootPermissions != null) {

            for (Permission rootPermission : rootPermissions) {

                TreeNode root = new TreeNode();
                roots.add(root);

                traverse(root, rootPermission, permissionMap);

            }

        }

        return roots;
    }

//    下面相当于一个递归 ，无限的循环创建自己的子节点
    /**
     * 遍历生成所有的子结点
     **/
    private void traverse(TreeNode parentNode, Permission parentPermission, Map<Integer, List<Permission>> permissionMap) {
        // 1. 填充父结点对象
        Integer parentId = parentPermission.getPermissionId();
        parentNode.setId(parentId);//   id
        parentNode.setLabel(parentPermission.getName());//名称

        // 2. 创建子结点列表，用来存储当前结点的子结点
        List<TreeNode> children = new ArrayList<>();
        parentNode.setChildren(children);

        // 3. 找到当前结点的子权限
        List<Permission> childPermissions = permissionMap.get(parentId);
        if (childPermissions != null) {
            // 4. 遍历所有的子权限进行递归造结点
            for (Permission childPermission : childPermissions) {

                TreeNode child = new TreeNode();
                children.add(child);

                traverse(child, childPermission, permissionMap);
            }
        }
    }

//下面是添加方法
    public void savePermissions(Integer roleId, List<Integer> permissions) {
        rolePermissionMapper.deleteByRoleId(roleId);
        if (permissions == null) {
            return;
        }
        for (Integer permission : permissions) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permission);
            rolePermissionMapper.insert(rolePermission);
        }
    }
}
