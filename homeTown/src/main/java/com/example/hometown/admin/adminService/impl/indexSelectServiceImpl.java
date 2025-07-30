package com.example.hometown.admin.adminService.impl;

import com.example.hometown.admin.adminEntity.culture;
import com.example.hometown.admin.adminEntity.food;
import com.example.hometown.admin.adminEntity.newUser;
import com.example.hometown.admin.adminEntity.scenic;
import com.example.hometown.admin.adminMapper.indexSelectMapper;
import com.example.hometown.admin.adminService.indexSelectService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class indexSelectServiceImpl implements indexSelectService {
    @Autowired
    private indexSelectMapper indexSelectMapper;
    //新用户
    @Override
    public newUser selectNewUser() {
        newUser newUser = indexSelectMapper.selectNewUser();
        return newUser;


    }
    //新景点
    @Override
    public scenic selectNewScenic() {
        scenic scenic = indexSelectMapper.selectNewScenic();
        return scenic;

    }
    //新美食
    @Override
    public food selectNewFood() {
        food food = indexSelectMapper.selectNewFood();
        return food;

    }
    //新文化活动
    @Override
    public culture selectNewCulture() {
        culture culture = indexSelectMapper.selectNewCulture();
        return culture;
    }
}
