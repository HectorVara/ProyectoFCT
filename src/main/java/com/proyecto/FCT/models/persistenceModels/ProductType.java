package com.proyecto.FCT.models.persistenceModels;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ProductType")
public class ProductType {
    @Id
    private int id;

    private String description;

    public ProductType(int id) {
        this.id = id;
    }
    public ProductType(){}

    public ProductType(int id, String description) {
        this.id = id;
        this.description = description;
    }

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
