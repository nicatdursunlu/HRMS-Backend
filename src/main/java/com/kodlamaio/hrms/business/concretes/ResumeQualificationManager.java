package com.kodlamaio.hrms.business.concretes;


import com.kodlamaio.hrms.business.abstracts.ResumeQualificationService;
import com.kodlamaio.hrms.core.utilities.mappers.ModelMapperUtils;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeQualificationDao;
import com.kodlamaio.hrms.entities.concretes.ResumeQualification;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeQualificationDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeQualificationManager implements ResumeQualificationService {

    private ResumeQualificationDao resumeQualificationDao;

    @Autowired
    public ResumeQualificationManager(ResumeQualificationDao resumeQualificationDao) {
        this.resumeQualificationDao = resumeQualificationDao;
    }

    @Override
    public DataResult<List<ResumeQualification>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeQualification>>(
                (List<ResumeQualification>) this.resumeQualificationDao.findAllByResumeId(resumeId),
                "Resume qualification are listed successfully!"
        );
    }

    @Override
    public DataResult<List<ResumeQualificationDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeQualificationDetailDto>>(ModelMapperUtils.toList(
                this.getAllDetailDtoByResumeId(resumeId).getData(),
                ResumeQualificationDetailDto.class
        ), "Resume qualification are listed successfully!");
    }

    @Override
    public Result add(ResumeQualification resumeQualification) {
        this.resumeQualificationDao.save(resumeQualification);
        return new SuccessResult("Resume added successfully!");
    }
}
