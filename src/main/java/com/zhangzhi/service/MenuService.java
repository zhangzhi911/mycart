package com.zhangzhi.service;

import com.zhangzhi.mapper.MenuMapper;
import com.zhangzhi.view.RoleMenuView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<RoleMenuView> selectAll(Integer uid){
        return menuMapper.selectAll(uid);
    };
}
