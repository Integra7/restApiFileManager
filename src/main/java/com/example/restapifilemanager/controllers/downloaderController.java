package com.example.restapifilemanager.controllers;

import com.example.restapifilemanager.model.fileDownloadModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class downloaderController
{
@GetMapping("/dl/{fileCode}")
    public ResponseEntity<?> dlFile(@PathVariable("fileCode") String fileCode)
{
    fileDownloadModel downloadUtil = new fileDownloadModel();
    Resource resource = null;
    try {
        resource = downloadUtil.getFileAsResource(fileCode);
    } catch (IOException e) {
        return ResponseEntity.internalServerError().build();
    }

    if (resource == null) {
        return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
    }

    String contentType = "application/octet-stream";
    String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

    return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
            .body(resource);
}
}

