package com.doguskar.tasktrackingapplication.dao.impl;

import com.doguskar.tasktrackingapplication.dao.UserDao;
import com.doguskar.tasktrackingapplication.model.UserModel;
import com.doguskar.tasktrackingapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service("userDao")
@EnableMapRepositories
public class DefaultUserDao implements UserDao {
    public final static String ADMIN = "admin";
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel findByUsername(final String username) {
        final Iterator<UserModel> models = userRepository.findAll().iterator();
        UserModel result = null;
        while (models.hasNext()) {
            UserModel model = models.next();
            if (username.equalsIgnoreCase(model.getUsername())) {
                result = model;
                break;
            }
        }
        return result;
    }

    @Override
    public UserModel getAdminUser() {
        return findByUsername(ADMIN);
    }
}
