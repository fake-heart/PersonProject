package com.example.hometown.admin.adminMapper;

import com.example.hometown.admin.adminEntity.admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface adminMapper {
    //查询管理员
    @Select("select id, username, password, role from admin where username=#{username} and password=#{password} ")
    List<admin> selectAdmin(String username, String password);


}
