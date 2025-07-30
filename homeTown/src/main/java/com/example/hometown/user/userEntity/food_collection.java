package com.example.hometown.user.userEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class food_collection {
    private Integer id;
    private Integer userId;
    private String name;
    private String description;
    private String ingredients;
    private String originLocation;//产地
    private Long foodTotal;
    private Integer cuisineId;
    private LocalDate createTime;
    private LocalDate updateTime;
}
