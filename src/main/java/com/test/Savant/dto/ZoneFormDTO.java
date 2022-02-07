package com.test.Savant.dto;

import com.test.Savant.models.zone.Zone;

import java.util.ArrayList;
import java.util.List;

public class ZoneFormDTO {

    private List<Zone> zones;

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public Zone[] zoneGenerator(int totalZones) {
        Zone [] myZones = new Zone[totalZones];

        for (int i = 0; i < totalZones; i++) {
            myZones[i] = new Zone();
        }

        return myZones;
    }
}
