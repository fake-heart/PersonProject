package com.example.hometown.user.userEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 景点实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userScenic {
    private Integer id;
    private String name;
    private String  image;//图片
    private String description;
    private String location;
    private String opening_hours;//开放时间
    private double ticketPrice;//门票价格
    private double rating;//评分
    private Integer viewCount;//评论数
    private Integer main_image_id;//主图id
    private Integer createBy;//创建者id
    private LocalDate createTime;
    private LocalDate updateTime;

}
