package com.zhangzhi.controller;

import com.github.pagehelper.PageInfo;
import com.zhangzhi.annotation.Pagable;
import com.zhangzhi.entity.Order;
import com.zhangzhi.entity.OrderItem;
import com.zhangzhi.service.OrderService;
import com.zhangzhi.vo.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @Pagable
    @RequestMapping("/rest/order/list")
    public PageInfo<Order> list(String name) {
        return orderService.findByPage();
    }

    @RequestMapping("/rest/order/save")
    public UserException save(@RequestBody List<OrderItem> orderItems){
        orderService.save(orderItems);
        return UserException.SUCCESS;
    }

    @RequestMapping("/rest/order/update")
    public UserException update(Order order){
        orderService.update(order);
        return UserException.SUCCESS;
    }

    @RequestMapping("/rest/order/delete")
    public UserException delete(@RequestParam("OrderId") List<Integer> orderId){
        orderService.delete(orderId);
        return UserException.SUCCESS;
    }
}
