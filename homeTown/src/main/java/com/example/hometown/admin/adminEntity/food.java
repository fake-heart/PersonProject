package com.example.hometown.admin.adminEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 美食实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class food {
    private Integer id;
    private String name;
    private String description;
    private String ingredients;//食材
    private String cookingMethod;//烹饪方法
    private String originLocation;//产地
    private String recommendedRestaurant;//推荐餐厅
    private Integer  main_image_id;//主图id
    private String image;//图片地址
    private Integer createBy;//创建者id
    private LocalDate createTime;
    private LocalDate updateTime;


}
