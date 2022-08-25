package com.doguskar.tasktrackingapplication.dao.impl;

import com.doguskar.tasktrackingapplication.dao.TaskDao;
import com.doguskar.tasktrackingapplication.model.TaskModel;
import com.doguskar.tasktrackingapplication.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.stereotype.Service;

@Service("taskDao")
@EnableMapRepositories
public class DefaultTaskDao implements TaskDao {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskModel findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public TaskModel add(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    @Override
    public TaskModel update(TaskModel taskModel){
        return taskRepository.findById(taskModel.getId())
                .map(oldItem -> {
                    TaskModel updated = oldItem.clone();
                    return taskRepository.save(updated);
                }).orElse(null);
    }

    @Override
    public void delete(TaskModel taskModel) {
        taskRepository.delete(taskModel);
    }
}
