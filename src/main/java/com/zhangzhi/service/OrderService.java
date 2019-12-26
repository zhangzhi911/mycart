package com.zhangzhi.service;

import com.github.pagehelper.PageInfo;
import com.zhangzhi.entity.Order;
import com.zhangzhi.entity.OrderItem;
import com.zhangzhi.mapper.BaseMapper;
import com.zhangzhi.mapper.OrderItemMapper;
import com.zhangzhi.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderService extends BaseService<Order> {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    public PageInfo<Order> findByPage() {
        List<Order> list = orderMapper.findByPage();
        return new PageInfo<>(list);
    }

    public void save(List<OrderItem> orderItems) {
        BigDecimal orderAmount = BigDecimal.ZERO;
        for (OrderItem orderItem : orderItems) {
            BigDecimal itemAmount = orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQty()));
            orderAmount = orderAmount.add(itemAmount);
        }

        Order order = new Order();
        order.setCreateTime(new Date());
        order.setAmount(orderAmount);
        orderMapper.insertSelective(order);

        for (OrderItem orderItem : orderItems) {
            orderItem.setOrderId(order.getOrderId());
            orderItemMapper.insertSelective(orderItem);
        }
    }

    public void update(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    public void delete(List<Integer> orderId) {
        for (Integer id : orderId) {
            orderMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public BaseMapper<Order> getMapper() {
        return orderMapper;
    }
}
