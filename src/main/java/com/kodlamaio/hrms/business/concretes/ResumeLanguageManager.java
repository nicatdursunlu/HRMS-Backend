package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import com.kodlamaio.hrms.core.utilities.mappers.ModelMapperUtils;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeLanguageDao;
import com.kodlamaio.hrms.entities.concretes.ResumeLanguage;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeLanguageDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeLanguageManager implements ResumeLanguageService {

    private ResumeLanguageDao resumeLanguageDao;

    @Autowired
    public ResumeLanguageManager(ResumeLanguageDao resumeLanguageDao) {
        this.resumeLanguageDao = resumeLanguageDao;
    }

    @Override
    public DataResult<List<ResumeLanguage>> getAll() {
        return new SuccessDataResult<List<ResumeLanguage>>(
                this.resumeLanguageDao.findAll(),
                "Resume languages are listed successfully!"
        );
    }

    @Override
    public DataResult<List<ResumeLanguage>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeLanguage>>(
                this.resumeLanguageDao.findAllByResumeId(resumeId),
                "Resume languages by resume id are listed successfully!");
    }

    @Override
    public DataResult<List<ResumeLanguageDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeLanguageDetailDto>>(
                ModelMapperUtils.toList(
                        this.getAllByResumeId(resumeId).getData(),
                        ResumeLanguageDetailDto.class));
    }

    @Override
    public Result add(ResumeLanguage resumeLanguage) {
        this.resumeLanguageDao.save(resumeLanguage);
        return new SuccessResult("Resume language added successfully!");
    }
}
