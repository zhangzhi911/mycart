package com.zhangzhi.controller;

import com.zhangzhi.service.MenuVoService;
import com.zhangzhi.view.MenuVoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuVoController {

    @Autowired
    private MenuVoService menuVoService;

//菜单管理系统
    @RequestMapping("/rest/MenuVoall")
    private List<MenuVoView> all(){
        return  menuVoService.selectMenuVoAll();
    }
}