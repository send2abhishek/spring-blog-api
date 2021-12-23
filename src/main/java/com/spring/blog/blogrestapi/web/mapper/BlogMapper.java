package com.spring.blog.blogrestapi.web.mapper;

import com.spring.blog.blogrestapi.domain.Blog;
import com.spring.blog.blogrestapi.web.model.BlogDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BlogMapper {

    @Mapping(target = "user.id", source = "userId")
    Blog blogDtoToBlog(BlogDto blogDto);
}
