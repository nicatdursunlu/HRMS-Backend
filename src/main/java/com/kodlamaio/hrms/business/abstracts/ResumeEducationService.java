package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeEducation;

import java.util.List;

public interface ResumeEducationService {

    DataResult<List<ResumeEducation>> getAllByResumeId(int resumeId);

    Result add(ResumeEducation resumeEducation);
}
