package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.SkillService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Skill;
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
@RequestMapping("api/skills")
@Api(tags = "Skills")
public class SkillsController {

    private SkillService skillService;

    @Autowired
    public SkillsController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Skills")
    public DataResult<List<Skill>> getAll() {
        return this.skillService.getAll();
    }

    @PostMapping("")
    @ApiOperation(value = "Add Skill")
    public ResponseEntity<Result> add(@Valid @RequestBody Skill skill) {
        Result result = this.skillService.add(skill);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Update Skill by Id")
    public DataResult<Optional<Skill>> update(
            @PathVariable("id") int id, @Valid @RequestBody Skill skill) {
        return this.skillService.update(id, skill);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete Skill by Id")
    public Result delete(@PathVariable("id") int id) {
        return this.skillService.delete(id);
    }
}
