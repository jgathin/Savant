package com.test.Savant.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class AudioDevice extends Device {

    //properties of Audio Device
    @OneToOne(cascade = CascadeType.ALL)
    private SignalIO signalIO;
    @OneToOne(cascade = CascadeType.ALL)
    private ControllableIO controllableIO;

    //constructors
    public AudioDevice (SignalIO signalIO, ControllableIO controllableIO) {

        this.signalIO = signalIO;
        this.controllableIO = controllableIO;
    }

    public AudioDevice () {}

    //getters & setters
    public void setSignalIO(SignalIO signalIO) {this.signalIO = signalIO;}
    public SignalIO getSignalIO() {return signalIO;}

    public void setControllableIO(ControllableIO controllableIO) {this.controllableIO = controllableIO;}
    public ControllableIO getControllableIO() {return controllableIO;}
}
