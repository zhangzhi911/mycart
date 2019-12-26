package com.zhangzhi.controller;


import com.zhangzhi.entity.MyUser;
import com.zhangzhi.service.ActivityService;
import com.zhangzhi.service.MenuService;
import com.zhangzhi.service.SaleOrderService;
import com.zhangzhi.view.RoleMenuView;
import com.zhangzhi.view.SaleOrderView;
import com.zhangzhi.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VueController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private MenuService menuService;

// 添加商品
    @Autowired
    private SaleOrderService saleOrderService;


    // 第一次权限列表
    @RequestMapping("/rest/menu/listBy")
    public List<RoleMenuView> jurisdiction(Integer uid) {
        List<RoleMenuView> lists = menuService.selectAll(uid);
        for (RoleMenuView r : lists
        ) {
            System.out.println(r.toString());
        }
        return lists;
    }

//    添加商品
    @RequestMapping("/rest/order/Mysave")
    public int save(OrderVo order,@RequestParam(value = "uid",defaultValue = "19") Integer uid) {
        MyUser myUser = new MyUser();
        myUser.setUserId(uid);
        saleOrderService.save(myUser, order);
        return 1;
    }

//订单列表
    @RequestMapping("/rest/order/get")
    public SaleOrderView findOrderById(Integer salOrId) {
        return saleOrderService.findOrderById(salOrId);
    }
    private MyUser getUser() {
//        User user = (User) session.getAttribute("loginUser");
        MyUser user = new MyUser();
        user.setUserId(1);
        user.setName("张三");
        return user;
    }

}
