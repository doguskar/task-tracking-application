package com.doguskar.tasktrackingapplication.facade.impl;

import com.doguskar.tasktrackingapplication.facade.TaskListFacade;
import com.doguskar.tasktrackingapplication.mapper.TaskListMapper;
import com.doguskar.tasktrackingapplication.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("taskListFacade")
public class DefaultTaskListFacade implements TaskListFacade {
    @Autowired
    private TaskListService taskListService;
    @Autowired
    private TaskListMapper taskListMapper;

}
