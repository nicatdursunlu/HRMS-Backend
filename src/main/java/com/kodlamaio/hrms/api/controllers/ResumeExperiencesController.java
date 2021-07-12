package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/resume-experiences")
public class ResumeExperiencesController {

    private ResumeExperienceService resumeExperienceService;

    @Autowired
    public ResumeExperiencesController(ResumeExperienceService resumeExperienceService) {
        this.resumeExperienceService = resumeExperienceService;
    }

    @GetMapping("")
    public DataResult<List<ResumeExperience>> getAll() {
        return this.resumeExperienceService.getAll();
    }

    @GetMapping("{resumeId}")
    public DataResult<List<ResumeExperience>> getAllByResumeId(int resumeId) {
        return this.resumeExperienceService.getAllByResumeId(resumeId);
    }

    @PostMapping("")
    public ResponseEntity<Result> add(ResumeExperience resumeExperience) {
        Result result = this.resumeExperienceService.add(resumeExperience);

        if (!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
