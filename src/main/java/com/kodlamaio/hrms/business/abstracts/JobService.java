package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Job;
import com.kodlamaio.hrms.entities.dtos.JobSummaryDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface JobService {

    DataResult<List<Job>> getAll();

    DataResult<List<JobSummaryDto>> getAllJobSummaryDto();

    DataResult<Optional<JobSummaryDto>> getJobSummaryDtoById(int id);

    DataResult<List<JobSummaryDto>> getAllActiveJobSummaryDto();

    DataResult<List<JobSummaryDto>> getAllDeactiveJobSummaryDto();

    DataResult<List<JobSummaryDto>> getAllJobSummaryDtoBySalary(BigDecimal minSalary, BigDecimal maxSalary);

    DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByState(String state);

    DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByCompanyName(String companyName);

    DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByJobTitle(String jobTitle);

    Result add(Job job);

    DataResult<Job> update(int id, Job job);

    DataResult<Job> setStatus(int id, boolean status);

    Result delete(int id);
}
