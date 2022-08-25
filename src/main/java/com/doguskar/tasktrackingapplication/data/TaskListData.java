package com.doguskar.tasktrackingapplication.data;

import java.util.List;

public class TaskListData extends ItemData {
    private String name;
    private List<TaskData> tasks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskData> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskData> tasks) {
        this.tasks = tasks;
    }
}
