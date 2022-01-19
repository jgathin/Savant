package com.test.Savant.models;

public class ControllableIO {

    //properties of Controllable Ins & Outs
    private int infraredOutputs;
    private int serialOutputs;
    private int controllableRelays;
    private int sensorInputs;


    //getters & setters
    public void setInfraredOutputs (int infraredOutputs) {this.infraredOutputs = infraredOutputs;}
    public int getInfraredOutputs () {return this.infraredOutputs;}

    public void setSerialOutputs (int serialOutputs) {this.serialOutputs = serialOutputs;}
    public int getSerialOutputs () {return this.serialOutputs;}

    public void setControllableRelays (int controllableRelays) {this.controllableRelays = controllableRelays;}
    public int getControllableRelays () { return this.controllableRelays;}

    public void setSensorInputs (int sensorInputs) {this.sensorInputs = sensorInputs;}
    public int getSensorInputs () {return this.sensorInputs;}

}
