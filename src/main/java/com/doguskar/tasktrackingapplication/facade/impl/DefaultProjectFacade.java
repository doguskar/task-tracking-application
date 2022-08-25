package com.doguskar.tasktrackingapplication.facade.impl;

import com.doguskar.tasktrackingapplication.data.ProjectData;
import com.doguskar.tasktrackingapplication.facade.ProjectFacade;
import com.doguskar.tasktrackingapplication.mapper.ProjectMapper;
import com.doguskar.tasktrackingapplication.service.ProjectService;
import com.doguskar.tasktrackingapplication.model.ProjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("projectFacade")
public class DefaultProjectFacade implements ProjectFacade {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ProjectData findById(Long id) {
        ProjectModel projectModel = projectService.findById(id);
        if (Objects.nonNull(projectModel)){
            return projectMapper.model2data(projectModel);
        }
        return null;
    }
}
