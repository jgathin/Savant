package com.test.Savant.models;

public class SignalIO {

    //properties of Signal Ins & Outs
    private int lowOutputs;
    private int highOutputs;
    private int analogInputs;
    private int digitalInputs;
    private int digitalOutputs;
    private boolean embeddedStreams;

    //getters & setters
    public void setLowOutputs(int lowOutputs) {this.lowOutputs = lowOutputs;}
    public int getLowOutputs() {return lowOutputs;}

    public void setHighOutputs(int highOutputs) {this.highOutputs = highOutputs;}
    public int getHighOutputs() {return highOutputs;}

    public void setAnalogInputs (int analogInputs) {this.analogInputs = analogInputs; }
    public int getAnalogInputs () {return this.analogInputs;}

    public void setDigitalInputs (int digitalInputs) {this.digitalInputs = digitalInputs;}
    public int getDigitalInputs () {return this.digitalInputs;}

    public void setDigitalOutputs (int digitalOutputs) {this.digitalOutputs = digitalOutputs;}
    public int getDigitalOutputs () {return this.digitalOutputs;}

    public void setEmbeddedStreams (boolean embeddedStreams) {this.embeddedStreams = embeddedStreams;}
    public boolean getEmbeddedStreams () {return this.embeddedStreams;}

}
