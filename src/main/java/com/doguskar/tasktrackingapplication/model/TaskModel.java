package com.doguskar.tasktrackingapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TaskModel extends ItemModel implements Cloneable{
    private String title;
    private String description;

    @ManyToOne
    @JsonIgnore
    private TaskListModel taskListModel;

    @Override
    public TaskModel clone() {
        TaskModel taskModel = new TaskModel();
        taskModel.setId(this.getId());
        taskModel.setCreationTime(this.getCreationTime());
        taskModel.setModificationTime(new Date());
        taskModel.setTitle(this.getTitle());
        taskModel.setDescription(this.getDescription());
        taskModel.setTaskListModel(this.getTaskListModel());
        return taskModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskListModel getTaskListModel() {
        return taskListModel;
    }

    public void setTaskListModel(TaskListModel taskListModel) {
        this.taskListModel = taskListModel;
    }
}
