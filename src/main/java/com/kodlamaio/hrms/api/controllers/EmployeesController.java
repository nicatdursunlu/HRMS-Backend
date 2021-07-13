package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.EmployeeService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/employees")
@Api(tags = "Employees")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Employees")
    public DataResult<List<Employee>> getAll() {
        return this.employeeService.getAll();
    }

//    @PostMapping("")
//    public ResponseEntity<Result> add(@Valid @RequestBody Employee employee) {
//        Result result = this.employeeService.add(employee);
//
//        if(!result.isSuccess()) {
//            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @PostMapping("")
    @ApiOperation(value = "Add Employee")
    public ResponseEntity<?> save(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(this.employeeService.add(employee));
    }
}
