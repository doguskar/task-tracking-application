package com.doguskar.tasktrackingapplication.service;

import com.doguskar.tasktrackingapplication.model.TaskListModel;


public interface TaskListService {
    TaskListModel findById(final Long id);
    TaskListModel findByProjectIdAndTaskListsId(final Long projectId, final Long taskListsId);
}
