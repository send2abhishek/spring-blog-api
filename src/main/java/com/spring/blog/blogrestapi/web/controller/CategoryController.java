package com.spring.blog.blogrestapi.web.controller;

import com.spring.blog.blogrestapi.domain.Category;
import com.spring.blog.blogrestapi.repository.projection.CustomCategory;
import com.spring.blog.blogrestapi.service.CategoryService;
import com.spring.blog.blogrestapi.web.model.CategoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAllCategory(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody @Valid CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.saveCategory(categoryDto), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CustomCategory> getCategoryByName(@PathVariable String name) {
        return new ResponseEntity<>(categoryService.findCategoryByName(name), HttpStatus.OK);
    }

}
