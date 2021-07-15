package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeEducation;
import com.kodlamaio.hrms.entities.concretes.ResumeExperience;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeExperienceDetailDto;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeLanguageDetailDto;

import java.util.List;

public interface ResumeExperienceService {

    DataResult<List<ResumeExperience>> getAll();

    DataResult<List<ResumeExperience>> getAllByResumeId(int id);

    DataResult<List<ResumeExperienceDetailDto>> getAllDetailDtoByResumeId(int resumeId);

    Result add(ResumeExperience resumeExperience);

}
