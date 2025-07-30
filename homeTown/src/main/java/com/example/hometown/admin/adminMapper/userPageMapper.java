package com.example.hometown.admin.adminMapper;

import com.example.hometown.admin.adminEntity.newUser;
import com.example.hometown.admin.adminEntity.userPage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userPageMapper {
    //  分页查询用户
    List<newUser> page(userPage userPage);
    //  根据id查询用户
    newUser getById(Integer id);
    //  更新用户

    void update(newUser newUser);
    //  添加用户
    void addUser(newUser newUser);
   //  注销用户
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);
}
