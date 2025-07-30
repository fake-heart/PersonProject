package com.example.hometown.user.Mapper;

import com.example.hometown.user.userEntity.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface LoginMapper {
    //用户登录
    @Select("select * from user where username=#{username} and password=#{password}")
    List<user> selectUser(String username, String password);
}
