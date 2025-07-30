package com.example.hometown.admin.adminEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class foodPage {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private String ingredients;//食材
    private String originLocation;//产地
}
