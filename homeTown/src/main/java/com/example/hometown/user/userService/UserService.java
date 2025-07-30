package com.example.hometown.user.userService;

import com.example.hometown.admin.adminEntity.culture;
import com.example.hometown.admin.adminEntity.food;
import com.example.hometown.admin.adminEntity.scenic;
import com.example.hometown.user.userEntity.culture_collection;
import com.example.hometown.user.userEntity.food_collection;
import com.example.hometown.user.userEntity.scenic_collection;
import com.example.hometown.user.userEntity.user;

import java.util.List;

public interface UserService {
     //获取景点信息
    List<scenic> getScenic();
    //获取美食信息
    List<food> getFood();
    //查询全部的景点信息
    List<scenic> SelectAllScenic();
    //查询全部的美食信息
    List<food>  SelectAllFood();
    //查询全部的w文化信息
    List<culture>   SelectAllCulture();
   //根据文化名字搜索文化
    List<culture> searchCulture(String name);
    //根据美食名字搜索美食
    List<food> SelectFoodByName(String name);
    //根据景点名字搜索景点
    List<scenic> selectScenicByName(String name);
    //根据用户名查询用户
    user findByUsername(String username);
    //更新用户信息
    void updateUser(user loginUser);
   //添加文化收藏
    void addCollect(Integer userId, Integer cultureId,  String name);
   //显示文化收藏
    List<culture_collection> showCultureCollection(Integer userId );
   //添加美食收藏
    void addFoodCollect(Integer userId, Integer cuisineId, String name);
   //添加景点收藏
    void addScenicCollect(Integer userId, Integer scenicId, String name);
   //显示美食收藏
    List<food_collection> showFoodCollection(Integer userId);
    //显示景点收藏
    List<scenic_collection> showScenicCollection(Integer userId);
    //查询文化收藏总数
    Integer selectCultureTotal(Integer userId);
    //查询收藏总数
    Integer selectFoodTotal(Integer userId);
   //查询景点收藏总数
    Integer selectScenicTotal(Integer userId);

}
