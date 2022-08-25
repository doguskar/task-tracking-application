package com.doguskar.tasktrackingapplication.repository;

import com.doguskar.tasktrackingapplication.model.ProjectModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectModel, Long> {

}
