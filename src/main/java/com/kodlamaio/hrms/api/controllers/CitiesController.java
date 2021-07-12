package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.CityService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.City;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/cities")
public class CitiesController {

    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get all cities")
    public DataResult<List<City>> getAll() {
        return this.cityService.getAll();
    }

    @GetMapping("pages")
    @ApiOperation(value = "Get cities by pages")
    public DataResult<List<City>> getAll(int page, int size) {
        return this.cityService.getAll(page, size);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Get city by id")
    public DataResult<Optional<City>> getById(@RequestParam(name = "id") int id) {
        return this.cityService.getById(id);
    }

    @GetMapping("{name}")
    @ApiOperation(value = "Get city by name")
    public DataResult<List<City>> getAllByName(@RequestParam String name) {
        return this.cityService.getAllByName(name);
    }

    @GetMapping(value = "{stateId}")
    @ApiOperation(value = "Get city by state id")
    public @ResponseBody DataResult<List<City>> getByStateId(@RequestParam(name = "stateId") int stateId) {
        return this.cityService.getByStateId(stateId);
    }

    @PostMapping("")
    @ApiOperation(value = "Add city")
    public Result add(@Valid  @RequestBody City city) {
        return this.cityService.add(city);
    }
}
