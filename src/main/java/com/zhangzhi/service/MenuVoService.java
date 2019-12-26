package com.zhangzhi.service;

import com.zhangzhi.entity.MenuVo;
import com.zhangzhi.mapper.MenuVoMapper;
import com.zhangzhi.view.MenuVoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuVoService {

    @Autowired
    private MenuVoMapper menuVoMapper;

    public int deleteByPrimaryKey(Integer menuId) {
        return menuVoMapper.deleteByPrimaryKey(menuId);
    }

    public int insert(MenuVo record) {
        return menuVoMapper.insert(record);
    }

    public int insertSelective(MenuVo record) {
        return menuVoMapper.insertSelective(record);
    }

    public MenuVo selectByPrimaryKey(Integer menuId) {
        return menuVoMapper.selectByPrimaryKey(menuId);
    }

    public int updateByPrimaryKeySelective(MenuVo record) {
        return menuVoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MenuVo record) {
        return menuVoMapper.updateByPrimaryKeySelective(record);
    }
    public List<MenuVoView> selectMenuVoAll(){
        return menuVoMapper.selectMenuVoAll();
    }
}
