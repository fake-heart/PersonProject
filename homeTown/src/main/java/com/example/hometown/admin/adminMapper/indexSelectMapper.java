package com.example.hometown.admin.adminMapper;

import com.example.hometown.admin.adminEntity.culture;
import com.example.hometown.admin.adminEntity.food;
import com.example.hometown.admin.adminEntity.newUser;
import com.example.hometown.admin.adminEntity.scenic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface indexSelectMapper {
    //查询最新用户
    @Select("select id, username, phone, password, avatar_url, user_status, create_time, update_time from user order by create_time desc limit 1")
    newUser selectNewUser();
    //查询新增的景点
    @Select("select id, name, description, location, opening_hours, ticket_price, rating, view_count, main_image_id, create_by, create_time, update_time from scenic_spot order by update_time desc LIMIT 1")
    scenic selectNewScenic();

    //查询新增的美食
    @Select("select id, name, description, ingredients, cooking_method, origin_location, recommended_restaurant, main_image_id, create_by, create_time, update_time from cuisine order by update_time desc LIMIT 1")
    food selectNewFood();

    //查询新增的文化活动
    @Select("select id, name, description, history, related_holiday, main_image_id, create_by, create_time, update_time from cultural_feature order by update_time desc LIMIT 1")
    culture selectNewCulture();

}
