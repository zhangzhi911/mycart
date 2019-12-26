package com.zhangzhi.mapper;

import com.zhangzhi.entity.Order;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {
    List<Order> findByPage();
}