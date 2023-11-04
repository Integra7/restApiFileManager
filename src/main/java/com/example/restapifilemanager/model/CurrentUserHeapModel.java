/*
package com.example.restapifilemanager.model;

//модель для кучи файлов конкретного юзера

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class CurrentUserHeapModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


   //@OneToMany(mappedBy = "currentUserHeapModel")
    @OneToMany
    private List<fileModel> files;



    @ManyToOne
    @JoinColumn(name = "Heap_id")
    private UserHeapModel userHeapModelID;



    public long getId() {
        return id;
    }

    public List<fileModel> getFiles() {
        return files;
    }

    public void setFiles(List<fileModel> files) {
        this.files = files;
    }

    public UserHeapModel getHeapId() {
        return userHeapModelID;
    }

    public void setHeapId(UserHeapModel userHeapModelID) {
        this.userHeapModelID = userHeapModelID;
    }
    public CurrentUserHeapModel(){}

    public CurrentUserHeapModel(List<fileModel> files, UserHeapModel userHeapModelID) {
        this.files = files;
        this.userHeapModelID = userHeapModelID;
    }
}
*/