package com.example.hometown.admin.adminService;

import com.example.hometown.admin.adminEntity.scenic;
import com.example.hometown.admin.adminEntity.scenicPage;
import com.example.hometown.admin.adminEntity.scenicPageResult;

public interface scenic_mangeService {
    // 分页查询景点
    scenicPageResult<scenic> page(scenicPage scenicPage);
    // 根据id查询景点
    scenic getById(Integer id);
    // 修改景点
    void update(scenic scenic);
   //  添加景点
    void add(scenic scenic);
   //  根据id删除景点
    void delete(Integer id);
}
