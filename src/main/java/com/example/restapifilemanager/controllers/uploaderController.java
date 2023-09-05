package com.example.restapifilemanager.controllers;

import com.example.restapifilemanager.model.fileModel;
import com.example.restapifilemanager.repo.fileModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class uploaderController
{
    @Autowired
    private fileModelRepo fileModelRepo;

    @GetMapping("/")
    public String home(Model model)
    {
        Iterable<fileModel>fileModels = fileModelRepo.findAll();
        model.addAttribute("fileModels", fileModels);
        return "home";
    }
    @GetMapping("/upload")
    public String upload(Model model)
    {
        return "upload";
    }

}
