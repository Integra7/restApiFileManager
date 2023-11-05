package com.example.restapifilemanager.controllers;

import com.example.restapifilemanager.model.UserModel;
import com.example.restapifilemanager.model.fileModel;
import com.example.restapifilemanager.service.FileServiceImplement;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("user")
public class uploaderController
{
    @Autowired
    private FileServiceImplement fileServiceImplement;

    @RequestMapping(value = {"","/", "/home"}, method = RequestMethod.GET)
    public String home(Model model)
    {

        UserModel user = (UserModel) model.getAttribute("user");
        if(user!=null)
        {
            model.addAttribute("user_name", user.getUserName());
            List<fileModel> fileModels = fileServiceImplement.findByUser(user);
            model.addAttribute("fileModels", fileModels);
            return "home";

        }

        else
        {
            return "home";
        }

    }
    @GetMapping("/upload")
    public String upload(Model model)
    {
        return "upload";
    }

}
