package com.example.hometown.admin.adminService;

import com.example.hometown.admin.adminEntity.newUser;
import com.example.hometown.admin.adminEntity.userPage;
import com.example.hometown.admin.adminEntity.userPageResult;

public interface userPageService {
    //分页查询用户
    userPageResult<newUser> page(userPage userPage);
   //  根据id查询用户
    newUser getById(Integer id);
   // 修改用户
    void update(newUser newUser);
   //  添加用户
    void addUser(newUser newUser);
   //注销用户
    void deleteUser(Integer id);
}
