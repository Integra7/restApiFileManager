package com.example.restapifilemanager.controllers;

import com.example.restapifilemanager.model.RoleModel;
import com.example.restapifilemanager.model.UserModel;
import com.example.restapifilemanager.repo.RoleRepo;
import com.example.restapifilemanager.repo.UserModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RegistrationController
{

    @Autowired
    private UserModelRepo userModelRepo;
    @Autowired
   private RoleRepo roleRepo;

    //gachimuchi
    @GetMapping("/registration")
    public String registrationForm(Model model) {
        return "home";
    }
//

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute("user") UserModel user, Model model) {

        Set<RoleModel> startRole = new HashSet<>();
        startRole.add(roleRepo.findRoleModelByName("ROLE_USER"));
        user.setRoles(startRole);
    userModelRepo.save(user);
    return "home";
}

//ajax utility
    @GetMapping("/checkUsername")
    @ResponseBody
    public String checkUsername(@RequestParam("user_name") String username) {
        UserModel existingUser = userModelRepo.findByUserName(username);

        if (existingUser != null) {
            return "taken";
        } else {
            return "available";
        }
    }


}