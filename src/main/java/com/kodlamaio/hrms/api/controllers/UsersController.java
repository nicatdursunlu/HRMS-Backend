package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.UserService;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@Api(tags = "Users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Users")
    public DataResult<List<User>> getAll() {
        return  this.userService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get User by Id")
    public DataResult<User> findById(@RequestParam int id) {
        return userService.findById(id);
    }

    @GetMapping("/{email}")
    @ApiOperation(value = "Get User by Email")
    public DataResult<User> findByEmail(@RequestParam String email) {
        return this.userService.findByEmail(email);
    }

    @PostMapping("")
    @ApiOperation(value = "Add User")
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.create(user));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update User by Id")
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody User user) {
        return ResponseEntity.ok(this.userService.update(id, user));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete User by Id")
    public ResponseEntity<?> delete(@RequestParam int id) {
        return ResponseEntity.ok(this.userService.delete(id));
    }
}
