package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.AuthService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("api/auth")
@Api(tags = "Auths")
public class AuthsController {

    private AuthService authService;

    @Autowired
    public AuthsController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("register/employer")
    @ApiOperation(value = "")
    public Result employerRegister(@Valid @RequestBody Employer employer, String confirmPassword) {
        return authService.employerRegister(employer, confirmPassword);
    }
}



