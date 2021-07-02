package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.CandidateService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/candidates")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        super();
        this.candidateService = candidateService;
    }

    @GetMapping("")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }
}
