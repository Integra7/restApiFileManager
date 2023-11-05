package com.example.restapifilemanager.controllers;

import com.example.restapifilemanager.model.UserModel;
import com.example.restapifilemanager.model.fileModel;
import com.example.restapifilemanager.repo.fileModelRepo;
import com.example.restapifilemanager.model.fileUploadModel;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.text.DecimalFormat;

import java.io.IOException;
import java.util.Objects;

@Controller
@SessionAttributes("user")
public class fileController
{
    @Autowired
    private fileModelRepo fileModelRepo;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam ("file")MultipartFile multipartFile, Model model) throws IOException
    {

        UserModel user = (UserModel) model.getAttribute("user");
        final DecimalFormat decfor = new DecimalFormat("0.00");
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        Double sizeD = (double)multipartFile.getSize()/1024/1024;

        String size = String.valueOf(decfor.format(sizeD)) + "MB";
        String fileCode = fileUploadModel.saveFile(fileName, multipartFile);


        fileModel fileModel = new fileModel(size,fileName);
        fileModel.setUri(fileCode);
        if(user!=null)
        {
            fileModel.setUser(user);
        }
        fileModelRepo.save(fileModel);

        return "redirect:/home";


    }
}
