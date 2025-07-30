package com.example.hometown.admin.adminService;

import com.example.hometown.admin.adminEntity.food;
import com.example.hometown.admin.adminEntity.foodPage;
import com.example.hometown.admin.adminEntity.foodPageResult;

public interface food_manageService {
    // 分页查询美食
    foodPageResult<food> page(foodPage foodPage);
   // 根据id查询美食
    food getById(Integer id);
   //  更新美食
    void update(food food);
   //新增美食
    void add(food food);
  //根据id删除美食
    void delete(Integer id);
}
