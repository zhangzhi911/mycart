package com.zhangzhi.mapper;

import com.zhangzhi.entity.Goods;

import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods> {

    List<Goods> findByPage(String name);
}