package com.doguskar.tasktrackingapplication.service.impl;

import com.doguskar.tasktrackingapplication.dao.ProjectDao;
import com.doguskar.tasktrackingapplication.service.ProjectService;
import com.doguskar.tasktrackingapplication.model.ProjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("projectService")
public class DefaultProjectService implements ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Override
    public ProjectModel findById(Long id) {
        if (Objects.nonNull(id)) {
            return projectDao.findById(id);
        }
        return null;
    }
}
