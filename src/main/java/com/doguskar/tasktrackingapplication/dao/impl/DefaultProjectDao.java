package com.doguskar.tasktrackingapplication.dao.impl;

import com.doguskar.tasktrackingapplication.dao.ProjectDao;
import com.doguskar.tasktrackingapplication.model.ProjectModel;
import com.doguskar.tasktrackingapplication.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.stereotype.Service;

@Service("projectDao")
@EnableMapRepositories
public class DefaultProjectDao implements ProjectDao {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectModel findById(final Long id) {
        return projectRepository.findById(id).orElse(null);
    }
}
