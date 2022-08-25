package com.doguskar.tasktrackingapplication.component;

import com.doguskar.tasktrackingapplication.dao.impl.DefaultUserDao;
import com.doguskar.tasktrackingapplication.model.ProjectModel;
import com.doguskar.tasktrackingapplication.model.TaskListModel;
import com.doguskar.tasktrackingapplication.model.TaskModel;
import com.doguskar.tasktrackingapplication.model.UserModel;
import com.doguskar.tasktrackingapplication.repository.ProjectRepository;
import com.doguskar.tasktrackingapplication.repository.TaskListRepository;
import com.doguskar.tasktrackingapplication.repository.TaskRepository;
import com.doguskar.tasktrackingapplication.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TaskListRepository taskListRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // USER
        UserModel admin = new UserModel();
        admin.setName("Admin User");
        admin.setUsername(DefaultUserDao.ADMIN);
        admin.setPassword(DigestUtils.md5Hex("admin"));
        admin.setEmail("admin@hotmail.com");
        userRepository.save(admin);

        // PROJECT
        ProjectModel projectModel = new ProjectModel();
        projectModel.setName("Initial Project");
        projectModel.setUserModel(admin);
        projectRepository.save(projectModel);

        // TASK_LIST
        TaskListModel taskListModel1 = new TaskListModel();
        taskListModel1.setName("To Do");
        taskListModel1.setProjectModel(projectModel);
        taskListRepository.save(taskListModel1);
        TaskListModel taskListModel2 = new TaskListModel();
        taskListModel2.setName("In Progress");
        taskListModel2.setProjectModel(projectModel);
        taskListRepository.save(taskListModel2);
        TaskListModel taskListModel3 = new TaskListModel();
        taskListModel3.setName("Done");
        taskListModel3.setProjectModel(projectModel);
        taskListRepository.save(taskListModel3);

        // TASK
        TaskModel taskModel1 = new TaskModel();
        taskModel1.setTitle("Draw data structure");
        taskModel1.setDescription("Draw data structure description");
        taskModel1.setTaskListModel(taskListModel3);
        taskRepository.save(taskModel1);
        TaskModel taskModel2 = new TaskModel();
        taskModel2.setTitle("Create project structure");
        taskModel2.setDescription("Create project structure and push initial commit to github");
        taskModel2.setTaskListModel(taskListModel3);
        taskRepository.save(taskModel2);
        TaskModel taskModel3 = new TaskModel();
        taskModel3.setTitle("Authorization");
        taskModel3.setDescription("Implement authorization with spring security");
        taskModel3.setTaskListModel(taskListModel1);
        taskRepository.save(taskModel3);
        TaskModel taskModel4 = new TaskModel();
        taskModel4.setTitle("Login page");
        taskModel4.setDescription("Implement login page");
        taskModel4.setTaskListModel(taskListModel1);
        taskRepository.save(taskModel4);
        TaskModel taskModel5 = new TaskModel();
        taskModel5.setTitle("Create Project");
        taskModel5.setDescription("Create a end point to create new project");
        taskModel5.setTaskListModel(taskListModel2);
        taskRepository.save(taskModel5);
    }
}
