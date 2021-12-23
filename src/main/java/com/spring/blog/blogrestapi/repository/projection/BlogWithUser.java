package com.spring.blog.blogrestapi.repository.projection;

import java.sql.Timestamp;

public interface BlogWithUser {

    Long getId();
    String getTitle();
     String getPost();
    Timestamp getLastModifiedDate();
    User getUser();

    interface User{
        Long getId();
        String getEmail();
        String getUserName();

    }
}
