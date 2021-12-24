package com.spring.blog.blogrestapi.repository;

import com.spring.blog.blogrestapi.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
