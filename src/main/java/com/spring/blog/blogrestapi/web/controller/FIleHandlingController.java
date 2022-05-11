package com.spring.blog.blogrestapi.web.controller;

import com.spring.blog.blogrestapi.service.IFileSystemStorage;
import com.spring.blog.blogrestapi.web.model.FileResponseDto;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
public class FIleHandlingController {

    private final IFileSystemStorage fileSystemStorage;


    public FIleHandlingController(IFileSystemStorage fileSystemStorage) {
        this.fileSystemStorage = fileSystemStorage;
    }

    @PostMapping("/upload")
    public ResponseEntity<FileResponseDto> uploadFile(@RequestParam("file") MultipartFile file){
        String upfile = fileSystemStorage.saveFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/file/download/")
                .path(upfile)
                .toUriString();

        return ResponseEntity.status(HttpStatus.OK).body(new FileResponseDto(upfile,fileDownloadUri,"File uploaded with success!"));
    }

    @PostMapping("/uploadfiles")
    public ResponseEntity<List<FileResponseDto>> uploadMultipleFiles (@RequestParam("files") MultipartFile[] files) {

        List<FileResponseDto> responses = Arrays
                .asList(files)
                .stream()
                .map(
                        file -> {
                            String upfile = fileSystemStorage.saveFile(file);
                            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                                    .path("/file/download/")
                                    .path(upfile)
                                    .toUriString();
                            return new FileResponseDto(upfile,fileDownloadUri,"File uploaded with success!");
                        }
                )
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        Resource resource = fileSystemStorage.loadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
