package com.doguskar.tasktrackingapplication.facade;

import com.doguskar.tasktrackingapplication.data.ProjectData;
import com.doguskar.tasktrackingapplication.model.ProjectModel;

public interface ProjectFacade {
    ProjectData findById(Long id);
}
