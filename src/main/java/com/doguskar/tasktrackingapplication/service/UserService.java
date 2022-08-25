package com.doguskar.tasktrackingapplication.service;

import com.doguskar.tasktrackingapplication.model.UserModel;

public interface UserService {
    UserModel findByUsername(final String username);
}
