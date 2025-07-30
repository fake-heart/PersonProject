package com.example.hometown.admin.adminEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 文化活动实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class culture {
    private Integer id;
    private String name;
    private String description;
    private String history;//历史渊源
    private String relatedHoliday;//相关节日
    private Integer main_image_id;//主图id
    private String image;
    private Integer createBy;//创建者id
    private LocalDate createTime;//创建时间
    private LocalDate updateTime;//修改时间
}
