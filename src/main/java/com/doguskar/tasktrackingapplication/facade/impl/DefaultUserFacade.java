package com.doguskar.tasktrackingapplication.facade.impl;

import com.doguskar.tasktrackingapplication.data.UserData;
import com.doguskar.tasktrackingapplication.facade.UserFacade;
import com.doguskar.tasktrackingapplication.mapper.UserMapper;
import com.doguskar.tasktrackingapplication.model.UserModel;
import com.doguskar.tasktrackingapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("userFacade")
public class DefaultUserFacade implements UserFacade {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserData findByUsername(String username) {
        UserModel userModel = userService.findByUsername(username);
        if (Objects.nonNull(userModel)){
            return userMapper.model2data(userModel);
        }
        return null;
    }
}
