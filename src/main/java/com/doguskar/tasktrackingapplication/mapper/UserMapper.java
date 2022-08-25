package com.doguskar.tasktrackingapplication.mapper;

import com.doguskar.tasktrackingapplication.data.UserData;
import com.doguskar.tasktrackingapplication.model.UserModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @InheritInverseConfiguration
    UserData model2data(UserModel model);
}
