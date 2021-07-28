package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.JobTitleService;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import com.kodlamaio.hrms.entities.concretes.JobTitle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    public JobTitleManager(JobTitleDao jobTitleDao) {
        super();
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>
                (this.jobTitleDao.findAll(), "Job titles are listed");
    }

    @Override
    public Result add(JobTitle jobTitle) {
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult("Job title added successfully");
    }

    @Override
    public DataResult<Optional<JobTitle>> update(int id, JobTitle jobTitle) {

        JobTitle oldJobTitle = this.jobTitleDao.findById(id).orElse(null);

        if (oldJobTitle == null) {
            return new ErrorDataResult<>("Job Title is not found");
        }

        oldJobTitle.setTitle(jobTitle.getTitle());
        this.jobTitleDao.save(oldJobTitle);

        return new SuccessDataResult<Optional<JobTitle>>(
                this.jobTitleDao.findById(id), "Job Title updated successfully!"
        );
    }

    @Override
    public Result delete(int id) {
        this.jobTitleDao.deleteById(id);
        return new SuccessResult("Job Title deleted successfully!");
    }
}
