package com.example.hometown.user.Mapper;

import com.example.hometown.user.userEntity.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface registerMapper {

    //用户注册
    @Select("insert into user(username,password,phone,create_time,update_time) values(#{username},#{password},#{phone},#{createTime},#{updateTime})")
    void insertUser(user user);
}
