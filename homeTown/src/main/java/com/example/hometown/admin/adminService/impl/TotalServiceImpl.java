package com.example.hometown.admin.adminService.impl;

import com.example.hometown.admin.adminEntity.Total;
import com.example.hometown.admin.adminMapper.adminTotal;
import com.example.hometown.admin.adminService.TotalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TotalServiceImpl implements TotalService {
    @Autowired
    private adminTotal adminTotal;

    @Override
    // 获取总数
    public Total getTotal() {
        Total total = new Total();
        total.setScenicNum(adminTotal.selectScenicTotal());
        total.setUserNum(adminTotal.selectUserTotal());
        total.setOrderNum(adminTotal.selectCuisineTotal());
        total.setCultureNum(adminTotal.selectCultureTotal());
        return total;
    }




}
