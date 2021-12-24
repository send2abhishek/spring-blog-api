package com.spring.blog.blogrestapi.web.mapper;

import com.spring.blog.blogrestapi.domain.Tag;
import com.spring.blog.blogrestapi.web.model.TagDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TagMapper {

    @Mapping(target = "user.id", source = "userId")
    Tag tagDtoToTag(TagDto tagDto);
}
