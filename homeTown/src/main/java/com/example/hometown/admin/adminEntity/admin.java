package com.example.hometown.admin.adminEntity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * 管理员表
 */

@Data

public class admin {
    private BigInteger id;//管理员id
    private String username;//管理员用户名
    private String password;//密码
    private  enum role{
       super_admin,
        user_admin,
        content_admin,
    }
    private role role;//角色
    private LocalDateTime  createTime;//创建时间
    private LocalDateTime  updateTime;//更新时间

    public admin() {
    }
    public admin(BigInteger id, String username, String password, role role, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
