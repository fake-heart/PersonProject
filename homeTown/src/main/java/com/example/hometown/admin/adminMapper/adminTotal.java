package com.example.hometown.admin.adminMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface adminTotal {
    //景点总数
    @Select("select count(*) from scenic_spot")
    int selectScenicTotal();
    //用户总数
    @Select("select count(*) from user")
    int selectUserTotal();
    //美食总数
    @Select("select count(*) from cuisine")
    int selectCuisineTotal();
    //文化总数
    @Select("select count(*) from cultural_feature")
    int selectCultureTotal();
}
