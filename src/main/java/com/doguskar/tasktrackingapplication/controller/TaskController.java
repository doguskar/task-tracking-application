package com.doguskar.tasktrackingapplication.controller;

import com.doguskar.tasktrackingapplication.data.TaskData;
import com.doguskar.tasktrackingapplication.facade.TaskFacade;
import com.doguskar.tasktrackingapplication.requestbody.PostTaskRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/projects/{projectId}/task-lists/{taskListsId}/tasks")
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskFacade taskFacade;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody final PostTaskRequestBody body,
                                  @PathVariable final Long projectId,
                                  @PathVariable final Long taskListsId,
                                  final HttpServletRequest request) {
        if (Objects.nonNull(body)) {
            TaskData taskData = taskFacade.add(body, projectId, taskListsId);
            if (Objects.nonNull(taskData)) {
                StringBuilder uriBuilder = new StringBuilder();
                uriBuilder.append(request.getServletPath());
                if (!uriBuilder.toString().endsWith("/")) {
                    uriBuilder.append("/");
                }
                uriBuilder.append(taskData.getId());
                return ResponseEntity.created(URI.create(uriBuilder.toString())).build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<?> getById(@PathVariable final Long projectId,
                                   @PathVariable final Long taskListsId,
                                   @PathVariable final Long taskId) {
        if (Objects.nonNull(taskId)) {
            TaskData taskData = taskFacade.findById(projectId, taskListsId, taskId);
            if (Objects.nonNull(taskData)) {
                return ResponseEntity.ok(taskData);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{taskId}")
    public ResponseEntity<?> patch(@RequestBody final PostTaskRequestBody body,
                                   @PathVariable final Long projectId,
                                   @PathVariable final Long taskListsId,
                                   @PathVariable final Long taskId) {
        if (Objects.nonNull(body)) {
            TaskData taskData = taskFacade.update(body, projectId, taskListsId, taskId);
            if (Objects.nonNull(taskData)) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> delete(@PathVariable final Long projectId,
                                   @PathVariable final Long taskListsId,
                                   @PathVariable final Long taskId) {
        if (taskFacade.delete(projectId, taskListsId, taskId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
