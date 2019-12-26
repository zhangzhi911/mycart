package com.zhangzhi.mapper;

import com.zhangzhi.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ActivityMapper {


    //    查询用户
    public List<MyUser> findUser(MyUser myuser);

    //    添加用户
    public int insertUser(MyUser myUser);

    //    修改用户
    public int updateUser(MyUser myUser);

    //    删除用户
    public int deleteUser(List<Integer> id);



    //    登录用户
    public MyUser findByUser(MyUser myUser);


}
