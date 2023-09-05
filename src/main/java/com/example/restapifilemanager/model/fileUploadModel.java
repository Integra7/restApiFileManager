package com.example.restapifilemanager.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class fileUploadModel
{
    public static String saveFile(String fileName, MultipartFile multipartFile) throws IOException
    {
        Path uploadPath = Paths.get("src/main/resources/static/files-upload");

        if(!Files.exists(uploadPath)) Files.createDirectories(uploadPath);

        String fileCode = RandomStringUtils.randomAlphanumeric(10);

        try(InputStream inputStream = multipartFile.getInputStream())
        {
            Path filePath = uploadPath.resolve(fileCode + fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException ioe)
        {
            throw new IOException("Невозможно сохранить: " + fileName, ioe);
        }
        return fileCode;
    }
}
