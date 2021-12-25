package com.spring.blog.blogrestapi.repository;

import com.spring.blog.blogrestapi.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
