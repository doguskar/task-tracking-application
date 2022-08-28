package com.doguskar.tasktrackingapplication.facade.impl;

import com.doguskar.tasktrackingapplication.data.TaskData;
import com.doguskar.tasktrackingapplication.facade.TaskFacade;
import com.doguskar.tasktrackingapplication.mapper.TaskMapper;
import com.doguskar.tasktrackingapplication.model.TaskListModel;
import com.doguskar.tasktrackingapplication.model.TaskModel;
import com.doguskar.tasktrackingapplication.requestbody.PostTaskRequestBody;
import com.doguskar.tasktrackingapplication.service.TaskListService;
import com.doguskar.tasktrackingapplication.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("taskFacade")
public class DefaultTaskFacade implements TaskFacade {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskListService taskListService;
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public TaskData findById(final Long projectId, final Long taskListsId, final Long taskId) {
        final TaskModel taskModel = taskService.findTask(projectId, taskListsId, taskId);
        if (Objects.nonNull(taskModel)){
            return taskMapper.model2data(taskModel);
        }
        return null;
    }

    @Override
    public TaskData add(final PostTaskRequestBody postTaskRequestBody, final Long projectId, final Long taskListsId) {
        if (Objects.nonNull(projectId) && Objects.nonNull(taskListsId)) {
            final TaskListModel taskListModel = taskListService.findByProjectIdAndTaskListsId(projectId, taskListsId);
            if (Objects.nonNull(taskListModel)) {
                final TaskModel taskModel = taskService.add(postTaskRequestBody, taskListModel);
                if (Objects.nonNull(taskModel)) {
                    return taskMapper.model2data(taskModel);
                }
            }
        }
        return null;
    }

    @Override
    public TaskData update(final PostTaskRequestBody postTaskRequestBody, final Long projectId, final Long taskListsId, final Long taskId) {
        final TaskModel taskModel = taskService.findTask(projectId, taskListsId, taskId);
        return Objects.nonNull(taskModel) && taskService.update(postTaskRequestBody, taskModel) ?
                taskMapper.model2data(taskModel) : null;

    }

    @Override
    public boolean delete(Long projectId, Long taskListsId, Long taskId) {
        final TaskModel taskModel = taskService.findTask(projectId, taskListsId, taskId);
        return Objects.nonNull(taskModel) && taskService.delete(taskModel);
    }

}
