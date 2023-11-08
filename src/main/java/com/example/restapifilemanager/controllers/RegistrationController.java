package com.example.restapifilemanager.controllers;

import com.example.restapifilemanager.model.RoleModel;
import com.example.restapifilemanager.model.UserModel;
import com.example.restapifilemanager.repo.RoleRepo;
import com.example.restapifilemanager.repo.UserModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.dao.DataIntegrityViolationException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class RegistrationController
{

    @Autowired
    private UserModelRepo userModelRepo;
    @Autowired
   private RoleRepo roleRepo;

    //gachimuchi
    @GetMapping("/register")
    public String registrationForm(Model model) {
        return "registration";
    }
//

    @PostMapping("/register")
    public String registrationSubmit(@ModelAttribute("user") UserModel user, Model model) {

        if(user.getUserName().length() < 5 || user.getUserName().length() > 20)
        {
            model.addAttribute("error", "Юзернейм должен быть от 5 до 20 символов.");
            return "registration";
        }

        if(userModelRepo.findByUserName(user.getUserName())!=null)
        {
            model.addAttribute("error", "Этот юзернейм уже занят, выберите другой.");
            return "registration";
    }
    else
    {
        Set<RoleModel> startRole = new HashSet<>();
        startRole.add(roleRepo.findRoleModelByName("ROLE_USER"));
        user.setRoles(startRole);
    userModelRepo.save(user);
    return "redirect:/login";}
}

}