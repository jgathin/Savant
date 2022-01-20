package com.test.Savant.models;

import com.test.Savant.AbstractEntity;

import javax.persistence.Entity;

@Entity
public class ControllableIO extends AbstractEntity {

    //properties of Controllable Ins & Outs
    private int infraredOutputs = 0;
    private int serialOutputs = 0;
    private int controllableRelays = 0;
    private int sensorInputs = 0;


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
