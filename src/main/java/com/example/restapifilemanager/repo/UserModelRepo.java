package com.example.restapifilemanager.repo;

import com.example.restapifilemanager.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserModelRepo extends JpaRepository<UserModel,Long>
{
    UserModel findByUserName(String username);
}
