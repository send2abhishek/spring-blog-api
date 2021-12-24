package com.spring.blog.blogrestapi.repository;

import com.spring.blog.blogrestapi.domain.Category;
import com.spring.blog.blogrestapi.repository.projection.CustomCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

     CustomCategory findByCategoryName(String categoryName);


}
