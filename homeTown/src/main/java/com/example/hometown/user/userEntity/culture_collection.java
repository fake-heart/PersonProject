package com.example.hometown.user.userEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class culture_collection {
    private Integer id;
    private String name;
    private Integer userId;
    private Integer cultureId;
    private String description;
    private String history;//历史渊源
    private Long cultureTotal;//收藏数
    private LocalDate createTime;
    private LocalDate updateTime;
}
