package com.example.hometown.admin.adminService.impl;

import com.example.hometown.admin.adminEntity.scenic;
import com.example.hometown.admin.adminEntity.scenicPage;
import com.example.hometown.admin.adminEntity.scenicPageResult;
import com.example.hometown.admin.adminMapper.scenic_manageMapper;
import com.example.hometown.admin.adminService.scenic_mangeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class scenic_mangeServiceImpl implements scenic_mangeService {
    @Autowired
    private scenic_manageMapper scenicManageMapper;
    //分页查询景点
    @Override
    public scenicPageResult<scenic> page(scenicPage scenicPage) {
        PageHelper.startPage(scenicPage.getPage(), scenicPage.getPageSize());
        List<scenic> scenicList = scenicManageMapper.page(scenicPage);
        Page<scenic> page = (Page<scenic>) scenicList;
        return new scenicPageResult<>(page.getTotal(), page.getResult());


    }
   //根据id查询景点
    @Override
    public scenic getById(Integer id) {
        return scenicManageMapper.getById(id);
    }
   //修改景点
    @Override
    public void update(scenic scenic) {

        scenic.setUpdateTime(LocalDate.now());
        scenicManageMapper.update(scenic);
    }
     //添加景点
    @Override
    public void add(scenic scenic) {
        scenic.setCreateTime(LocalDate.now());
        scenic.setUpdateTime(LocalDate.now());
        scenicManageMapper.add(scenic);


    }
    //根据id删除景点
    @Override
    public void delete(Integer id) {
        scenicManageMapper.delete(id);

    }

}
