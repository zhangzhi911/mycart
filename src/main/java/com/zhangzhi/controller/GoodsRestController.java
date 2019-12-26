package com.zhangzhi.controller;

import com.github.pagehelper.PageInfo;
import com.zhangzhi.annotation.Pagable;
import com.zhangzhi.entity.Goods;
import com.zhangzhi.service.GoodsService;
import com.zhangzhi.vo.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsRestController {

    @Autowired
    private GoodsService goodsService;

    @Pagable
    @RequestMapping("/rest/goods/list")
    public PageInfo<Goods> list(String name) {
        return goodsService.findByPage(name);
    }


    @RequestMapping("/rest/goods/save")
    public UserException save(Goods goods){
        goodsService.save(goods);
        return UserException.SUCCESS;
    }

    @RequestMapping("/rest/goods/update")
    public UserException update(Goods goods){
        goodsService.update(goods);
        return UserException.SUCCESS;
    }

    @RequestMapping("/rest/goods/delete")
    public UserException delete(@RequestParam("goodsId") List<Integer> goodsId){
        goodsService.delete(goodsId);
        return UserException.SUCCESS;
    }
}
