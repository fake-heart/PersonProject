package com.example.hometown.admin.adminService;

import com.example.hometown.admin.adminEntity.culture;
import com.example.hometown.admin.adminEntity.food;
import com.example.hometown.admin.adminEntity.newUser;
import com.example.hometown.admin.adminEntity.scenic;

public interface indexSelectService {
   //  查询新用户
    newUser selectNewUser();
   //  查询新景点
    scenic selectNewScenic();
    //查询新美食
    food selectNewFood();
    //查询新文化活动
    culture selectNewCulture();


}
