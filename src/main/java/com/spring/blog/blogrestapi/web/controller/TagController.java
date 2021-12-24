package com.spring.blog.blogrestapi.web.controller;

import com.spring.blog.blogrestapi.domain.Tag;
import com.spring.blog.blogrestapi.service.TagService;
import com.spring.blog.blogrestapi.web.model.TagDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags() {
        return new ResponseEntity<>(tagService.findALlTags(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tag> saveTag(@RequestBody @Valid TagDto tagDto) {
        return new ResponseEntity<>(tagService.saveTag(tagDto), HttpStatus.OK);
    }


}
