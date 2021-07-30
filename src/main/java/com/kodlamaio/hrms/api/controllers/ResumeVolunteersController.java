package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeVolunteerService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.ResumeVolunteer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/resume")
@Api(tags = "Resume Volunteers")
public class ResumeVolunteersController {

    private ResumeVolunteerService resumeVolunteerService;

    @Autowired
    public ResumeVolunteersController(ResumeVolunteerService resumeVolunteerService) {
        this.resumeVolunteerService = resumeVolunteerService;
    }

    @GetMapping("volunteers")
    @ApiOperation(value = "Get All Resume Volunteers")
    public DataResult<List<ResumeVolunteer>> getAll() {
        return this.resumeVolunteerService.getAll();
    }

    @GetMapping("{resumeId}/volunteers")
    @ApiOperation(value = "Get All Resume Volunteers by Resume Id")
    public DataResult<List<ResumeVolunteer>> getAllByResumeId(@PathVariable("resumeId") int resumeId) {
        return this.resumeVolunteerService.getAllByResumeId(resumeId);
    }

    @PostMapping("volunteers")
    @ApiOperation(value = "Add Resume Volunteers")
    public DataResult<ResumeVolunteer> add(@Valid @RequestBody ResumeVolunteer resumeVolunteer) {
        return this.resumeVolunteerService.add(resumeVolunteer);
    }
}
