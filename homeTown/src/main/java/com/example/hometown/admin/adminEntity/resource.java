package com.example.hometown.admin.adminEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 资源实体类
 */

@NoArgsConstructor
@Data
@AllArgsConstructor
public class resource {
    private  Integer id;
    private  String fileName;//文件名
    private  String filePath;//文件路径
    private  String fileType;//文件类型
    private  Integer uploadBy;//上传者
    private LocalDateTime uploadTime;//上传时间
    private  enum resourceType{
        image,
        video,
        audio,
        document
    };
    private  resourceType resourceType;//资源类型

}
