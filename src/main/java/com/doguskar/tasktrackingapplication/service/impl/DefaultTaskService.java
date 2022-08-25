package com.doguskar.tasktrackingapplication.service.impl;

import com.doguskar.tasktrackingapplication.dao.ProjectDao;
import com.doguskar.tasktrackingapplication.dao.TaskListDao;
import com.doguskar.tasktrackingapplication.model.ProjectModel;
import com.doguskar.tasktrackingapplication.requestbody.PostTaskRequestBody;
import com.doguskar.tasktrackingapplication.service.TaskService;
import com.doguskar.tasktrackingapplication.dao.TaskDao;
import com.doguskar.tasktrackingapplication.model.TaskListModel;
import com.doguskar.tasktrackingapplication.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("taskService")
public class DefaultTaskService implements TaskService {
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private TaskListDao taskListDao;

    @Override
    public TaskModel findById(final Long id) {
        if (Objects.nonNull(id)) {
            return taskDao.findById(id);
        }
        return null;
    }

    @Override
    public TaskModel findTask(final Long projectId, final Long taskListsId, final Long taskId){
        final ProjectModel projectModel = projectDao.findById(projectId);
        if (Objects.nonNull(projectModel)) {
            final TaskListModel taskListModel = taskListDao.findById(taskListsId);
            if (Objects.nonNull(taskListModel) && Objects.nonNull(taskListModel.getProjectModel())
                    && taskListModel.getProjectModel().equals(projectModel)) {
                final TaskModel taskModel = findById(taskId);
                if (Objects.nonNull(taskModel) && Objects.nonNull(taskModel.getTaskListModel())
                        && taskModel.getTaskListModel().equals(taskListModel)) {
                    return taskModel;
                }
            }
        }
        return null;
    }

    @Override
    public boolean update(PostTaskRequestBody postTaskRequestBody, TaskModel taskModel) {
        taskModel.setTitle(postTaskRequestBody.getTitle());
        taskModel.setDescription(postTaskRequestBody.getDescription());
        return Objects.nonNull(taskDao.update(taskModel));
    }

    @Override
    public TaskModel add(PostTaskRequestBody postTaskRequestBody, TaskListModel taskListModel) {
        final TaskModel taskModel = new TaskModel();
        taskModel.setTitle(postTaskRequestBody.getTitle());
        taskModel.setDescription(postTaskRequestBody.getDescription());
        taskModel.setTaskListModel(taskListModel);
        return taskDao.add(taskModel);
    }

    @Override
    public boolean delete(final TaskModel taskModel) {
        taskDao.delete(taskModel);
        return true;
    }
}
