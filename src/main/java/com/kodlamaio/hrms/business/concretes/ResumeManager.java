package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.ResumeService;
import com.kodlamaio.hrms.core.utilities.mappers.ModelMapperUtils;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import com.kodlamaio.hrms.entities.concretes.Resume;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeDetailDto;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeSummaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;

    @Autowired
    public ResumeManager(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }


    @Override
    public DataResult<List<ResumeSummaryDto>> getAllSummaryDto() {
        return new SuccessDataResult<List<ResumeSummaryDto>>(
                ModelMapperUtils.toList(
                        this.resumeDao.findAll(),
                        ResumeSummaryDto.class
                )
        );
    }

    @Override
    public DataResult<List<ResumeDetailDto>> getDetailDtoById(int id) {
        return new SuccessDataResult<List<ResumeDetailDto>>(
                ModelMapperUtils.toList(
                        this.resumeDao.findAll(),
                        ResumeDetailDto.class
                )
        );
    }

    @Override
    public DataResult<Resume> getById(int id) {
        return new SuccessDataResult<Resume>(this.resumeDao.findById(id).orElse(null));
    }

    @Override
    public Result add(Resume resume) {
        this.resumeDao.save(resume);
        return new SuccessResult("Resume added successfully!");
    }
}
