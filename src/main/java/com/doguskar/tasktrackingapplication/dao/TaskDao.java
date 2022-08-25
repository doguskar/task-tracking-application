package com.doguskar.tasktrackingapplication.dao;

import com.doguskar.tasktrackingapplication.model.TaskModel;


public interface TaskDao {
    TaskModel findById(final Long id);
    TaskModel add(final TaskModel taskModel);
    TaskModel update(final TaskModel taskModel);
    void delete(final TaskModel taskModel);
}
