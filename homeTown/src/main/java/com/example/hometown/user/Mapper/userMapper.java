package com.example.hometown.user.Mapper;

import com.example.hometown.admin.adminEntity.culture;
import com.example.hometown.admin.adminEntity.food;
import com.example.hometown.admin.adminEntity.scenic;
import com.example.hometown.user.userEntity.culture_collection;
import com.example.hometown.user.userEntity.food_collection;
import com.example.hometown.user.userEntity.scenic_collection;
import com.example.hometown.user.userEntity.user;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface userMapper {
    //  查询最新三个景点
    @Select("select * from scenic_spot order by  update_time desc Limit 3 ")
    List<scenic> getScenic();
    // 查询最新三个美食
    @Select("select * from cuisine order by update_time desc Limit 3")
    List<food>  getFood();
    // 查询所有景点
    @Select("select * from scenic_spot")
    List<scenic> SelectAllScenic();
    // 查询所有美食
    @Select("select * from cuisine")
    List<food> SelectAllFood();
    //查询全部的文化
    @Select("select * from cultural_feature")
    List<culture> SelectAllCulture();
    //根据文化名称搜索文化
    @Select("select * from cultural_feature where name like concat('%',#{name},'%')")
    List<culture> searchCulture(String name);
    //根据美食名称搜索美食
    @Select("select * from cuisine where name like concat('%',#{name},'%')")
    List<food> SelectFoodByName(String name);
    //根据景点名称搜索景点
    @Select("select * from scenic_spot where name like concat('%',#{name},'%')")
    List<scenic> selectScenicByName(String name);
    //根据用户名查询用户
    @Select("select * from user where username=#{username}")
    user findByUsername(String username);
    //  更新用户信息
    void updateUserInfo(user loginUser);

   //  添加文化收藏
    void addCollect(Integer userId, Integer cultureId, String name, LocalDate createTime, LocalDate updateTime);
   //  展示文化收藏
    List<culture_collection> showCultureCollection(Integer userId );
   //  添加美食收藏
    void addFoodCollect(Integer userId, Integer cuisineId, String name, LocalDate createTime, LocalDate updateTime);
   //  添加景点收藏
    void addScenicCollect(Integer userId, Integer scenicId, String name, LocalDate createTime, LocalDate updateTime);
   //  展示美食收藏
    List<food_collection> showFoodCollection(Integer userId);
   //  展示景点收藏
    List<scenic_collection> showScenicCollection(Integer userId );
   //  查询文化收藏总数
    @Select("select count(*) from culture_collection where culture_collection.user_id=#{user_id}")
    Integer selectCultureTotal(Integer userId);
   //  查询美食收藏总数
    @Select("select count(*) from cuisine_collection where cuisine_collection.user_id=#{user_id}")
    Integer selectFoodTotal(Integer userId);
   //  查询景点收藏总数
    @Select("select count(*) from scenic_collection where scenic_collection.user_id=#{user_id}")
    Integer selectScenicTotal(Integer userId);

}
