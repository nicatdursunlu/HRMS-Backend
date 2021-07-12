package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Resume;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeDetailDto;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeSummaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/resumes")
public class ResumesController {

    private ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("")
    public DataResult<List<ResumeSummaryDto>> getAllSummaryDto() {
        return this.resumeService.getAllSummaryDto();
    }

    @GetMapping("{id}/details")
    public DataResult<List<ResumeDetailDto>> getDetailDtoById(
            @PathVariable(name = "id", required = true) int id) {
        return this.resumeService.getDetailDtoById(id);
    }

//    public DataResult<Resume> getById(int id) {
//
//    }

    @PostMapping("")
    public ResponseEntity<Result> add(Resume resume) {
        Result result = this.resumeService.add(resume);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
