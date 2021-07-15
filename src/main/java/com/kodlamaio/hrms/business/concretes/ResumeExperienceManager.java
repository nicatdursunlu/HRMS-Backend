package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import com.kodlamaio.hrms.core.utilities.business.CheckEngine;
import com.kodlamaio.hrms.core.utilities.mappers.ModelMapperUtils;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeExperienceDao;
import com.kodlamaio.hrms.entities.concretes.ResumeExperience;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeExperienceDetailDto;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeLanguageDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeExperienceManager implements ResumeExperienceService {

    private ResumeExperienceDao resumeExperienceDao;

    @Autowired
    public ResumeExperienceManager(ResumeExperienceDao resumeExperienceDao) {
        this.resumeExperienceDao = resumeExperienceDao;
    }

    @Override
    public DataResult<List<ResumeExperience>> getAll() {
        return new SuccessDataResult<List<ResumeExperience>>(
                this.resumeExperienceDao.findAll(),
                "Resume experiences are listed successfully!");
    }

    @Override
    public DataResult<List<ResumeExperience>> getAllByResumeId(int id) {
        return new SuccessDataResult<List<ResumeExperience>>(
                this.resumeExperienceDao.findAllByResumeId(id),
                "Resume experiences are listed successfully!"
        );
    }

    @Override
    public DataResult<List<ResumeExperienceDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeExperienceDetailDto>>(
                ModelMapperUtils.toList(
                        this.getAllByResumeId(resumeId).getData(),
                        ResumeExperienceDetailDto.class
                )
        );
    }

    @Override
    public Result add(ResumeExperience resumeExperience) {
        Result result = CheckEngine.run(checkIfIsNotContinuedThenEndDateNotNull(resumeExperience));
        if(!result.isSuccess()) {
            return result;
        }

        this.resumeExperienceDao.save(resumeExperience);
        return new SuccessResult("Resume experience added successfully!");
    }

    private Result checkIfIsNotContinuedThenEndDateNotNull(ResumeExperience resumeExperience) {

        if(resumeExperience.isContinued() && resumeExperience.getEndDate() != null) {
            return new ErrorResult(
                    ValidationMessages.IF_IS_NOT_CONTINUED_THEN_END_DATE_CAN_NOT_BE_NULL
            );
        }

        return new SuccessResult();
    }
}
