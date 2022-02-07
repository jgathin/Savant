package com.test.Savant.models.zone;

import com.test.Savant.AbstractEntity;

import javax.persistence.Entity;

@Entity
public class Zone extends AbstractEntity {

    private String name;

    private String description;

    private ZoneType zoneType;

    public Zone(String name, String description, ZoneType zoneType) {
        this.name = name;
        this.description = description;
        this.zoneType = zoneType;
    }

    public Zone() {}

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
}
