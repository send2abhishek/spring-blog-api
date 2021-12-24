package com.spring.blog.blogrestapi.service;

import com.spring.blog.blogrestapi.domain.Category;
import com.spring.blog.blogrestapi.domain.User;
import com.spring.blog.blogrestapi.repository.CategoryRepository;
import com.spring.blog.blogrestapi.repository.projection.CustomCategory;
import com.spring.blog.blogrestapi.web.mapper.CategoryMapper;
import com.spring.blog.blogrestapi.web.model.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }


    @Override
    public Category saveCategory(CategoryDto categoryDto) {
        return categoryRepository.save(Category.builder().categoryName(categoryDto.getCategoryName())
                .user(User.builder().id(categoryDto.getUserId()).build()).build());
    }

    @Override
    public CustomCategory findCategoryByName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
}
