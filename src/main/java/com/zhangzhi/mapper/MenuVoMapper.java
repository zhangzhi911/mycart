package com.zhangzhi.mapper;

import com.zhangzhi.entity.MenuVo;
import com.zhangzhi.view.MenuVoView;

import java.util.List;

public interface MenuVoMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(MenuVo record);

    int insertSelective(MenuVo record);

    MenuVo selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(MenuVo record);

    int updateByPrimaryKey(MenuVo record);

    List<MenuVoView> selectMenuVoAll();

}