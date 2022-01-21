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
    private ControllableIO controlIO;

    //constructors
    public AudioDevice (SignalIO signalIO, ControllableIO controlIO) {

        this.signalIO = signalIO;
        this.controlIO = controlIO;
    }

    public AudioDevice () {}

    //getters & setters
    public void setSignalIO(SignalIO signalIO) {this.signalIO = signalIO;}
    public SignalIO getSignalIO() {return signalIO;}

    public void setControlIO(ControllableIO controlIO) {this.controlIO = controlIO;}
    public ControllableIO getControlIO() {return controlIO;}
}
