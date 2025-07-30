package com.example.hometown.admin.adminMapper;

import com.example.hometown.admin.adminEntity.scenic;
import com.example.hometown.admin.adminEntity.scenicPage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface scenic_manageMapper {
    // 分页查询景点
    List<scenic> page(scenicPage scenicPage);
    // 根据id查询景点
    scenic getById(Integer id);
    // 更新景点
    void update(scenic scenic);
    // 添加景点
    void add(scenic scenic);
    //根据id删除景点
    @Delete("delete from scenic_spot where id = #{id}")
    void delete(Integer id);
}
