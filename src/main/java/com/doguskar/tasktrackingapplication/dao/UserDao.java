package com.doguskar.tasktrackingapplication.dao;

import com.doguskar.tasktrackingapplication.model.UserModel;

public interface UserDao {
    UserModel findByUsername(final String username);
    UserModel getAdminUser();
}
