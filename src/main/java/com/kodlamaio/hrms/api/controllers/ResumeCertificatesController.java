package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.ResumeCertificateService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeCertificate;
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
@Api(tags = "Resume Certificates")
public class ResumeCertificatesController {

    private ResumeCertificateService resumeCertificateService;

    @Autowired
    public ResumeCertificatesController(ResumeCertificateService resumeCertificateService) {
        this.resumeCertificateService = resumeCertificateService;
    }

    @GetMapping("certificates")
    @ApiOperation(value = "Get All Resume Certificates")
    public DataResult<List<ResumeCertificate>> getAll() {
        return this.resumeCertificateService.getAll();
    }

    @GetMapping("{resumeId}/certificates")
    @ApiOperation(value = "Get All Resume Certificates by Resume Id")
    public DataResult<List<ResumeCertificate>> getAllByResumeId(@PathVariable("resumeId") int resumeId) {
        return this.resumeCertificateService.getAllByResumeId(resumeId);
    }

    @PostMapping("certificates")
    @ApiOperation(value = "Add Resume Certificate")
    public DataResult<ResumeCertificate> add(@Valid @RequestBody ResumeCertificate resumeCertificate) {
        return this.resumeCertificateService.add(resumeCertificate);
    }

    @PutMapping("certificates/{id}")
    @ApiOperation(value = "Update Resume Certificate by Id")
    public DataResult<Optional<ResumeCertificate>> update(
            @PathVariable("id") int id, @Valid @RequestBody ResumeCertificate resumeCertificate) {
        return this.resumeCertificateService.update(id, resumeCertificate);
    }

    @DeleteMapping("certificates/{id}")
    @ApiOperation(value = "Delete Resume Certificate by Id")
    public Result delete(@PathVariable("id") int id) {
        return this.resumeCertificateService.delete(id);
    }
}
