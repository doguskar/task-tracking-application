package com.doguskar.tasktrackingapplication.service.impl;

import com.doguskar.tasktrackingapplication.dao.ProjectDao;
import com.doguskar.tasktrackingapplication.service.TaskListService;
import com.doguskar.tasktrackingapplication.dao.TaskListDao;
import com.doguskar.tasktrackingapplication.model.ProjectModel;
import com.doguskar.tasktrackingapplication.model.TaskListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("taskListService")
public class DefaultTaskListService implements TaskListService {
    @Autowired
    private TaskListDao taskListDao;
    @Autowired
    private ProjectDao projectDao;

    @Override
    public TaskListModel findById(Long id) {
        if (Objects.nonNull(id)) {
            return taskListDao.findById(id);
        }
        return null;
    }

    @Override
    public TaskListModel findByProjectIdAndTaskListsId(final Long projectId, final Long taskListsId) {
        final ProjectModel projectModel = projectDao.findById(projectId);
        if (Objects.nonNull(projectModel)) {
            final TaskListModel taskListModel = findById(taskListsId);
            if (Objects.nonNull(taskListModel) && Objects.nonNull(taskListModel.getProjectModel())
                    && taskListModel.getProjectModel().equals(projectModel)) {
                return taskListModel;
            }
        }
        return null;
    }
}
