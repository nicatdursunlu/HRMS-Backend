package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeProjectService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeProject;
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
@Api(tags = "Resume Projects")
public class ResumeProjectsController {

    private ResumeProjectService resumeProjectService;

    @Autowired
    public ResumeProjectsController(ResumeProjectService resumeProjectService) {
        this.resumeProjectService = resumeProjectService;
    }

    @GetMapping("projects")
    @ApiOperation(value = "Get All Resume Projects")
    public DataResult<List<ResumeProject>> getAll(){
        return this.resumeProjectService.getAll();
    }

    @GetMapping("{resumeId}/projects")
    @ApiOperation(value = "Get All Resume Projects by Resume Id")
    public DataResult<List<ResumeProject>> getAllByResumeId(@PathVariable("resumeId") int resumeId){
        return this.resumeProjectService.getAllByResumeId(resumeId);
    }

    @PostMapping("projects")
    @ApiOperation(value = "Add Resume Project")
    public DataResult<ResumeProject> add(@Valid @RequestBody ResumeProject resumeProject){
        return this.resumeProjectService.add(resumeProject);
    }

    @PutMapping("projects/{id}")
    @ApiOperation(value = "Update Resume Project by Id")
    public DataResult<Optional<ResumeProject>> update(
            @PathVariable("id") int id, @Valid @RequestBody ResumeProject resumeProject){
        return this.resumeProjectService.update(id, resumeProject);
    }

    @DeleteMapping("projects/{id}")
    @ApiOperation(value = "Delete Resume Project by Id")
    public Result delete(@PathVariable("id") int id){
        return this.resumeProjectService.delete(id);
    }
}
