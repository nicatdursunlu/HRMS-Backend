package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.ResumeEducationService;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import com.kodlamaio.hrms.core.utilities.business.CheckEngine;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeEducationDao;
import com.kodlamaio.hrms.entities.concretes.ResumeEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeEducationManager implements ResumeEducationService {

    private ResumeEducationDao resumeEducationDao;

    @Autowired
    public ResumeEducationManager(ResumeEducationDao resumeEducationDao) {
        this.resumeEducationDao = resumeEducationDao;
    }

    @Override
    public DataResult<List<ResumeEducation>> getAll() {
        return new SuccessDataResult<List<ResumeEducation>>(
                this.resumeEducationDao.findAll(),
                "Resume Educations are listed successfully!"
        );
    }

    @Override
    public DataResult<List<ResumeEducation>> getAllByResumeId(int resumeId) {
        List<ResumeEducation> result = this.resumeEducationDao.findAllByResumeId(resumeId);
        return new SuccessDataResult<List<ResumeEducation>>(
                result, "Resume Educations by resume ID are listed successfully!"
        );
    }

    @Override
    public Result add(ResumeEducation resumeEducation) {
        Result result = CheckEngine.run(checkIfIsGraduateThenGraduateDateNotNull(resumeEducation));

        if(!result.isSuccess()) {
            return new ErrorDataResult<ResumeEducation>(resumeEducation, result.getMessage());
        }

        this.resumeEducationDao.save(resumeEducation);
        return new SuccessResult("Resume Education added successfully!");
    }

    private Result checkIfIsGraduateThenGraduateDateNotNull(ResumeEducation resumeEducation) {
        if(resumeEducation.isGraduate() && resumeEducation.getGraduateDate() != null) {
            return new ErrorResult(ValidationMessages.IF_IS_GRADUATE_THEN_GRADUATE_DATE_CAN_NOT_BE_NULL);
        }
        return new SuccessResult();
    }
}
