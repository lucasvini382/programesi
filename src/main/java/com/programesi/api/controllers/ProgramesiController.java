package com.programesi.api.controllers;

import com.programesi.api.models.dto.*;
import com.programesi.api.models.entity.Calendar;
import com.programesi.api.models.entity.Timework;
import com.programesi.api.models.entity.User;
import com.programesi.api.services.ITimeworkService;
import com.programesi.api.services.IUserService;
import com.programesi.api.services.exceptions.UserAlreadyExistsException;
import com.programesi.api.services.ICalendarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ProgramesiController {

    private final IUserService userService;
    private final ITimeworkService timeworkService;
    private final ICalendarService calendarService;

    public ProgramesiController(
            IUserService userService,
            ITimeworkService timeworkService,
            ICalendarService calendarService) {
        this.userService = userService;
        this.timeworkService = timeworkService;
        this.calendarService = calendarService;
    }

    @GetMapping("/user")
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> findUser(@PathVariable(value = "id") Long id) {
        return userService.findUser(id);
    }

    @GetMapping("/user/login")
    public Optional<User> loginUser(@RequestHeader String login, @RequestHeader String password) {
        LoginDTO header = new LoginDTO();
        header.login = login;
        header.password = password;
        return userService.loginUser(header);
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
        return timeworkService.createTimeWork(model);
        }

    @GetMapping("/time-work")
    public List<Timework> findTimeworks() {
        return timeworkService.findTimeworks();
    }

    @GetMapping("/time-work/{id}")
    public Optional<Timework> findTimework(@PathVariable(value = "id") Long id) {
        return timeworkService.findTimework(id);
    }

    @PostMapping("/calendar")
    public ResponseEntity<?> createCalendar(@RequestBody CalendarDTO model) {
        return calendarService.createCalendar(model);
    }

    @GetMapping("/calendar")
    public List<Timework> findCalendars() {
        return calendarService.findTimeworks();
    }

    @GetMapping("/calendar/{id}")
    public Optional<Timework> findCalendar(@PathVariable(value = "id") Long id) {
        return calendarService.findTimework(id);
    }
}