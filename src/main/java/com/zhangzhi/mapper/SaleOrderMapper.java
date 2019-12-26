package com.zhangzhi.mapper;

import com.zhangzhi.entity.saleorder;
import com.zhangzhi.view.SaleOrderView;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SaleOrderMapper {

    SaleOrderView selectBySalOrId(Integer salOrId);

    int insertSelective(saleorder record);
}