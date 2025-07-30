package com.example.hometown.admin.adminService.impl;

import com.example.hometown.admin.adminEntity.admin;


import com.example.hometown.admin.adminMapper.adminMapper;
import com.example.hometown.admin.adminService.adminLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminLoginImpl implements adminLogin {
    @Autowired
    private adminMapper login;
    //登录
    @Override
    public List<admin> selectAdmin(String username, String password) {

       List<admin> adminList=   login.selectAdmin(username, password);

        return adminList;

    }
}
