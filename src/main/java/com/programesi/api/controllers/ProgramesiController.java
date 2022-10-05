package com.programesi.api.controllers;

import com.programesi.api.models.dto.ErrorDTO;
import com.programesi.api.models.dto.TimeworkDTO;
import com.programesi.api.models.dto.UserDTO;
import com.programesi.api.models.entity.Timework;
import com.programesi.api.models.entity.User;
import com.programesi.api.services.IUserService;
import com.programesi.api.services.exceptions.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ProgramesiController {

    private final IUserService userService;

    public ProgramesiController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> findUser(@PathVariable(value = "id") Long id) {
        return userService.findUser(id);
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDTO model) {
        try {
            return userService.createUser(model);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(new ErrorDTO(400, e.getMessage()));
        }
    }

    @PostMapping("/time-work")
    public ResponseEntity<?> createTimeWork(@RequestBody TimeworkDTO model) {
        return userService.createTimeWork(model);
        }

    @GetMapping("/time-work")
    public List<Timework> findTimeworks() {
        return userService.findTimeworks();
    }

    @GetMapping("/time-work/{id}")
    public Optional<Timework> findTimework(@PathVariable(value = "id") Long id) {
        return userService.findTimework(id);
    }
}