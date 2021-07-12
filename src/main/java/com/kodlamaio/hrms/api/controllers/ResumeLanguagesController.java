package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import com.kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.ResumeExperience;
import com.kodlamaio.hrms.entities.concretes.ResumeLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
