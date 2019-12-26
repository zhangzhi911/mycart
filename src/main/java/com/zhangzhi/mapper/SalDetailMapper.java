package com.zhangzhi.mapper;

import com.zhangzhi.entity.saldetail;
import com.zhangzhi.view.SalDetailView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SalDetailMapper {
    int insertDetails(@Param("salorid") Integer salorid, @Param("details") List<saldetail> details);

    List<SalDetailView> selectByOrderId(Integer salOrId);
}
