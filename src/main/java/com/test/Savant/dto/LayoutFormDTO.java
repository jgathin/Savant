package com.test.Savant.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LayoutFormDTO {

    @NotNull
    private int videoZones;

    @NotNull
    private int totalZones;

    public int getVideoZones() {
        return videoZones;
    }

    public void setVideoZones(int videoZones) {
        this.videoZones = videoZones;
    }

    public int getTotalZones() {
        return totalZones;
    }

    public void setTotalZones(int totalZones) {
        this.totalZones = totalZones;
    }
}
