package com.mirac.upload.controller;

import com.mirac.upload.service.UploadService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Configuration
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;
    @RequestMapping("image")
    public ResponseEntity<String> imgUpload(@RequestParam("file") MultipartFile file){
        String url = this.uploadService.upload(file);
        if(StringUtils.isBlank(url)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(url);
    }
}
