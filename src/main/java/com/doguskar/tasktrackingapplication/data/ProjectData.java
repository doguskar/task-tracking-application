package com.doguskar.tasktrackingapplication.data;

import java.util.List;

public class ProjectData extends ItemData {
    private String name;
    private List<TaskListData> taskLists;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskListData> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(List<TaskListData> taskLists) {
        this.taskLists = taskLists;
    }
}
