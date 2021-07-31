package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeReferenceService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeReference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/resume")
@Api(tags = "Resume References")
public class ResumeReferenceController {

    private ResumeReferenceService resumeReferenceService;

    @Autowired
    public ResumeReferenceController(ResumeReferenceService resumeReferenceService) {
        this.resumeReferenceService = resumeReferenceService;
    }

    @GetMapping("references")
    @ApiOperation(value = "Get All Resume References")
    public DataResult<List<ResumeReference>> getAll() {
        return this.resumeReferenceService.getAll();
    }

    @GetMapping("{resumeId}/references")
    @ApiOperation(value = "Get All Resume References by Resume Id")
    public DataResult<List<ResumeReference>> getAllByResumeId(@PathVariable("resumeId") int resumeId) {
        return this.resumeReferenceService.getAllByResumeId(resumeId);
    }

    @PostMapping("references")
    @ApiOperation(value = "Add Resume Reference")
    public DataResult<ResumeReference> add(@Valid @RequestBody ResumeReference resumeReference) {
        return this.resumeReferenceService.add(resumeReference);
    }

    @PutMapping("references/{id}")
    @ApiOperation(value = "Update Resume Reference by Id")
    public DataResult<Optional<ResumeReference>> update(
            @PathVariable("id") int id, @Valid @RequestBody ResumeReference resumeReference) {
        return this.resumeReferenceService.update(id, resumeReference);
    }

    @DeleteMapping("references/{id}")
    @ApiOperation(value = "Delete Resume Reference by Id")
    public Result delete(@PathVariable("id") int id) {
        return this.resumeReferenceService.delete(id);
    }
}
