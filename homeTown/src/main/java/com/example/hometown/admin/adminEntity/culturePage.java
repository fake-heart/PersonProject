package com.example.hometown.admin.adminEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class culturePage {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginTime;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTime;//结束时间

}
