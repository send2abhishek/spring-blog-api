package com.spring.blog.blogrestapi.service;

import com.spring.blog.blogrestapi.domain.Blog;
import com.spring.blog.blogrestapi.repository.projection.CustomBlogFields;
import com.spring.blog.blogrestapi.web.model.BlogDto;
import java.util.List;
import java.util.Optional;

public interface BlogService {

    List<CustomBlogFields> findALlTasks();

    List<CustomBlogFields> findAllTasksByUserId(Long userId);


    Optional<Blog> findTaskById(Long id);

    Blog saveBlog(BlogDto blogDto);

    BlogDto updateBlog(BlogDto blogDto, Long blogId);

    void deleteBlog(Long blogId);
}
