package com.test.Savant.dto;

import com.test.Savant.models.User;
import com.test.Savant.models.layout.Project;
import com.test.Savant.models.zone.Zone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjectFormDTO {

    private String host;

    private List<Zone> zones;

    private String description;

    private User user;

    private String client;

    public ProjectFormDTO(String host, List<Zone> zones, String description, User user, String client) {
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

    public void setUser(User user) {
        this.user = user;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<Project> pullProjectsToLocalMemory(User user) {
        ArrayList<Project> projectList = new ArrayList<>();
        Iterable<Project> projects = user.getProjects();

        for (Project project : projects) {
            projectList.add(project);
        }

        return projectList;
    }

    public Project findProjectById(Integer projectId, List<Project> projects) {
        HashMap<Integer, Project> projectMap = convertArrayListToHashMap(projects);

        return projectMap.get(projectId);
    }

    public static HashMap<Integer, Project> convertArrayListToHashMap(List<Project> list) {

        HashMap<Integer, Project> hashMap = new HashMap<>();

        for (Project project : list) {
            hashMap.put(project.getId(), project);
        }

        return hashMap;
    }

}
