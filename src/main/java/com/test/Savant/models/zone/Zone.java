package com.test.Savant.models.zone;

import com.test.Savant.AbstractEntity;
import com.test.Savant.models.layout.Project;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Zone extends AbstractEntity {

    private String name;

    private String description;

    private ZoneType zoneType;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

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
