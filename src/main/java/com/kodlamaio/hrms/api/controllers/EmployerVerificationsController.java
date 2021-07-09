package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.EmployerVerificationService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employer-verifications")
public class EmployerVerificationsController {

    private EmployerVerificationService employerVerificationService;

    @Autowired
    public EmployerVerificationsController(EmployerVerificationService employerVerificationService) {
        this.employerVerificationService = employerVerificationService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Result> verificate(String code) {
        Result result = this.employerVerificationService.verificate(code);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
