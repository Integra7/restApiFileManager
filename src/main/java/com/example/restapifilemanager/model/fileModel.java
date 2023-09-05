package com.example.restapifilemanager.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.apache.commons.lang3.RandomStringUtils;

@Entity
public class fileModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String size, fileName,uri;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public fileModel(){}

    public fileModel(String fileName, String size)
    {
        this.fileName = fileName;
        this.size = size;
    }
}
