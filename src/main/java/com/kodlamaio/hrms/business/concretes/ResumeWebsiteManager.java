package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.ResumeWebsiteService;
import com.kodlamaio.hrms.core.utilities.mappers.ModelMapperUtils;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeWebsiteDao;
import com.kodlamaio.hrms.entities.concretes.ResumeExperience;
import com.kodlamaio.hrms.entities.concretes.ResumeWebsite;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeWebsiteDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeWebsiteManager implements ResumeWebsiteService {

    private ResumeWebsiteDao resumeWebsiteDao;

    @Autowired
    public ResumeWebsiteManager(ResumeWebsiteDao resumeWebsiteDao) {
        this.resumeWebsiteDao = resumeWebsiteDao;
    }

    @Override
    public DataResult<List<ResumeWebsite>> getAll() {
        return new SuccessDataResult<List<ResumeWebsite>>(
                this.resumeWebsiteDao.findAll(), "Resume Websites are listed successfully!"
        );
    }

    @Override
    public DataResult<List<ResumeWebsite>> getAllByResumeId(int id) {
        return new SuccessDataResult<List<ResumeWebsite>>(
                 this.resumeWebsiteDao.findAllByResumeId(id),
                "Resume Websites by resume ID are listed successfully!"
        );
    }

    @Override
    public DataResult<List<ResumeWebsiteDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeWebsiteDetailDto>>(
                ModelMapperUtils.toList(
                        this.getAllDetailDtoByResumeId(resumeId).getData(),
                        ResumeWebsiteDetailDto.class
                )
        );
    }

    @Override
    public Result add(ResumeWebsite resumeWebsite) {
        this.resumeWebsiteDao.save(resumeWebsite);
        return new SuccessResult("Resume Website added successfully!");
    }
}
