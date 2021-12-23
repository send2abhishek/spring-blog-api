package com.spring.blog.blogrestapi.repository;

import com.spring.blog.blogrestapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
