package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.JobService;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.JobDao;
import com.kodlamaio.hrms.entities.concretes.Job;
import com.kodlamaio.hrms.entities.dtos.JobSummaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Override
    public DataResult<List<JobSummaryDto>> getAllActiveJobSummaryDto() {
        return new SuccessDataResult<List<JobSummaryDto>>(
                this.jobDao.getAllActiveJobSummaryDto(),
                "Active Job details are listed successfully!"
        );
    }

    @Override
    public DataResult<List<JobSummaryDto>> getAllDeactiveJobSummaryDto() {
        return new SuccessDataResult<List<JobSummaryDto>>(
                this.jobDao.getAllDeactiveJobSummaryDto(),
                "Deactive Job details are listed successfully!"
        );
    }

    @Override
    public DataResult<List<JobSummaryDto>> getAllJobSummaryDtoBySalary(
            BigDecimal maxSalary, BigDecimal minSalary) {
        return new SuccessDataResult<List<JobSummaryDto>>(
                this.jobDao.getAllJobSummaryDtoBySalary(minSalary, maxSalary),
                "Jobs are listed by salary successfully!"
        );
    }

    @Override
    public DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByState(String state) {
        return new SuccessDataResult<List<JobSummaryDto>>(
                this.jobDao.getAllJobSummaryDtoByState(state),
                "Jobs are listed by state successfully!"
        );
    }

//    @Override
//    public DataResult<Optional<JobSummaryDto>> getJobSummaryDtoById(int id){
//        return new SuccessDataResult<Optional<JobSummaryDto>>(
//                this.jobDao.getJobSummaryDtoById(id), "Job by Id is found successfully!"
//        );
//    }

    @Override
    public DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByCompanyName(String companyName) {
        return new SuccessDataResult<List<JobSummaryDto>>(
                this.jobDao.getAllJobSummaryDtoByCompanyName(companyName),
                "Jobs are listed by company name successfully!"
        );
    }

    @Override
    public DataResult<List<JobSummaryDto>> getAllJobSummaryDtoByJobTitle(String jobTitle) {
        return new SuccessDataResult<List<JobSummaryDto>>(
                this.jobDao.getAllJobSummaryDtoByJobTitle(jobTitle),
                "Jobs are listed by job title successfully!"
        );
    }

    @Override
    public Result add(Job job) {
        this.jobDao.save(job);
        return new SuccessResult("Jobs added successfully!");
    }

    @Override
    public DataResult<Job> setStatus(int id, boolean status) {
        Job job = this.jobDao.findById(id).orElse(null);

        if (job == null) {
            return new ErrorDataResult<>(ValidationMessages.JOB_IS_NOT_FOUND);
        }

        job.setActive(status);
        this.jobDao.save(job);

        return new SuccessDataResult<Job>(job, "Job's status changed");
    }
}
