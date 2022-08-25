package com.doguskar.tasktrackingapplication.data;

import com.doguskar.tasktrackingapplication.model.ProjectModel;

import java.util.List;

public class UserData extends ItemData{
    private String name;
    private String username;
    private String email;
    private List<ProjectData> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProjectData> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectData> projects) {
        this.projects = projects;
    }
}
