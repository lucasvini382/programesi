package com.programesi.api.controllers;

import com.programesi.api.models.dto.ErrorDTO;
import com.programesi.api.models.dto.UserDTO;
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
@RequestMapping(value = "/api/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> findUser(@PathVariable(value = "id") Long id) {
        return userService.findUser(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserDTO model) {
        try {
            return userService.createUser(model);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(new ErrorDTO(400, e.getMessage()));
        }
    }
}