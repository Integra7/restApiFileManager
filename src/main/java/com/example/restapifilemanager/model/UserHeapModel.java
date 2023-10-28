package com.example.restapifilemanager.model;

//общая модель для кучи файлов юзера

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.apache.commons.lang3.RandomStringUtils;

@Entity
public class UserHeapModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long user_Id;

    public long getId() {
        return id;
    }

    public long getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(long user_Id) {
        this.user_Id = user_Id;
    }
}
