package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.JobService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Job;
import com.kodlamaio.hrms.entities.dtos.JobSummaryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "api/jobs")
@Api(tags = "Jobs")
public class JobsController {

    private JobService jobService;

    @Autowired
    public JobsController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Jobs")
    public DataResult<List<Job>> getAll() {
        return this.jobService.getAll();
    }

    @GetMapping("summary")
    @ApiOperation(value = "Get All Jobs Summary")
    public DataResult<List<JobSummaryDto>> getAllJobSummaryDto() {
        return this.jobService.getAllJobSummaryDto();
    }

    @GetMapping("{companyName}")
    @ApiOperation(value = "Get All Jobs by Company Name")
    public DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByCompanyName(
            @RequestParam("companyName") String companyName) {
        return this.jobService.getAllJobSummaryDtoByCompanyName(companyName);
    }

    @GetMapping("{jobTitle}")
    @ApiOperation(value = "Get All Jobs by Job Title")
    public DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByJobTitle(
            @RequestParam("jobTitle") String jobTitle) {
        return this.jobService.getAllJobSummaryDtoByJobTitle(jobTitle);
    }

    @PostMapping("")
    @ApiOperation(value = "Add Job")
    public ResponseEntity<Result> add(@Valid @RequestBody Job job) {
        Result result = this.jobService.add(job);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
