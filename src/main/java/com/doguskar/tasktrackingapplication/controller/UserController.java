package com.doguskar.tasktrackingapplication.controller;

import com.doguskar.tasktrackingapplication.data.UserData;
import com.doguskar.tasktrackingapplication.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserFacade userFacade;

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username){
        UserData userData = userFacade.findByUsername(username);
        if (Objects.nonNull(userData)){
            return ResponseEntity.ok(userData);
        }
        return ResponseEntity.notFound().build();
    }
}
