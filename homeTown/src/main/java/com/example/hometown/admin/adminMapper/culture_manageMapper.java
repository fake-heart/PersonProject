package com.example.hometown.admin.adminMapper;

import com.example.hometown.admin.adminEntity.culture;
import com.example.hometown.admin.adminEntity.culturePage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface culture_manageMapper {
    //分页查询活动
    List<culture> page(culturePage culturePage);
   //  根据id查询活动
    culture getById(Integer id);
   //  更新文化活动
    void update(culture culture);
    //  添加文化活动
    void add(culture culture);
    //  删除文化活动
    @Delete("delete from cultural_feature where id = #{id}")
    void delete(Integer id);
}
