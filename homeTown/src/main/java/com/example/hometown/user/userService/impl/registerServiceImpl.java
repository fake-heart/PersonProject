package com.example.hometown.user.userService.impl;

import com.example.hometown.user.Mapper.LoginMapper;
import com.example.hometown.user.Mapper.registerMapper;
import com.example.hometown.user.userEntity.user;
import com.example.hometown.user.userService.registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Service
public class registerServiceImpl implements registerService {
    @Autowired
    private registerMapper registerMapper;

    @Override
    public void insertUser(user user) {
        user.setCreateTime(LocalDate.now());
        user.setUpdateTime(LocalDate.now());
        registerMapper.insertUser(user);

    }
}
