package com.example.restapifilemanager.service;

import com.example.restapifilemanager.model.UserModel;

public interface UserService
{
    void save(UserModel userModel);
    UserModel findByUserName(String username);
}
