package com.test.Savant.models;

import javax.persistence.Entity;

@Entity
public class Host extends Device {

    //properties of host
    private int videoZones;
    private int totalZones;
    private int supportedLights;
    private int supportedSensors;
    private boolean embedded;
    private ControllableIO controlIO;
    private SignalIO signalIO;

    //constructors
    public Host(int videoZones, int totalZones, int supportedLights, int supportedSensors, boolean embedded, ControllableIO controlIO, SignalIO signalIO) {

        this.videoZones = videoZones;
        this.totalZones = totalZones;
        this.supportedLights = supportedLights;
        this.supportedSensors = supportedSensors;
        this.embedded = embedded;
        this.controlIO = controlIO;
        this.signalIO = signalIO;
    }

    public Host() {};

    //getters & setters
    public void setVideoZones (int videoZones) {this.videoZones = videoZones;}
    public int getVideoZones () {return this.videoZones;}

    public void setTotalZones (int totalZones) {this.totalZones = totalZones;}
    public int getTotalZones () {return this.totalZones;}

    public void setSupportedLights (int supportedLights) {this.supportedLights = supportedLights;}
    public int getSupportedLights () {return this.supportedLights;}

    public void setSupportedSensors (int supportedSensors) {this.supportedSensors = supportedSensors;}
    public int getSupportedSensors () {return this.supportedSensors;}

    public void setEmbedded (boolean embedded) {this.embedded = embedded;}
    public boolean getEmbedded () {return this.embedded;}

    public void setControlIO (ControllableIO controlIO) {this.controlIO = controlIO;}
    public ControllableIO getControlIO () {return this.controlIO;}

    public void setSignalIO (SignalIO signalIO) {this.signalIO = signalIO;}
    public SignalIO getSignalIO () {return this.signalIO;}

}
