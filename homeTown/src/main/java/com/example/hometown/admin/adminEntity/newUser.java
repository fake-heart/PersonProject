package com.example.hometown.admin.adminEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class newUser {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    //头像
    private String avatarUrl;
    //用户状态 1正常 2封禁，3注销
    private Integer userStatus;
    private LocalDate createTime;
    private LocalDate updateTime;
}
