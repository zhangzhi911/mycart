package com.zhangzhi.view;

import lombok.Data;

import java.util.List;

@Data
public class RoleMenuView {

    private  Integer id;
    private String menuName;
    private  Integer pid;
    private String checked;
    private List<RoleMenuView> children;

}
