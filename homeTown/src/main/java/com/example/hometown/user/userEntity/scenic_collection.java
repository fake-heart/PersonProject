package com.example.hometown.user.userEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class scenic_collection {
    private Integer id;
    private String name;//景点名
    private Integer userId;//用户id
    private Integer scenicId;//景点id
    private String description;
    private String location;
    private double ticketPrice;//门票价格
    private double rating;//评分
    private Long scenicTotal;
    private LocalDate createTime;
    private LocalDate updateTime;
}
