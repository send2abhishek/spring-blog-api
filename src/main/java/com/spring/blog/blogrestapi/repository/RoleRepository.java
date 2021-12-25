package com.spring.blog.blogrestapi.repository;

import com.spring.blog.blogrestapi.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
