package com.zhangzhi.service;

import com.github.pagehelper.PageInfo;
import com.zhangzhi.entity.Goods;
import com.zhangzhi.mapper.BaseMapper;
import com.zhangzhi.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsService extends BaseService<Goods> {

    @Autowired
    private GoodsMapper goodsMapper;

    public PageInfo<Goods> findByPage(String name) {
        List<Goods> list = goodsMapper.findByPage(name);
        return new PageInfo<>(list);
    }

    public void save(Goods goods) {
        goodsMapper.insertSelective(goods);
    }

    public void update(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    public void delete(List<Integer> goodsId) {
        for (Integer id : goodsId) {
            goodsMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public BaseMapper<Goods> getMapper() {
        return goodsMapper;
    }
}
