package com.spring.blog.blogrestapi.web.controller;

import com.spring.blog.blogrestapi.domain.Blog;
import com.spring.blog.blogrestapi.repository.projection.CustomBlogFields;
import com.spring.blog.blogrestapi.service.BlogService;
import com.spring.blog.blogrestapi.web.model.BlogDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/blog/")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("posts")
    public ResponseEntity<List<CustomBlogFields>> getAllTasks() {
        return new ResponseEntity<>(blogService.findALlTasks(), HttpStatus.OK);
    }

    @GetMapping("posts/{userId}")
    public ResponseEntity<List<CustomBlogFields>> getTasks(@PathVariable Long userId) {
        return new ResponseEntity<>(blogService.findAllTasksByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("posts")
    public ResponseEntity<Blog> saveBlogPosts(@Valid @RequestBody BlogDto blogDto) {

        return new ResponseEntity<>(blogService.saveBlog(blogDto), HttpStatus.CREATED);
    }

    @PutMapping("tasks/{blogId}")
    public ResponseEntity<BlogDto> updateTask(@Valid @RequestBody BlogDto blogDto, @PathVariable Long blogId) {
        return new ResponseEntity<>(blogService.updateBlog(blogDto, blogId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("tasks/{blogId}")
    public ResponseEntity<Object> deleteTask(@PathVariable Long blogId) {
        blogService.deleteBlog(blogId);
        HashMap<String, Object> response = new HashMap<>();
        response.put("status", "item deleted");

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
