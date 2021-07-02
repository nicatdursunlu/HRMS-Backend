package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.UserService;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll() {
        return  this.userService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.create(user));
    }
}
