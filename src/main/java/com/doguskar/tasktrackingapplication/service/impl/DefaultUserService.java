package com.doguskar.tasktrackingapplication.service.impl;

import com.doguskar.tasktrackingapplication.dao.UserDao;
import com.doguskar.tasktrackingapplication.model.UserModel;
import com.doguskar.tasktrackingapplication.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class DefaultUserService implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserModel findByUsername(String username) {
        if (StringUtils.isNotBlank(username)) {
            return userDao.findByUsername(username);
        }
        return null;
    }
}
