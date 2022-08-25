package com.doguskar.tasktrackingapplication.mapper;

import com.doguskar.tasktrackingapplication.data.ProjectData;
import com.doguskar.tasktrackingapplication.model.ProjectModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @InheritInverseConfiguration
    ProjectData model2data(ProjectModel model);
}
