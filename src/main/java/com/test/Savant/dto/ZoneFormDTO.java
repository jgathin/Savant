package com.test.Savant.dto;

import com.test.Savant.models.zone.Zone;
import com.test.Savant.models.zone.ZoneType;

import java.util.ArrayList;
import java.util.List;

public class ZoneFormDTO {

    private String name;

    private String description;

    private ZoneType zoneType;

//    private List<Zone> zones;

//    public List<Zone> getZones() {
//        return zones;
//    }

//    public void setZones(List<Zone> zones) {
//        this.zones = zones;
//    }

    public ZoneFormDTO(String name, String description, ZoneType zoneType) {
        this.name = name;
        this.description = description;
        this.zoneType = zoneType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZoneType getZoneType() {
        return zoneType;
    }

    public void setZoneType(ZoneType zoneType) {
        this.zoneType = zoneType;
    }

    public Zone[] zoneGenerator(int totalZones) {
        Zone [] myZones = new Zone[totalZones];

        for (int i = 0; i < totalZones; i++) {
            myZones[i] = new Zone();
        }

        return myZones;
    }
}
