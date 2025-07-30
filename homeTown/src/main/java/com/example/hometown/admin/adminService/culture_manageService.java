package com.example.hometown.admin.adminService;

import com.example.hometown.admin.adminEntity.culture;
import com.example.hometown.admin.adminEntity.culturePage;
import com.example.hometown.admin.adminEntity.culturePageResult;

public interface culture_manageService {
    //  分页查询文化活动
    culturePageResult<culture> page(culturePage culturePage);
    //根据id查询文化活动
    culture getById(Integer id);
    // 修改文化活动
    void update(culture culture);
   // 添加文化活动
    void add(culture culture);
   //  删除文化活动
    void delete(Integer id);
}
