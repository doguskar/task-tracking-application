package com.doguskar.tasktrackingapplication.controller;

import com.doguskar.tasktrackingapplication.dao.ProjectDao;
import com.doguskar.tasktrackingapplication.data.ProjectData;
import com.doguskar.tasktrackingapplication.facade.ProjectFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("/api/v1/projects")
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectFacade projectFacade;

    @GetMapping("/")
    public ResponseEntity<?> get(){
        /* TODO: GET all project of current user */
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable final Long id){
        ProjectData projectData = projectFacade.findById(id);
        if (Objects.nonNull(projectData)){
            return ResponseEntity.ok(projectData);
        }
        return ResponseEntity.notFound().build();
    }
}
