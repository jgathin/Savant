package com.test.Savant.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class SavControl extends Device{

    //properties of controller
    @OneToOne(cascade = CascadeType.ALL)
    private ControllableIO controlIO;

    //constructors

    public SavControl(ControllableIO controlIO) {

        this.controlIO = controlIO;
    }

    public SavControl() {}

    //getters & setters
    public void setControlIO (ControllableIO controlIO) {this.controlIO = controlIO;}
    public ControllableIO getControlIO () {return this.controlIO;}

}
