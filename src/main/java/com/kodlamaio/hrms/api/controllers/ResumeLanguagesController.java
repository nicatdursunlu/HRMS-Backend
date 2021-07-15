package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeLanguage;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeLanguageDetailDto;
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
@RequestMapping("api/resume")
@Api(tags = "Resume Languages")
public class ResumeLanguagesController {

    private ResumeLanguageService resumeLanguageService;

    @Autowired
    public ResumeLanguagesController(ResumeLanguageService resumeLanguageService) {
        this.resumeLanguageService = resumeLanguageService;
    }

    @GetMapping("languages")
    @ApiOperation(value = "Get All Resume Languages")
    public DataResult<List<ResumeLanguage>> getAll() {
        return this.resumeLanguageService.getAll();
    }

    @GetMapping("{resumeId}/languages")
    @ApiOperation(value = "Get All Resume Languages by Resume Id")
    public DataResult<List<ResumeLanguageDetailDto>> getAllByResumeId(@PathVariable("resumeId")  int resumeId) {
        return this.resumeLanguageService.getAllDetailDtoByResumeId(resumeId);
    }

    @PostMapping("languages")
    @ApiOperation(value = "Add Resume Language")
    public ResponseEntity<Result> add(@Valid @RequestBody ResumeLanguage resumeLanguage) {
        Result result = this.resumeLanguageService.add(resumeLanguage);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
