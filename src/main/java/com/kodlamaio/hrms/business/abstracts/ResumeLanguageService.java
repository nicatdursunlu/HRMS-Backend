package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeLanguage;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeLanguageDetailDto;

import java.util.List;

public interface ResumeLanguageService {

    DataResult<List<ResumeLanguage>> getAll();

    DataResult<List<ResumeLanguage>> getAllByResumeId(int resumeId);

    DataResult<List<ResumeLanguageDetailDto>> getAllDetailDtoByResumeId(int resumeId);

    Result add(ResumeLanguage resumeLanguage);
}
