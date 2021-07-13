package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeExperience;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/resume/experiences")
@Api(tags = "Resume Experiences")
public class ResumeExperiencesController {

    private ResumeExperienceService resumeExperienceService;

    @Autowired
    public ResumeExperiencesController(ResumeExperienceService resumeExperienceService) {
        this.resumeExperienceService = resumeExperienceService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Resume Experiences")
    public DataResult<List<ResumeExperience>> getAll() {
        return this.resumeExperienceService.getAll();
    }

    @GetMapping("{resumeId}")
    @ApiOperation(value = "Get All Resume Experiences by Resume Id")
    public DataResult<List<ResumeExperience>> getAllByResumeId(int resumeId) {
        return this.resumeExperienceService.getAllByResumeId(resumeId);
    }

    @PostMapping("")
    @ApiOperation(value = "Add Resume Experience")
    public ResponseEntity<Result> add(@Valid @RequestBody ResumeExperience resumeExperience) {
        Result result = this.resumeExperienceService.add(resumeExperience);

        if (!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
