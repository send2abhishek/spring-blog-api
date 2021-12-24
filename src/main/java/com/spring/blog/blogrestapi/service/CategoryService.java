package com.spring.blog.blogrestapi.service;

import com.spring.blog.blogrestapi.domain.Category;
import com.spring.blog.blogrestapi.repository.projection.CustomCategory;
import com.spring.blog.blogrestapi.web.model.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategory();

    Category saveCategory(CategoryDto categoryDto);

    CustomCategory findCategoryByName(String categoryName);
}
