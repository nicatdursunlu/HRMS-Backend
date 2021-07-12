package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import com.kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeExperience;
import com.kodlamaio.hrms.entities.concretes.ResumeLanguage;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeLanguageDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/resume-languages")
public class ResumeLanguagesController {

    private ResumeLanguageService resumeLanguageService;

    @Autowired
    public ResumeLanguagesController(ResumeLanguageService resumeLanguageService) {
        this.resumeLanguageService = resumeLanguageService;
    }

    @GetMapping("")
    public DataResult<List<ResumeLanguage>> getAll() {
        return this.resumeLanguageService.getAll();
    }

    @GetMapping("{resumeId}")
    public DataResult<List<ResumeLanguage>> getAllByResumeId(int resumeId) {
        return this.resumeLanguageService.getAllByResumeId(resumeId);
    }

    @GetMapping("detailed/{resumeId}")
    public DataResult<List<ResumeLanguageDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
        return this.resumeLanguageService.getAllDetailDtoByResumeId(resumeId);
    }

    @PostMapping("")
    public ResponseEntity<Result> add(ResumeLanguage resumeLanguage) {
        Result result = this.resumeLanguageService.add(resumeLanguage);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
