package com.spring.blog.blogrestapi.service;

import com.spring.blog.blogrestapi.domain.Tag;
import com.spring.blog.blogrestapi.web.model.TagDto;

import java.util.List;

public interface TagService {

    List<Tag> findALlTags();

    Tag saveTag(TagDto tagDto);
}
