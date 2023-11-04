/*
package com.example.restapifilemanager.model;

//общая модель для кучи файлов юзера

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

@Entity
public class UserHeapModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //связь энтити хипа и юзера

    @OneToOne
    @JoinColumn(name = "user_ID")
    private UserModel userModel;
    ////////////////////////



    @OneToMany//(mappedBy = "id")
    private List<CurrentUserHeapModel> currentUserHeapModel;



    public Long getId() {
        return id;
    }

    public UserModel getUser_Id() {
        return userModel;
    }

    public void setUser_Id(UserModel userModel) {
        this.userModel = userModel;
    }
    public UserHeapModel(){}

    public List<CurrentUserHeapModel> getCurrentUserHeapModel() {
        return currentUserHeapModel;
    }

    public void setCurrentUserHeapModel(List<CurrentUserHeapModel> currentUserHeapModel) {
        this.currentUserHeapModel = currentUserHeapModel;
    }

    public UserHeapModel(UserModel userModel, List<CurrentUserHeapModel> currentUserHeapModel) {
        this.userModel = userModel;
        this.currentUserHeapModel = currentUserHeapModel;
    }
}
*/