package com.example.restapifilemanager.service;

import com.example.restapifilemanager.model.UserModel;
import com.example.restapifilemanager.model.fileModel;

import java.util.List;


public interface FileService {
    List<fileModel> findByUser(UserModel user);
}
