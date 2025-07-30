package com.example.hometown.user.userService.impl;

import com.example.hometown.admin.adminEntity.culture;
import com.example.hometown.admin.adminEntity.food;
import com.example.hometown.admin.adminEntity.scenic;
import com.example.hometown.user.Mapper.userMapper;
import com.example.hometown.user.userEntity.culture_collection;
import com.example.hometown.user.userEntity.food_collection;
import com.example.hometown.user.userEntity.scenic_collection;
import com.example.hometown.user.userEntity.user;
import com.example.hometown.user.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private userMapper userMapper;
    //查询前三个景点
    @Override
    public List<scenic> getScenic() {
        List<scenic> scenic = userMapper.getScenic();
        return scenic;

    }
    //查询前三个美食
    @Override
    public List<food> getFood() {
        List<food> food = userMapper.getFood();
        return food;


    }
    //查询所有景点
    @Override
    public List<scenic> SelectAllScenic() {
        List<scenic> scenic = userMapper.SelectAllScenic();
        return scenic;

    }
   //查询所有美食
    @Override
    public List<food> SelectAllFood() {
        List<food> food = userMapper.SelectAllFood();
        return food;

    }
    //查询所有文化
    @Override
    public List<culture> SelectAllCulture() {
        List<culture> culture = userMapper.SelectAllCulture();
        return culture;

    }
   //根据文化名称搜索文化
    @Override
    public List<culture> searchCulture(String name) {
        List<culture> culture = userMapper.searchCulture(name);
        return culture;

    }
    //根据美食名称搜索美食
    @Override
    public List<food> SelectFoodByName(String name) {
        List<food> food = userMapper.SelectFoodByName(name);
        return food;

    }
    //根据景点名称搜索景点
    @Override
    public List<scenic> selectScenicByName(String name) {
        List<scenic> scenic = userMapper.selectScenicByName(name);
        return scenic;
    }
    //根据用户名查询用户
    @Override
    public user findByUsername(String username) {
        user user = userMapper.findByUsername(username);
        return user;

    }
   //修改用户信息
    @Override
    public void updateUser(user loginUser) {
        loginUser.setUpdateTime(LocalDate.now());
        userMapper.updateUserInfo(loginUser);


    }
   //添加文化收藏
    @Override
    public void addCollect(Integer userId, Integer cultureId, String name) {
        culture_collection collection  = new culture_collection();
        LocalDate createTime = LocalDate.now();
        collection.setCreateTime(createTime);
        LocalDate updateTime = LocalDate.now();
        collection.setUpdateTime(updateTime);

        userMapper.addCollect(userId,cultureId,name,createTime,updateTime);
    }
    //展示文化收藏
    @Override
    public List<culture_collection> showCultureCollection(Integer userId ) {
        List<culture_collection> culture_collection = userMapper.showCultureCollection(userId);
        return culture_collection;

    }
    //添加美食收藏
    @Override
    public void addFoodCollect(Integer userId, Integer cuisineId, String name) {
        food_collection collection  = new food_collection();
        LocalDate createTime = LocalDate.now();
        collection.setCreateTime(createTime);
        LocalDate updateTime = LocalDate.now();
        collection.setUpdateTime(updateTime);
        userMapper.addFoodCollect(userId,cuisineId,name,createTime,updateTime);


    }
   //添加景点收藏
    @Override
    public void addScenicCollect(Integer userId, Integer scenicId, String name) {
        scenic_collection collection  = new scenic_collection();
        LocalDate createTime = LocalDate.now();
        collection.setCreateTime(createTime);
        LocalDate updateTime = LocalDate.now();
        collection.setUpdateTime(updateTime);
        userMapper.addScenicCollect(userId,scenicId,name,createTime,updateTime);

    }
   //展示美食收藏
    @Override
    public List<food_collection> showFoodCollection( Integer userId) {
        List<food_collection> food_collection = userMapper.showFoodCollection(userId);
        return food_collection;

    }
   //展示景点收藏
    @Override
    public List<scenic_collection> showScenicCollection(Integer userId) {
        List<scenic_collection> scenic_collection = userMapper.showScenicCollection(userId);
        return scenic_collection;

    }
   //查询文化收藏总数
    @Override
    public Integer selectCultureTotal(Integer userId) {
        return userMapper.selectCultureTotal(userId);
    }
   //查询美食收藏总数
    @Override
    public Integer selectFoodTotal(Integer userId) {
        return userMapper.selectFoodTotal(userId);
    }
   //查询景点收藏总数
    @Override
    public Integer selectScenicTotal(Integer userId) {
       return userMapper.selectScenicTotal(userId);
    }



}
