package com.test.Savant.models;

import com.test.Savant.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Device extends AbstractEntity {

    @Column(name = "model")
    private String model;

    @Column(name = "description")
    private String description;

    //getters & setters
    public void setModel (String model) {this.model = model;}
    public String getModel () {return this.model;}

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
