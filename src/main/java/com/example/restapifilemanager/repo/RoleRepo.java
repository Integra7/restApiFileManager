package com.example.restapifilemanager.repo;

import com.example.restapifilemanager.model.RoleModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleModel,Long>
{
    RoleModel findRoleModelByName(String name);
}
