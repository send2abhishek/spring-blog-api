package com.spring.blog.blogrestapi.service;

import com.spring.blog.blogrestapi.domain.Blog;
import com.spring.blog.blogrestapi.repository.BlogRepository;
import com.spring.blog.blogrestapi.repository.projection.BlogWithUser;
import com.spring.blog.blogrestapi.repository.projection.CustomBlogFields;
import com.spring.blog.blogrestapi.web.exceptionHandler.NotFoundException;
import com.spring.blog.blogrestapi.web.mapper.BlogMapper;
import com.spring.blog.blogrestapi.web.model.BlogDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    public BlogServiceImpl(BlogRepository blogRepository, BlogMapper blogMapper) {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
    }

    @Override
    public List<BlogWithUser> findALlTasks() {
        return blogRepository.findAllProjectedBy();
    }

    @Override
    public List<CustomBlogFields> findAllTasksByUserId(Long userId) {
        return blogRepository.findByUser_Id(userId);
    }

    @Override
    public Optional<Blog> findTaskById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog saveBlog(BlogDto blogDto) {
        return blogRepository.save(blogMapper.blogDtoToBlog(blogDto));
    }

    @Override
    public BlogDto updateBlog(BlogDto blogDto, Long blogId) {
        Blog foundBlog = blogRepository.findById(blogId).orElseThrow(() -> new NotFoundException("blog not found with given task id"));

        if (foundBlog != null) {
            foundBlog.setTitle(blogDto.getTitle());
            foundBlog.setPost(blogDto.getPost());
            blogRepository.save(foundBlog);
        }

        return blogDto;
    }

    @Override
    public void deleteBlog(Long blogId) {
        blogRepository.deleteById(blogId);
    }
}
