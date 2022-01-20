package com.test.Savant.models;

import javax.persistence.Entity;

@Entity
public class SavControl extends Device{

    //properties of controller
    private ControllableIO controlIO;

    //constructors
    public SavControl(ControllableIO controlIO) {

        this.controlIO = controlIO;
    }

    public SavControl() {}

    //getters & setters
    public void setControllableIO (ControllableIO controllableIO) {this.controlIO = controllableIO;}
    public ControllableIO getControllableIO () {return this.controlIO;}

}
