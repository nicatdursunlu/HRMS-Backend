package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.WebsiteTypeService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.WebsiteType;
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
@RequestMapping("api/websites")
@Api(tags = "Websites")
public class WebsiteTypesController {

    private WebsiteTypeService websiteTypeService;

    @Autowired
    public WebsiteTypesController(WebsiteTypeService websiteTypeService) {
        this.websiteTypeService = websiteTypeService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Website Types")
    public DataResult<List<WebsiteType>> getAll() {
        return this.websiteTypeService.getAll();
    }

    @PostMapping("")
    @ApiOperation(value = "Add Website Type")
    public ResponseEntity<Result> add(@Valid @RequestBody WebsiteType websiteType) {
        Result result = this.websiteTypeService.add(websiteType);

        if (!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
