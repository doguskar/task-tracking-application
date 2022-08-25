package com.doguskar.tasktrackingapplication.repository;

import com.doguskar.tasktrackingapplication.model.TaskListModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository extends CrudRepository<TaskListModel, Long> {

}
