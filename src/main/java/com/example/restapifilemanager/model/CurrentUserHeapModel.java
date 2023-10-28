package com.example.restapifilemanager.model;

//модель для кучи файлов конкретного юзера

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CurrentUserHeapModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long fileId,heapId;

    public long getId() {
        return id;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public long getHeapId() {
        return heapId;
    }

    public void setHeapId(long heapId) {
        this.heapId = heapId;
    }
}
