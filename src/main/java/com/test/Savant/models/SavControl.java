package com.test.Savant.models;

public class SavControl extends Device{

    //properties of controller
    private ControllableIO controllableIO;

    //constructors
    public SavControl(String model, ControllableIO controllableIO) {

        super(model);
        this.controllableIO = controllableIO;
    }

    public SavControl(String model) {

        super(model);
    }

    //getters & setters
    public void setControllableIO (ControllableIO controllableIO) {this.controllableIO = controllableIO;}
    public ControllableIO getControllableIO () {return this.controllableIO;}

}
