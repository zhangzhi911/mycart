package com.zhangzhi.controller;

import com.github.pagehelper.PageInfo;
import com.zhangzhi.annotation.Pagable;
import com.zhangzhi.entity.MyUser;
import com.zhangzhi.entity.Permission;
import com.zhangzhi.service.ActivityService;
import com.zhangzhi.service.PermissionService;
import com.zhangzhi.vo.MyException;
import com.zhangzhi.vo.TreeNode;
import com.zhangzhi.vo.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private ActivityService activityService;


    //    用户列表
    @Pagable
    @RequestMapping("/rest/Myuser/userlist")
    public PageInfo<MyUser> vueuserlist(Model model, MyUser myuser, Integer pageSize) {
        return activityService.findUser(myuser);
    }

    @RequestMapping("/rest/user/roles")
    public List<Integer> roles(Integer userId) {
        return activityService.roles(userId);
    }


    //    登录用户
    @RequestMapping("/rest/activity/findByUser")
    public UserException findByUser(Model model, MyUser myuser) throws Exception {
        System.out.println("来了user" + myuser);
            return    activityService.findByUser(myuser);
    }

    //添加用户
    @RequestMapping("/rest/activity/insertuser")
    public Boolean insertuser(Model model, MyUser myuser) {
        System.out.println("来了添加" + myuser);
        return activityService.insertUser(myuser,null) > 0;
    }

//    修改用户
    @RequestMapping("/rest/user/update")
    public Boolean update(MyUser user) {
        activityService.updateUser(user);
        return true;
    }


    //    删除用户
    @RequestMapping("/rest/MyUser/deleteuser")
    public Boolean deleteuser(@RequestParam(value = "userId") List<Integer> userId) {
        System.out.println(userId);
        activityService.deleteUser(userId);
        return true;
    }



}

