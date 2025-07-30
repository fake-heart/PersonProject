package com.example.hometown.admin.adminEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class scenicPageResult<scenic>{
    private Long total;
    private List<scenic> records;
}
