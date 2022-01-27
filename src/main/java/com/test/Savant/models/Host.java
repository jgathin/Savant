package com.test.Savant.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Host extends Device {

    //properties of host
    private int videoZones;
    private int totalZones;
    private int supportedLights;
    private int supportedShades;
    private int loadGroups;
    private int mobileDevices;
    private int ipVideoDevices;
    private int ipAudioDevices;
    private int supportedSensors;
    private boolean embedded;
    private boolean tiling;
    private boolean thirdPartySwitching;
    private boolean energyService;
    private boolean bacnetKNXIntegration;
    private int totalEntryStations;
    private int totalTStats;
    private int totalGarageDoors;
    private int totalDoorLocks;
    private int totalSecurityEndpoints;
    private int ipCameras;
    private boolean intercom;

    @OneToOne(cascade = CascadeType.ALL)
    private ControllableIO controlIO;
    @OneToOne(cascade = CascadeType.ALL)
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

    public int getSupportedShades() {
        return supportedShades;
    }

    public void setSupportedShades(int supportedShades) {
        this.supportedShades = supportedShades;
    }

    public int getLoadGroups() {
        return loadGroups;
    }

    public void setLoadGroups(int loadGroups) {
        this.loadGroups = loadGroups;
    }

    public int getMobileDevices() {
        return mobileDevices;
    }

    public void setMobileDevices(int mobileDevices) {
        this.mobileDevices = mobileDevices;
    }

    public int getIpVideoDevices() {
        return ipVideoDevices;
    }

    public void setIpVideoDevices(int ipVideoDevices) {
        this.ipVideoDevices = ipVideoDevices;
    }

    public int getIpAudioDevices() {
        return ipAudioDevices;
    }

    public void setIpAudioDevices(int ipAudioDevices) {
        this.ipAudioDevices = ipAudioDevices;
    }

    public boolean isEmbedded() {
        return embedded;
    }

    public boolean isTiling() {
        return tiling;
    }

    public void setTiling(boolean tiling) {
        this.tiling = tiling;
    }

    public boolean isThirdPartySwitching() {
        return thirdPartySwitching;
    }

    public void setThirdPartySwitching(boolean thirdPartySwitching) {
        this.thirdPartySwitching = thirdPartySwitching;
    }

    public boolean isEnergyService() {
        return energyService;
    }

    public void setEnergyService(boolean energyService) {
        this.energyService = energyService;
    }

    public boolean isBacnetKNXIntegration() {
        return bacnetKNXIntegration;
    }

    public void setBacnetKNXIntegration(boolean bacnetKNXIntegration) {
        this.bacnetKNXIntegration = bacnetKNXIntegration;
    }

    public int getTotalEntryStations() {
        return totalEntryStations;
    }

    public void setTotalEntryStations(int totalEntryStations) {
        this.totalEntryStations = totalEntryStations;
    }

    public int getTotalTStats() {
        return totalTStats;
    }

    public void setTotalTStats(int totalTStats) {
        this.totalTStats = totalTStats;
    }

    public int getTotalGarageDoors() {
        return totalGarageDoors;
    }

    public void setTotalGarageDoors(int totalGarageDoors) {
        this.totalGarageDoors = totalGarageDoors;
    }

    public int getTotalDoorLocks() {
        return totalDoorLocks;
    }

    public void setTotalDoorLocks(int totalDoorLocks) {
        this.totalDoorLocks = totalDoorLocks;
    }

    public int getTotalSecurityEndpoints() {
        return totalSecurityEndpoints;
    }

    public void setTotalSecurityEndpoints(int totalSecurityEndpoints) {
        this.totalSecurityEndpoints = totalSecurityEndpoints;
    }

    public int getIpCameras() {
        return ipCameras;
    }

    public void setIpCameras(int ipCameras) {
        this.ipCameras = ipCameras;
    }

    public boolean isIntercom() {
        return intercom;
    }

    public void setIntercom(boolean intercom) {
        this.intercom = intercom;
    }

    public boolean hostSelection (int v, int t) {
        if (v < this.videoZones && t < this.totalZones ) {
            return true;
        }
            return false;
        }

    }


