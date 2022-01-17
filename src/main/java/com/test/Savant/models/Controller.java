package com.test.Savant.models;

public class Controller extends Device{

    //properties of controller
    private ControllableIO controllableIO;

    //constructors
    public Controller (String model, ControllableIO controllableIO) {

        super(model);
        this.controllableIO = controllableIO;
    }

    public Controller (String model) {

        super(model);
    }

    //getters & setters
    public void setControllableIO (ControllableIO controllableIO) {this.controllableIO = controllableIO;}
    public ControllableIO getControllableIO () {return this.controllableIO;}

}
