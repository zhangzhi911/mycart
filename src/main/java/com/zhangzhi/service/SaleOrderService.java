package com.zhangzhi.service;

import com.zhangzhi.entity.MyUser;
import com.zhangzhi.entity.saleorder;
import com.zhangzhi.mapper.SalDetailMapper;
import com.zhangzhi.mapper.SaleOrderMapper;
import com.zhangzhi.view.SalDetailView;
import com.zhangzhi.view.SaleOrderView;
import com.zhangzhi.vo.OrderVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleOrderService {

    @Autowired
    private SaleOrderMapper saleOrderMapper;
    @Autowired
    private SalDetailMapper salDetailMapper;


    public saleorder save(MyUser MyUser, OrderVo order) {
        saleorder saleorder = saveOrder(MyUser, order);
        salDetailMapper.insertDetails(saleorder.getSalorid(), order.getDetails());
        return saleorder;
    }

    public saleorder saveOrder(MyUser MyUser, OrderVo order) {
        saleorder saleorder = new saleorder();
        saleorder.setUserid(MyUser.getUserId());
        saleorder.setOrddate(new Date());
        try {
            BeanUtils.copyProperties(saleorder, order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saleOrderMapper.insertSelective(saleorder);
        return saleorder;
    }

    public SaleOrderView findOrderById(Integer salOrId) {
        SaleOrderView order = saleOrderMapper.selectBySalOrId(salOrId);
        List<SalDetailView> details = salDetailMapper.selectByOrderId(salOrId);
        order.setDetails(details);
        return order;
    }

}
