package com.test.Savant.models.layout;

import com.sun.istack.NotNull;
import com.test.Savant.AbstractEntity;
import com.test.Savant.User;
import com.test.Savant.models.zone.Zone;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Project extends AbstractEntity {

    @NotNull
    @NotBlank
    private String host;

    @NotEmpty
    private List<Zone> zones;


    private String description;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String client;

    public Project () {}

    public Project(@NotBlank String host, @NotEmpty List<Zone> zones, String description, User user, String client) {
        this.host = host;
        this.zones = zones;
        this.description = description;
        this.user = user;
        this.client = client;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User designer) {
        this.user = designer;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
