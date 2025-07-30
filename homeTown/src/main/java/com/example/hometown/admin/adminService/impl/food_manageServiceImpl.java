package com.example.hometown.admin.adminService.impl;

import com.example.hometown.admin.adminEntity.food;
import com.example.hometown.admin.adminEntity.foodPage;
import com.example.hometown.admin.adminEntity.foodPageResult;
import com.example.hometown.admin.adminMapper.food_manageMapper;
import com.example.hometown.admin.adminService.food_manageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class food_manageServiceImpl implements food_manageService {
    @Autowired
    private food_manageMapper food_manageMapper;
    // 分页查询食物
    @Override
    public foodPageResult<food> page(foodPage foodPage) {
        PageHelper.startPage(foodPage.getPage(), foodPage.getPageSize());
        List<food> foodList = food_manageMapper.page(foodPage);
        Page<food> page = (Page<food>) foodList;
        return new foodPageResult<>(page.getTotal(), page.getResult());

    }
    //  根据id查询
    @Override
    public food getById(Integer id) {
     food food =   food_manageMapper.getById(id);
        return food;

    }
    //修改美食
    @Override
    public void update(food food) {
        food.setUpdateTime(LocalDate.now());
        food_manageMapper.update(food);
    }
    //新增美食
    @Override
    public void add(food food) {
        food.setCreateTime(LocalDate.now());
        food.setUpdateTime(LocalDate.now());
        food_manageMapper.add(food);

    }
   //根据id删除美食
    @Override
    public void delete(Integer id) {
        food_manageMapper.delete(id);

    }
}
