package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.LanguageService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Language;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/languages")
@Api(tags = "Languages")
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Languages")
    public DataResult<List<Language>> getAll() {
        return this.languageService.getAll();
    }

    @GetMapping("/{name}")
    @ApiOperation(value = "Get Languages by Name")
    public DataResult<List<Language>> getAllByName(@RequestParam String name) {
        return this.languageService.getAllByName(name);
    }

    @PostMapping("")
    @ApiOperation(value = "Add Language")
    public ResponseEntity<Result> add(@Valid @RequestBody Language language) {

        Result result = this.languageService.add(language);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
