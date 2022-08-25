package com.doguskar.tasktrackingapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ProjectControllerTest {
    @Autowired
    private MockMvc mockMvc;

    /*@Test
    public void shouldReturnProject() throws Exception {
        List<UserModel> userModels = new ArrayList<>();
        List<ProjectModel> projectModels = new ArrayList<>();
        List<TaskListModel> taskListModels = new ArrayList<>();
        List<TaskModel> taskModels = new ArrayList<>();
        // USER
        UserModel admin = new UserModel();
        admin.setName("Admin User");
        admin.setUsername("admin");
        admin.setPassword(DigestUtils.md5Hex("admin"));
        admin.setEmail("admin@hotmail.com");
        userModels.add(admin);

        // PROJECT
        ProjectModel projectModel = new ProjectModel();
        projectModel.setName("Initial Project");
        projectModel.setOwner(admin);
        projectModels.add(projectModel);

        // TASK_LIST
        TaskListModel taskListModel1 = new TaskListModel();
        taskListModel1.setName("To Do");
        taskListModel1.setOwner(projectModel);
        taskListModels.add(taskListModel1);
        TaskListModel taskListModel2 = new TaskListModel();
        taskListModel2.setName("In Progress");
        taskListModel2.setOwner(projectModel);
        taskListModels.add(taskListModel2);
        TaskListModel taskListModel3 = new TaskListModel();
        taskListModel3.setName("Done");
        taskListModel3.setOwner(projectModel);
        taskListModels.add(taskListModel3);

        // TASK
        TaskModel taskModel1 = new TaskModel();
        taskModel1.setTitle("Draw data structure");
        taskModel1.setDescription("Draw data structure description");
        taskModel1.setAssignee(admin);
        taskModel1.setOwner(taskListModel3);
        taskModels.add(taskModel1);
        TaskModel taskModel2 = new TaskModel();
        taskModel2.setTitle("Create project structure");
        taskModel2.setDescription("Create project structure and push initial commit to github");
        taskModel2.setAssignee(admin);
        taskModel2.setOwner(taskListModel3);
        taskModels.add(taskModel2);
        TaskModel taskModel3 = new TaskModel();
        taskModel3.setTitle("Authorization");
        taskModel3.setDescription("Implement authorization with spring security");
        taskModel3.setAssignee(admin);
        taskModel3.setOwner(taskListModel1);
        taskModels.add(taskModel3);
        TaskModel taskModel4 = new TaskModel();
        taskModel4.setTitle("Login page");
        taskModel4.setDescription("Implement login page");
        taskModel4.setAssignee(admin);
        taskModel4.setOwner(taskListModel1);
        taskModels.add(taskModel4);
        TaskModel taskModel5 = new TaskModel();
        taskModel5.setTitle("Create Project");
        taskModel5.setDescription("Create a end point to create new project");
        taskModel5.setAssignee(admin);
        taskModel5.setOwner(taskListModel2);
        taskModels.add(taskModel5);

        //assertThat(projectModels.get(0).getTaskListModelList()).isNotNull();

        //mockMvc.perform(get("/api/v1/projects/admin")).andDo(print()).andExpect(status().isOk());
    }*/
}
