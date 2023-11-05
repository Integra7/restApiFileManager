package com.example.restapifilemanager.controllers;

import com.example.restapifilemanager.model.UserModel;
import com.example.restapifilemanager.service.UserServiceImplementation;
import jakarta.servlet.http.HttpSession;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("user")
public class LoginController
{
    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("user_name") String username, @RequestParam("pass_word") String password, Model model)
    {
        UserModel user = userServiceImplementation.authenticate(username,password);
        if(user!= null)
        {
            model.addAttribute("user", user);
            return "redirect:/home";
        }else {
            model.addAttribute("error", "Неправильное имя пользователя или пароль");
            return "login";
        }
    }

/*
    @RequestMapping(value = {"", "/home"}, method = RequestMethod.GET)
    public String welcome(Model model, HttpSession session) {
        UserModel user = (UserModel) session.getAttribute("user");
        model.addAttribute("user_name", user.getUserName());
        return "home";
    }
*/
    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }
}

