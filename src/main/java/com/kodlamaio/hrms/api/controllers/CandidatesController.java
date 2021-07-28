package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.CandidateService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Candidate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "api/candidates")
@Api(tags = "Candidates")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Candidates")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }

    @PostMapping("")
    @ApiOperation(value = "Add Candidate")
    public ResponseEntity<?> save(@Valid @RequestBody Candidate candidate) {
        return ResponseEntity.ok(this.candidateService.add(candidate));
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Update Candidate by Id")
    public DataResult<Optional<Candidate>> update(
            @PathVariable("id") int id, @Valid @RequestBody Candidate candidate) {
        return this.candidateService.update(id, candidate);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete Candidate by Id")
    public Result delete(int id) {
        return this.candidateService.delete(id);
    }
}
