package com.doguskar.tasktrackingapplication.service;

import com.doguskar.tasktrackingapplication.model.ProjectModel;
import com.doguskar.tasktrackingapplication.model.UserModel;

import java.util.List;

public interface ProjectService {
    ProjectModel findById(Long id);
}
