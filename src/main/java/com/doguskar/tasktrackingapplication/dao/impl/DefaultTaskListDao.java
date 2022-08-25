package com.doguskar.tasktrackingapplication.dao.impl;

import com.doguskar.tasktrackingapplication.dao.TaskListDao;
import com.doguskar.tasktrackingapplication.model.TaskListModel;
import com.doguskar.tasktrackingapplication.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.stereotype.Service;

@Service("taskListDao")
@EnableMapRepositories
public class DefaultTaskListDao implements TaskListDao {
    @Autowired
    private TaskListRepository taskListRepository;

    @Override
    public TaskListModel findById(Long id) {
        return taskListRepository.findById(id).orElse(null);
    }
}
