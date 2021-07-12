package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeEducationService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/resume-educations")
public class ResumeEducationsController {

    private ResumeEducationService resumeEducationService;

    @Autowired
    public ResumeEducationsController(ResumeEducationService resumeEducationService) {
        this.resumeEducationService = resumeEducationService;
    }

    @GetMapping("/{resumeId}")
    public DataResult<List<ResumeEducation>> getAllByResumeId(int resumeId) {
        return this.resumeEducationService.getAllByResumeId(resumeId);
    }

    @PostMapping("")
    public ResponseEntity<?> add(@Valid @RequestBody ResumeEducation resumeEducation) {
        Result result = this.resumeEducationService.add(resumeEducation);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
