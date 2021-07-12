package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.CityService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.City;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/cities")
@Api(tags = "Cities")
//@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
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
    @ApiOperation(value = "Get cities by pages", notes = "vnruvnrvbr")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
        }
    )
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
