package com.spring.blog.blogrestapi.web.exceptionHandler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNoHandlerFound(NotFoundException ex, final HttpServletRequest httpServletRequest) {

        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), httpServletRequest.getRequestURI(), ex.getLocalizedMessage()), HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {


        String path = ((ServletWebRequest) request).getRequest().getRequestURI();

        return new ResponseEntity<>(new ErrorResponse(status, ex.getLocalizedMessage(), path, ex.getMessage()), status);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {


        String path = ((ServletWebRequest) request).getRequest().getRequestURI();

        return new ResponseEntity<>(new ErrorResponse(status, ex.getLocalizedMessage(), path, ex.getMessage()), status);

    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        String path = ((ServletWebRequest) request).getRequest().getRequestURI();

        return new ResponseEntity<>(new ErrorResponse(status, errorList, path, ex.getMessage()), status);
    }


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();

        return new ResponseEntity<>(new ErrorResponse(status, ex.getLocalizedMessage(), path, ex.getMessage()), status);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleRecordNotFound(EmptyResultDataAccessException ex,final HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), httpServletRequest.getRequestURI(), ex.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(DataIntegrityViolationException ex,final HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, Objects.requireNonNull(ex.getRootCause()).getMessage(), httpServletRequest.getRequestURI(), ex.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }
}
