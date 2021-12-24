package com.spring.blog.blogrestapi.web.mapper;

import com.spring.blog.blogrestapi.domain.Category;
import com.spring.blog.blogrestapi.web.model.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "user.id", source = "userId")
    Category categoryDtoToCategory(CategoryDto categoryDto);
}
