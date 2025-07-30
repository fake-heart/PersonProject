package com.example.hometown.admin.adminService.impl;

import com.example.hometown.admin.adminEntity.newUser;
import com.example.hometown.admin.adminEntity.userPage;
import com.example.hometown.admin.adminEntity.userPageResult;
import com.example.hometown.admin.adminMapper.userPageMapper;
import com.example.hometown.admin.adminService.userPageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class userPageServiceImpl implements userPageService {
    @Autowired
    private userPageMapper userPageMapper;
    @Override
    public userPageResult<newUser> page(userPage userPage) {
        PageHelper.startPage(userPage.getPage(), userPage.getPageSize());
        List<newUser> newUserList = userPageMapper.page(userPage);
        Page<newUser> page = (Page<newUser>) newUserList;
        return new userPageResult<>(page.getTotal(), page.getResult());


    }

    @Override
    public newUser getById(Integer id) {
        return userPageMapper.getById(id);
    }
    //更新用户信息

    @Override
    public void update(newUser newUser) {
        newUser.setUpdateTime(LocalDate.now());
        userPageMapper.update(newUser);


    }
    //添加用户

    @Override
    public void addUser(newUser newUser) {
        newUser.setCreateTime(LocalDate.now());
        newUser.setUpdateTime(LocalDate.now());
        userPageMapper.addUser(newUser);

    }
   //注销用户
    @Override
    public void deleteUser(Integer id) {
        userPageMapper.deleteUser(id);

    }
}
