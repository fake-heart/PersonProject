package com.example.hometown.admin.adminEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userPage {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String username;
    private Integer userStatus;

}
