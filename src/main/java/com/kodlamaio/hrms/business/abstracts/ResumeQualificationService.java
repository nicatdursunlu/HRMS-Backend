package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeQualification;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeQualificationDetailDto;

import java.util.List;

public interface ResumeQualificationService {

    DataResult<List<ResumeQualification>> getAllByResumeId(int resumeId);

    DataResult<List<ResumeQualificationDetailDto>> getAllDetailDtoByResumeId(int resumeId);

    Result add(ResumeQualification resumeQualification);
}
