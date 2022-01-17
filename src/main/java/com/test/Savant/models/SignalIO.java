package com.test.Savant.models;

public class SignalIO extends Device {

    //properties of Signal Ins & Outs
    private int lowOutputs;
    private int highOutputs;
    private int analogInputs;
    private int digitalInputs;
    private int analogOutputs;
    private int digitalOutputs;
    private int embeddedStreams;

    //constructors
    public SignalIO(String model, int lowOutputs, int highOutputs, int analogInputs, int digitalInputs, int analogOutputs, int digitalOutputs, int embeddedStreams) {

        super(model);
        this.lowOutputs = lowOutputs;
        this.highOutputs = highOutputs;
        this.analogInputs = analogInputs;
        this.digitalInputs= digitalInputs;
        this.analogOutputs = analogOutputs;
        this.digitalOutputs = digitalOutputs;
        this.embeddedStreams = embeddedStreams;
    }

    public SignalIO(String model) {

        super(model);
    }

    //getters & setters

    public void setLowOutputs(int lowOutputs) {this.lowOutputs = lowOutputs;}
    public int getLowOutputs() {return lowOutputs;}

    public void setHighOutputs(int highOutputs) {this.highOutputs = highOutputs;}
    public int getHighOutputs() {return highOutputs;}

    public void setAnalogInputs (int analogInputs) {this.analogInputs = analogInputs; }
    public int getAnalogInputs () {return this.analogInputs;}

    public void setDigitalInputs (int digitalInputs) {this.digitalInputs = digitalInputs;}
    public int getDigitalInputs () {return this.digitalInputs;}

    public void setAnalogOutputs (int analogOutputs) {this.analogOutputs = analogOutputs;}
    public int getAnalogOutputs () {return this.analogOutputs;}

    public void setDigitalOutputs (int digitalOutputs) {this.digitalOutputs = digitalOutputs;}
    public int getDigitalOutputs () {return this.digitalOutputs;}

    public void setEmbeddedStreams (int embeddedStreams) {this.embeddedStreams = embeddedStreams;}
    public int getEmbeddedStreams () {return this.embeddedStreams;}

}
