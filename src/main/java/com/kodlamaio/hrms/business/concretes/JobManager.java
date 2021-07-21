package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.JobService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobDao;
import com.kodlamaio.hrms.entities.concretes.Job;
import com.kodlamaio.hrms.entities.dtos.JobSummaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobManager implements JobService {

    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    @Override
    public DataResult<List<Job>> getAll() {
        return new SuccessDataResult<List<Job>>(
                this.jobDao.findAll(), "Jobs are listed successfully!"
        );
    }

    @Override
    public DataResult<List<JobSummaryDto>> getAllJobSummaryDto() {
        return new SuccessDataResult<List<JobSummaryDto>>(
                this.jobDao.getAllJobSummaryDto(), "Job details are listed successfully!"
        );
    }

//    @Override
//    public DataResult<List<JobSummaryDto>> getAllJobSummaryDto() {
//        return new SuccessDataResult<List<JobSummaryDto>>(this.jobDao.getAllJobSummaryDto());
//    }

    @Override
    public DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByCompanyName(String companyName) {
        return new SuccessDataResult<List<JobSummaryDto>>(
                (List<JobSummaryDto>) this.jobDao.getAllJobSummaryDtoByCompanyName(companyName),
                "Jobs are listed by company name successfully!"
        );
    }

    @Override
    public DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByJobTitle(String jobTitle) {
        return new SuccessDataResult<List<JobSummaryDto>>(
                (List<JobSummaryDto>) this.jobDao.getAllJobSummaryDtoByJobTitle(jobTitle),
                "Jobs are listed by job title successfully!"
        );
    }

    @Override
    public Result add(Job job) {
        this.jobDao.save(job);
        return new SuccessResult("Jobs added successfully!");
    }
}
