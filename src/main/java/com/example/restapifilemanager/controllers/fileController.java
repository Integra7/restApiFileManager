package com.example.restapifilemanager.controllers;

import com.example.restapifilemanager.model.fileModel;
import com.example.restapifilemanager.repo.fileModelRepo;
import com.example.restapifilemanager.model.fileUploadModel;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.text.DecimalFormat;

import java.io.IOException;
import java.util.Objects;

@RestController
public class fileController
{
    @Autowired
    private fileModelRepo fileModelRepo;

    @PostMapping("/upload")
public ResponseEntity<?>uploadFile(@RequestParam ("file")MultipartFile multipartFile, Model model) throws IOException
    {
        final DecimalFormat decfor = new DecimalFormat("0.00");
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        Double sizeD = (double)multipartFile.getSize()/1024/1024;

        String size = String.valueOf(decfor.format(sizeD)) + "MB";
        String fileCode = fileUploadModel.saveFile(fileName, multipartFile);


        fileModel fileModel = new fileModel(size,fileName);
        fileModel.setUri(fileCode);
        fileModelRepo.save(fileModel);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));
        return new ResponseEntity<>(headers,HttpStatus.MOVED_PERMANENTLY);

        /*uploadResponseModel response = new uploadResponseModel();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/dl/" + fileModel.getId());
        */
        //return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

