package com.test.Savant.models;

public class AudioDevice extends Device {

    //properties of Audio Device
    private SignalIO signalIO;
    private ControllableIO controllableIO;

    //constructors
    public AudioDevice (String model, SignalIO signalIO, ControllableIO controllableIO) {

        super(model);
        this.signalIO = signalIO;
        this.controllableIO = controllableIO;
    }

    public AudioDevice (String model) {

        super(model);
    }

    //getters & setters
    public void setSignalIO(SignalIO signalIO) {this.signalIO = signalIO;}
    public SignalIO getSignalIO() {return signalIO;}

    public void setControllableIO(ControllableIO controllableIO) {this.controllableIO = controllableIO;}
    public ControllableIO getControllableIO() {return controllableIO;}
}
