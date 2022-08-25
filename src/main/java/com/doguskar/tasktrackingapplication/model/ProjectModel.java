package com.doguskar.tasktrackingapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProjectModel extends ItemModel{
    private String name;
    @ManyToOne
    @JsonIgnore
    private UserModel userModel;
    @OneToMany(mappedBy = "projectModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TaskListModel> taskLists;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskListModel> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(List<TaskListModel> taskLists) {
        this.taskLists = taskLists;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
