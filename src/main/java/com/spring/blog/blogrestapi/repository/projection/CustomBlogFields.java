package com.spring.blog.blogrestapi.repository.projection;

import java.sql.Timestamp;
import java.util.Set;

public interface CustomBlogFields {

    Long getId();

    String getTitle();

    String getPost();

    Set<Category> getCategories();
    Set<Tag> getTagSet();

    Timestamp getLastModifiedDate();

    interface Category {
        Long getId();
        String getCategoryName();

    }

    interface Tag{
        Long getId();
        String getTagName();
    }
}
