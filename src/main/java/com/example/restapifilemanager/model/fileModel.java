package com.example.restapifilemanager.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Files")
public class fileModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String size, fileName,uri;

    ////////////File linked to curr user heap model

    @ManyToOne
    @JoinColumn(name = "user")
    private UserModel user;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public fileModel(){}

   // public CurrentUserHeapModel getCurrentUserHeapModel() {
  //      return currentUserHeapModel;
  //  }

  //  public void setCurrentUserHeapModel(CurrentUserHeapModel currentUserHeapModel) {
 //       this.currentUserHeapModel = currentUserHeapModel;
  //  }

    public fileModel(String size, String fileName) {
        this.size = size;
        this.fileName = fileName;
    }
}
