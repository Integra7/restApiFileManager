package com.example.restapifilemanager.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    //@ManyToMany(mappedBy = "roles")
    //private Set<UserModel> users;

    public RoleModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public Set<UserModel> getUsers() {
    //    return users;
    //}

    //public void setUsers(Set<UserModel> users) {
    //    this.users = users;
    //}

    @Override
    public String toString() {
        return "RoleModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //-", users=" + users +
                '}';
    }
}
