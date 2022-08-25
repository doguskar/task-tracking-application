package com.doguskar.tasktrackingapplication.repository;

import com.doguskar.tasktrackingapplication.model.TaskModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<TaskModel, Long> {

}
