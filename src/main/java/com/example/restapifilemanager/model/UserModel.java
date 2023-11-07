package com.example.restapifilemanager.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
//@Table(name = "user_model")
public class UserModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;
    private String passWord;

    @Transient
    private String confirmPassword;

    @Column(name="roles")
    @ManyToMany
    @JoinTable(name="user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleModel> roles;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

   public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }
/*
    public UserHeapModel getUserHeapModel() {
       return userHeapModel;
    }

    public void setUserHeapModel(UserHeapModel userHeapModel) {
        this.userHeapModel = userHeapModel;
    }
*/
    public UserModel() {
    }

    public UserModel(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}
