package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.CandidateService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/candidates")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }

    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody Candidate candidate) {
        return ResponseEntity.ok(this.candidateService.add(candidate));
    }
}
