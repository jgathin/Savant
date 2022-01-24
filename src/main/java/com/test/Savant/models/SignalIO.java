package com.test.Savant.models;

import com.test.Savant.AbstractEntity;

import javax.persistence.Entity;

@Entity
public class SignalIO extends AbstractEntity {

    //properties of Signal Ins & Outs
    private int lowOutputs = 0;
    private int highOutputs = 0;
    private int analogInputs = 0;
    private int digitalInputs = 0;
    private int digitalOutputs = 0;
    private int embeddedStreams = 0;

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

    public int getEmbeddedStreams() {
        return embeddedStreams;
    }

    public void setEmbeddedStreams(int embeddedStreams) {
        this.embeddedStreams = embeddedStreams;
    }
}
