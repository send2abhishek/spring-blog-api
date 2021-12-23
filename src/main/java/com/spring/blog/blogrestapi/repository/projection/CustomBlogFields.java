package com.spring.blog.blogrestapi.repository.projection;

import java.sql.Timestamp;

public interface CustomBlogFields {

    Long getId();
    String getTitle();
//    String getDesc();
    Timestamp getLastModifiedDate();

    interface User{
        String getEmail();
        String getUserName();
    }
}
