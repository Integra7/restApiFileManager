package com.example.restapifilemanager.controllers;
import com.example.restapifilemanager.model.UserModel;
import com.example.restapifilemanager.model.fileModel;
import com.example.restapifilemanager.repo.fileModelRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.text.DecimalFormat;
import java.io.File;
import java.io.IOException;

@Controller
@SessionAttributes("user")
public class fileController {
    @Autowired
    private fileModelRepo fileModelRepo;

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException{
        UserModel user = (UserModel) model.getAttribute("user");
        if (!file.isEmpty())  {
            try {
                String fileCode = RandomStringUtils.randomAlphanumeric(10);
                String uploadDir = "D:\\restApiFileManager\\src\\main\\resources\\static\\files-upload";
                File uploadDirFile = new File(uploadDir);

                if (!uploadDirFile.exists()) {
                    uploadDirFile.mkdirs();
                }

                String fileName = file.getOriginalFilename();
                String filePath = uploadDir + File.separator +fileCode +fileName;

                file.transferTo(new File(filePath));


                Double sizeD = (double)file.getSize()/1024/1024;
                final DecimalFormat decfor = new DecimalFormat("0.00");
                String size = String.valueOf(decfor.format(sizeD)) + "MB";

                fileModel fileModel = new fileModel(size,fileName);
                fileModel.setUri(fileCode);
                if(user!=null)
                {
                    fileModel.setUser(user);
                }
                fileModelRepo.save(fileModel);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/home";
    }
}

