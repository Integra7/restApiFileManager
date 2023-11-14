package com.example.restapifilemanager.controllers;

//import com.example.restapifilemanager.RecaptchaValidator;
import com.example.restapifilemanager.VerifyRecaptcha;
import com.example.restapifilemanager.model.UserModel;
import com.example.restapifilemanager.repo.UserModelRepo;
import com.example.restapifilemanager.service.UserServiceImplementation;
import jakarta.servlet.http.HttpSession;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;


@Controller
@SessionAttributes("user")
public class LoginController
{
    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @Autowired
    private UserModelRepo userModelRepo;

    @GetMapping("/login")
    public String login(Model model) {
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@RequestParam("g-recaptcha-response") String recaptchaResponse, @RequestParam("user_name") String username, @RequestParam("pass_word") String password, Model model) throws IOException {
        boolean isRecaptchaValid = VerifyRecaptcha.verify(recaptchaResponse);
        if(isRecaptchaValid) {
            UserModel user = userServiceImplementation.authenticate(username, password);
            if (user != null) {
                model.addAttribute("user", user);
            }
            return "redirect:/home";
        }
        else{
            return "redirect:/home";
        }
    }


    //ajax utility
    @GetMapping("/checkPass")
    @ResponseBody
    public String checkUsername(@RequestParam("user_name") String username, @RequestParam("pass_word") String password) {
        UserModel existingUser = userModelRepo.findByUserName(username);

        if (existingUser == null){
            return "failed";
        } else if (!existingUser.getPassWord().equals(password)) {
            return "failed";
        } else {
            return "nice";
        }
    }


    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }
}

