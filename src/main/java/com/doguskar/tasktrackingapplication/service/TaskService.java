package com.doguskar.tasktrackingapplication.service;

import com.doguskar.tasktrackingapplication.data.TaskData;
import com.doguskar.tasktrackingapplication.model.TaskListModel;
import com.doguskar.tasktrackingapplication.model.TaskModel;
import com.doguskar.tasktrackingapplication.requestbody.PostTaskRequestBody;

import java.util.List;

public interface TaskService {
    TaskModel findById(final Long id);
    TaskModel findTask(final Long projectId, final Long taskListsId, final Long taskId);
    boolean update(final PostTaskRequestBody postTaskRequestBody, final TaskModel taskModel);
    TaskModel add(final PostTaskRequestBody postTaskRequestBody, final TaskListModel taskListModel);
    boolean delete(final TaskModel taskModel);
}
