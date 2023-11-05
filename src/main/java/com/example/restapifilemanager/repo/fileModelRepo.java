package com.example.restapifilemanager.repo;
import com.example.restapifilemanager.model.UserModel;
import com.example.restapifilemanager.model.fileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface fileModelRepo extends JpaRepository<fileModel, Long> {
    List<fileModel> findByUser(UserModel user);
}
