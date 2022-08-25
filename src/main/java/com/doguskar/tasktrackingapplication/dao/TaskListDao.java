package com.doguskar.tasktrackingapplication.dao;

import com.doguskar.tasktrackingapplication.model.ProjectModel;
import com.doguskar.tasktrackingapplication.model.TaskListModel;

import java.util.List;

public interface TaskListDao {
    TaskListModel findById(Long id);
}
