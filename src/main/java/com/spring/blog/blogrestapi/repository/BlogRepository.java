package com.spring.blog.blogrestapi.repository;

import com.spring.blog.blogrestapi.domain.Blog;
import com.spring.blog.blogrestapi.repository.projection.BlogWithUser;
import com.spring.blog.blogrestapi.repository.projection.CustomBlogFields;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {


  List<BlogWithUser> findAllProjectedBy();

  List<CustomBlogFields> findByUser_Id(Long id);



}
