package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.JobTitleService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobTitle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/jobs/types")
@Api(tags = "Job Titles")
public class JobTitlesController {

    private JobTitleService jobTitleService;

    @Autowired
    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Job Titles")
    public DataResult<List<JobTitle>> getAll() {
        return this.jobTitleService.getAll();
    }

    @PostMapping("")
    @ApiOperation(value = "Add Job Title")
    public ResponseEntity<Result> add(@Valid @RequestBody JobTitle jobTitle) {
        Result result = this.jobTitleService.add(jobTitle);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Update Job Title by Id")
    public DataResult<Optional<JobTitle>> update(
            @PathVariable("id") int id, @Valid @RequestBody JobTitle jobTitle) {
        return this.jobTitleService.update(id, jobTitle);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete Job Title by Id")
    public Result delete(@PathVariable("id") int id) {
        return this.jobTitleService.delete(id);
    }
}
