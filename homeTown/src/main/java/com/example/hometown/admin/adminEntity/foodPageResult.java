package com.example.hometown.admin.adminEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class foodPageResult<food> {
    private Long total;
    private List<food> records;
}
