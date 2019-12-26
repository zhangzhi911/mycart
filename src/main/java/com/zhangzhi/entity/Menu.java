package com.zhangzhi.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Integer id;
    private String menuName;
    private String menuIcon;
    private String menuPath;
    private Integer parentId;
    List<Menu> children;
}
