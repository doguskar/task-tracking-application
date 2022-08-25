package com.doguskar.tasktrackingapplication.dao;

import com.doguskar.tasktrackingapplication.model.ProjectModel;

public interface ProjectDao {
    ProjectModel findById(final Long id);
}
