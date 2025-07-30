package com.example.hometown.admin.adminService.impl;

import com.example.hometown.admin.adminEntity.culture;
import com.example.hometown.admin.adminEntity.culturePage;
import com.example.hometown.admin.adminEntity.culturePageResult;
import com.example.hometown.admin.adminMapper.culture_manageMapper;
import com.example.hometown.admin.adminService.culture_manageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class culture_manageServiceImpl implements culture_manageService {
    @Autowired
    private culture_manageMapper culture_manageMapper;
    //分页查询文化活动
    @Override
    public culturePageResult<culture> page(culturePage culturePage) {
        PageHelper.startPage(culturePage.getPage(), culturePage.getPageSize());
        List<culture> cultureList = culture_manageMapper.page(culturePage);
        Page<culture> page = (Page<culture>) cultureList;
        return new culturePageResult<>(page.getTotal(), page.getResult());

    }

    @Override
    public culture getById(Integer id) {
        return culture_manageMapper.getById(id);
    }

    //修改文化活动
    @Override
    public void update(culture culture) {
        culture.setUpdateTime(LocalDate.now());//更新修改时间
        culture_manageMapper.update(culture);

    }
    //添加文化活动
    @Override
    public void add(culture culture) {
        culture.setCreateTime(LocalDate.now());
        culture.setUpdateTime(LocalDate.now());
        culture_manageMapper.add(culture);

    }
   // 删除文化活动
    @Override
    public void delete(Integer id) {
        culture_manageMapper.delete(id);

    }
}
