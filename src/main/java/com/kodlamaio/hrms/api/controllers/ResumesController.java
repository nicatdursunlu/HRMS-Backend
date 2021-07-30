package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Resume;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeDetailDto;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeSummaryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/resumes")
@Api(tags = "Resumes")
public class ResumesController {

    private ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Resumes Summary")
    public DataResult<List<ResumeSummaryDto>> getAllSummaryDto() {
        return this.resumeService.getAllSummaryDto();
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Get Resume Summary by Resume Id")
    public DataResult<List<ResumeDetailDto>> getDetailDtoById(
            @PathVariable(name = "id", required = true) int id) {
        return this.resumeService.getDetailDtoById(id);
    }

//    public DataResult<Resume> getById(int id) {
//
//    }

    @PostMapping("")
    @ApiOperation(value = "Add Resume")
    public ResponseEntity<Result> add(@Valid @RequestBody Resume resume) {
        Result result = this.resumeService.add(resume);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Update Resume by Id")
    public DataResult<Optional<Resume>> update(
            @PathVariable("id") int id, @Valid @RequestBody Resume resume) {
        return this.resumeService.update(id, resume);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete Resume by Id")
    public Result delete(@PathVariable("id") int id) {
        return this.resumeService.delete(id);
    }
}
