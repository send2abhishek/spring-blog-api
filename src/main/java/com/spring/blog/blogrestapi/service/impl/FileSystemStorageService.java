package com.spring.blog.blogrestapi.service.impl;

import com.spring.blog.blogrestapi.configuration.FilePropertyConfiguration;
import com.spring.blog.blogrestapi.service.IFileSystemStorage;
import com.spring.blog.blogrestapi.web.exceptionHandler.FileNotFoundException;
import com.spring.blog.blogrestapi.web.exceptionHandler.FileStorageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Service
public class FileSystemStorageService implements IFileSystemStorage {

    private Path fileLocation;

    public FileSystemStorageService(FilePropertyConfiguration filePropertyConfiguration) {

        this.fileLocation = Paths.get(filePropertyConfiguration.getLocation()).toAbsolutePath().normalize();
    }

    @Override
    @PostConstruct
    public void init() {
        log.info("this is called after the bean initialization");
        try {
            System.out.println("fileLocation"+fileLocation);
            Files.createDirectories(this.fileLocation);
        } catch (Exception ex) {

            throw new FileStorageException("Could not create upload dir!"+ex.getMessage());
        }
    }

    @Override
    public String saveFile(MultipartFile file) {

        try {
            String fileName = file.getOriginalFilename();
            Path dfile = this.fileLocation.resolve(fileName);
            Files.copy(file.getInputStream(), dfile, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            throw new FileStorageException("Could not upload file");
        }

    }

    @Override
    public Resource loadFile(String fileName) {
        try {
            Path file = this.fileLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("Could not find file");
            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("Could not download file");
        }
    }
}
