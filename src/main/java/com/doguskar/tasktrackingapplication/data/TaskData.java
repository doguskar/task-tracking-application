package com.doguskar.tasktrackingapplication.data;

import com.doguskar.tasktrackingapplication.model.ItemModel;
import com.doguskar.tasktrackingapplication.model.UserModel;

public class TaskData extends ItemData {
    private String title;
    private String description;

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
}
