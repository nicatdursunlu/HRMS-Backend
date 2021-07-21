package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Job;
import com.kodlamaio.hrms.entities.dtos.JobSummaryDto;

import java.util.List;

public interface JobService {

    DataResult<List<Job>> getAll();

    DataResult<List<JobSummaryDto>> getAllJobSummaryDto();

    DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByCompanyName(String companyName);

    DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByJobTitle(String jobTitle);

    Result add(Job job);
}
