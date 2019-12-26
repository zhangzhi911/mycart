package com.zhangzhi.service;


import com.zhangzhi.mapper.BaseMapper;

public abstract class BaseService<E> {

    public abstract BaseMapper<E> getMapper();

    public int deleteByPrimaryKey(Integer id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    public int insert(E record) {
        return getMapper().insert(record);
    }

    public int insertSelective(E record) {
        return getMapper().insertSelective(record);
    }

    public E selectByPrimaryKey(Integer id) {
        return getMapper().selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(E record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(E record) {
        return getMapper().updateByPrimaryKey(record);
    }
}
