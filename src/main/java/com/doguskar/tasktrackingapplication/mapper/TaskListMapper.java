package com.doguskar.tasktrackingapplication.mapper;

import com.doguskar.tasktrackingapplication.data.TaskListData;
import com.doguskar.tasktrackingapplication.model.TaskListModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskListMapper {
    @InheritInverseConfiguration
    TaskListData model2data(TaskListModel model);
}
