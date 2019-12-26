package com.zhangzhi.mapper;

import com.zhangzhi.view.RoleMenuView;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {

    public List<RoleMenuView> selectAll(Integer id);

}