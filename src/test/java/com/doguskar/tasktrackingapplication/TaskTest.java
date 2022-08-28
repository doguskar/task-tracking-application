package com.doguskar.tasktrackingapplication;

import com.doguskar.tasktrackingapplication.data.TaskData;
import com.doguskar.tasktrackingapplication.facade.TaskFacade;
import com.doguskar.tasktrackingapplication.model.ProjectModel;
import com.doguskar.tasktrackingapplication.model.TaskListModel;
import com.doguskar.tasktrackingapplication.model.TaskModel;
import com.doguskar.tasktrackingapplication.model.UserModel;
import com.doguskar.tasktrackingapplication.requestbody.PostTaskRequestBody;
import com.doguskar.tasktrackingapplication.service.TaskService;
import com.doguskar.tasktrackingapplication.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TaskTest {
    @Autowired
    private TaskFacade taskFacade;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void shouldReturnTaskData() {
        final String TITLE = "Test title";
        final String DESCRIPTION = "Test Description";
        UserModel admin = userService.findByUsername("admin");
        if (Objects.nonNull(admin)){
            List<ProjectModel> projectModels = admin.getProjects();
            if (!CollectionUtils.isEmpty(projectModels)){
                ProjectModel projectModel = projectModels.get(0);
                List<TaskListModel> taskListModels = projectModel.getTaskLists();
                if (!CollectionUtils.isEmpty(taskListModels)){
                    TaskListModel taskListModel = taskListModels.get(0);
                    PostTaskRequestBody requestBody = new PostTaskRequestBody();
                    requestBody.setTitle(TITLE);
                    requestBody.setDescription(DESCRIPTION);
                    TaskData taskData = taskFacade.add(requestBody, projectModel.getId(), taskListModel.getId());
                    assertThat(taskData).isNotNull();
                    assertThat(taskData.getTitle()).isEqualTo(TITLE);
                    assertThat(taskData.getDescription()).isEqualTo(DESCRIPTION);
                }
            }
        }
    }

    @Test
    @Transactional
    public void successDeleteTask() {
        final String TITLE = "Test title";
        final String DESCRIPTION = "Test Description";
        UserModel admin = userService.findByUsername("admin");
        if (Objects.nonNull(admin)){
            List<ProjectModel> projectModels = admin.getProjects();
            if (!CollectionUtils.isEmpty(projectModels)){
                ProjectModel projectModel = projectModels.get(0);
                List<TaskListModel> taskListModels = projectModel.getTaskLists();
                if (!CollectionUtils.isEmpty(taskListModels)){
                    TaskListModel taskListModel = taskListModels.get(0);
                    PostTaskRequestBody requestBody = new PostTaskRequestBody();
                    requestBody.setTitle(TITLE);
                    requestBody.setDescription(DESCRIPTION);
                    TaskModel taskModel = taskService.add(requestBody, taskListModel);
                    assertThat(taskModel).isNotNull();
                    boolean isDeleted = taskFacade.delete(projectModel.getId(), taskListModel.getId(), taskModel.getId());
                    assertThat(isDeleted).isTrue();
                }
            }
        }
    }

    @Test
    @Transactional
    public void failDeleteTask() {
        final String TITLE = "Test title";
        final String DESCRIPTION = "Test Description";
        UserModel admin = userService.findByUsername("admin");
        if (Objects.nonNull(admin)){
            List<ProjectModel> projectModels = admin.getProjects();
            if (!CollectionUtils.isEmpty(projectModels)){
                ProjectModel projectModel = projectModels.get(0);
                List<TaskListModel> taskListModels = projectModel.getTaskLists();
                if (!CollectionUtils.isEmpty(taskListModels)){
                    TaskListModel taskListModel = taskListModels.get(0);
                    PostTaskRequestBody requestBody = new PostTaskRequestBody();
                    requestBody.setTitle(TITLE);
                    requestBody.setDescription(DESCRIPTION);
                    TaskModel taskModel = taskService.add(requestBody, taskListModel);
                    assertThat(taskModel).isNotNull();
                    boolean isDeleted = taskFacade.delete((projectModel.getId() + 1), taskListModel.getId(), taskModel.getId());
                    assertThat(isDeleted).isFalse();
                }
            }
        }
    }

    @Test
    @Transactional
    public void UpdateTask() {
        final String TITLE = "Test title";
        final String TITLE_2 = "Test title";
        final String DESCRIPTION = "Test Description";
        UserModel admin = userService.findByUsername("admin");
        if (Objects.nonNull(admin)){
            List<ProjectModel> projectModels = admin.getProjects();
            if (!CollectionUtils.isEmpty(projectModels)){
                ProjectModel projectModel = projectModels.get(0);
                List<TaskListModel> taskListModels = projectModel.getTaskLists();
                if (!CollectionUtils.isEmpty(taskListModels)){
                    TaskListModel taskListModel = taskListModels.get(0);
                    PostTaskRequestBody requestBody = new PostTaskRequestBody();
                    requestBody.setTitle(TITLE);
                    requestBody.setDescription(DESCRIPTION);
                    TaskModel taskModel = taskService.add(requestBody, taskListModel);
                    assertThat(taskModel).isNotNull();
                    assertThat(taskModel.getTitle()).isEqualTo(TITLE);

                    requestBody.setTitle(TITLE_2);
                    taskFacade.update(requestBody, projectModel.getId(), taskListModel.getId(), taskModel.getId());
                    TaskModel updatedTask = taskService.findById(taskModel.getId());
                    assertThat(updatedTask.getTitle()).isEqualTo(TITLE_2);
                }
            }
        }
    }
}
