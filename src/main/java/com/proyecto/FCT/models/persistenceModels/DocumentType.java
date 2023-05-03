package com.proyecto.FCT.models.persistenceModels;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DocumentType")
public class DocumentType {
    @Id
    private int id;

    private String description;

    public DocumentType(int id) {
        this.id = id;
    }

    public DocumentType(int id, String description) {
        this.id = id;
        this.description = description;
    }
    public DocumentType(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

