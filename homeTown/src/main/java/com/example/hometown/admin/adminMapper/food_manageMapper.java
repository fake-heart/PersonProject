package com.example.hometown.admin.adminMapper;

import com.example.hometown.admin.adminEntity.food;
import com.example.hometown.admin.adminEntity.foodPage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface food_manageMapper {
    //分页查询美食
    List<food> page(foodPage foodPage);
    //根据id查询美食
    food getById(Integer id);
   //  更新美食
    void update(food food);
   // 添加美食
    void add(food food);
   //根据id删除美食
    @Delete("delete from cuisine where id = #{id}")
    void delete(Integer id);
}
