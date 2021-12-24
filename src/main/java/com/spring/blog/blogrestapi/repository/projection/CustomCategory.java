package com.spring.blog.blogrestapi.repository.projection;

public interface CustomCategory {

    String getCategoryName();

    UserD getUser();

    interface UserD{
        Long getId();
        String getEmail();
        String getUserName();

    }
}
