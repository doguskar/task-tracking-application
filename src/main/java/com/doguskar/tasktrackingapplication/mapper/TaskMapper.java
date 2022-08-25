package com.doguskar.tasktrackingapplication.mapper;

import com.doguskar.tasktrackingapplication.data.TaskData;
import com.doguskar.tasktrackingapplication.model.TaskModel;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @InheritInverseConfiguration
    TaskData model2data(TaskModel model);
}
