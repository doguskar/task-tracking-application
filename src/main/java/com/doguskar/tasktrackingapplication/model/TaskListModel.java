package com.doguskar.tasktrackingapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class TaskListModel extends ItemModel{
    private String name;
    @ManyToOne
    @JsonIgnore
    private ProjectModel projectModel;
    @OneToMany(mappedBy = "taskListModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TaskModel> tasks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskModel> tasks) {
        this.tasks = tasks;
    }

    public ProjectModel getProjectModel() {
        return projectModel;
    }

    public void setProjectModel(ProjectModel projectModel) {
        this.projectModel = projectModel;
    }
}
