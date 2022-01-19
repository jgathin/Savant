package com.test.Savant.models;

import javax.persistence.Entity;

@Entity
public class SavControl extends Device{

    //properties of controller
    private ControllableIO controllableIO;

    //constructors
    public SavControl(ControllableIO controllableIO) {

        this.controllableIO = controllableIO;
    }

    public SavControl() {}

    //getters & setters
    public void setControllableIO (ControllableIO controllableIO) {this.controllableIO = controllableIO;}
    public ControllableIO getControllableIO () {return this.controllableIO;}

}
