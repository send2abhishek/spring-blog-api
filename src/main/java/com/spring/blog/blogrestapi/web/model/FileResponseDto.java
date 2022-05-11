package com.spring.blog.blogrestapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileResponseDto {

    private String fileName;
    private String fileUrl;
    private String message;
}
