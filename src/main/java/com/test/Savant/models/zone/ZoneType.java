package com.test.Savant.models.zone;

public enum ZoneType {

    VIDEO("Zone w/ Video"),
    AUDIO("Zone w/ Audio"),
    LIGHT("Zone w/ Lighting"),
    HVAC("Zone w/ T-stats"),
    SECURITY("Zone w/ Sensors"),
    SURVEILLANCE("Zone w/ Cameras");

    private final String zoneType;

    ZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    public String getZoneType() {
        return zoneType;
    }
}
