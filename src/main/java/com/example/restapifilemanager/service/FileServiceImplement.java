package com.example.restapifilemanager.service;

import com.example.restapifilemanager.model.UserModel;
import com.example.restapifilemanager.model.fileModel;
import com.example.restapifilemanager.repo.fileModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImplement implements FileService{

    @Autowired
    private fileModelRepo fileModelRepo;

    @Override
    public List<fileModel> findByUser(UserModel user) {
        return fileModelRepo.findByUser(user);
    }
}
