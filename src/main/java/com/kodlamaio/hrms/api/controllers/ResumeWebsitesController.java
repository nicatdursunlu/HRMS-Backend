package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeWebsiteService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeWebsite;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeWebsiteDetailDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/resume-websites")
public class ResumeWebsitesController {

    private ResumeWebsiteService resumeWebsiteService;

    @Autowired
    public ResumeWebsitesController(ResumeWebsiteService resumeWebsiteService) {
        this.resumeWebsiteService = resumeWebsiteService;
    }

    @ApiOperation(value = "Get all resume websites by resume id")
    @GetMapping("{resumeId}")
    public DataResult<List<ResumeWebsite>> getAllByResumeId(int resumeId) {
        return this.resumeWebsiteService.getAllByResumeId(resumeId);
    }

    @GetMapping("details/{resumeId}")
    public DataResult<List<ResumeWebsiteDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
        return this.resumeWebsiteService.getAllDetailDtoByResumeId(resumeId);
    }

    @PostMapping("")
    public ResponseEntity<Result> add(ResumeWebsite resumeWebsite) {
        Result result = this.resumeWebsiteService.add(resumeWebsite);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
