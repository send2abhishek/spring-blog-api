package com.spring.blog.blogrestapi.web.exceptionHandler;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
        super("something Went Wrong");
    }
}