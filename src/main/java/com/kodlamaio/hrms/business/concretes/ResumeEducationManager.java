package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.ResumeEducationService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
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
    public DataResult<List<ResumeEducation>> getAllByResumeId(int resumeId) {
//        List<ResumeEducation> result = (List<ResumeEducation>) this.resumeEducationDao.findAllByResumeId(id);
//        return new SuccessDataResult<List<ResumeEducation>>(
//                this.resumeEducationDao.findAllByResumeId(resumeId),
//                "Resume educations are listed successfully!");
//        List<ResumeEducation> result = (List<ResumeEducation>) this.resumeEducationDao.findAllByResumeId(resumeId);
//        return new SuccessDataResult<List<ResumeEducation>>(
//                result, "vr"
//        );
        return new SuccessDataResult<List<ResumeEducation>>(this.resumeEducationDao.findAll(), "Vrv");
    }

    @Override
    public Result add(ResumeEducation resumeEducation) {
        this.resumeEducationDao.save(resumeEducation);
        return new SuccessResult("Resume education added successfully!");
    }
}
