package com.spring.blog.blogrestapi.service.impl;

import com.spring.blog.blogrestapi.domain.Tag;
import com.spring.blog.blogrestapi.repository.TagRepository;
import com.spring.blog.blogrestapi.service.TagService;
import com.spring.blog.blogrestapi.web.mapper.TagMapper;
import com.spring.blog.blogrestapi.web.model.TagDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public TagServiceImpl(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    @Override
    public List<Tag> findALlTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag saveTag(TagDto tagDto) {
        tagDto.setTagName("#"+tagDto.getTagName());
        return tagRepository.save(tagMapper.tagDtoToTag(tagDto));
    }
}
