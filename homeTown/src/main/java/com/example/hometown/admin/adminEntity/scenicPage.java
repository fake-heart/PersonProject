package com.example.hometown.admin.adminEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class scenicPage {
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数
    private String name; //景点名称
    private String  description;//描述
    private String location;//位置
}
