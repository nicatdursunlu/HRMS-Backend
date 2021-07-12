package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeQualificationService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeQualificationDao;
import com.kodlamaio.hrms.entities.concretes.ResumeQualification;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeQualificationDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/resume-qualifications")
public class ResumeQualificationsController {

    private ResumeQualificationService resumeQualificationService;

    @Autowired
    public ResumeQualificationsController(ResumeQualificationService resumeQualificationService) {
        this.resumeQualificationService = resumeQualificationService;
    }

    @GetMapping("{resumeId}")
    public DataResult<List<ResumeQualification>> getAllByResumeId(int resumeId) {
        return this.resumeQualificationService.getAllByResumeId(resumeId);
    }

    @GetMapping("details/{resumeId}")
    public DataResult<List<ResumeQualificationDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
        return this.resumeQualificationService.getAllDetailDtoByResumeId(resumeId);
    }

    @PostMapping("")
    public ResponseEntity<Result> save(ResumeQualification resumeQualification) {
        Result result = this.resumeQualificationService.add(resumeQualification);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
