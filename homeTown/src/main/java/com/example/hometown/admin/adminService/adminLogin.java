package com.example.hometown.admin.adminService;

import com.example.hometown.admin.adminEntity.admin;

import java.util.List;

public interface adminLogin {
    // 登录
   List<admin> selectAdmin(String username, String password);
}
