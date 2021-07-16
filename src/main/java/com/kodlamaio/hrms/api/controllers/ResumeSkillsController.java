package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeSkillService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeSkill;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeSkillDetailDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/resume")
@Api(tags = "Resume Skills")
public class ResumeSkillsController {

    private ResumeSkillService resumeSkillService;

    @Autowired
    public ResumeSkillsController(ResumeSkillService resumeSkillService) {
        this.resumeSkillService = resumeSkillService;
    }

    @GetMapping("skills")
    @ApiOperation(value = "Get All Resume Skills by Resume Id")
    public DataResult<List<ResumeSkill>> getAll() {
        return this.resumeSkillService.getAll();
    }

    @GetMapping("{resumeId}/skills")
    @ApiOperation(value = "Get All Resume Skills by Resume Id")
    public DataResult<List<ResumeSkillDetailDto>> getAllByResumeId(@PathVariable("resumeId") int resumeId) {
        return this.resumeSkillService.getAllDetailDtoByResumeId(resumeId);
    }

    @PostMapping("skills")
    @ApiOperation(value = "Add Resume Skill")
    public ResponseEntity<Result> add(@Valid @RequestBody ResumeSkill resumeSkill) {
        Result result = this.resumeSkillService.add(resumeSkill);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
