package com.test.Savant.models;

import com.test.Savant.AbstractEntity;

public class Device extends AbstractEntity {

    private String model;

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
