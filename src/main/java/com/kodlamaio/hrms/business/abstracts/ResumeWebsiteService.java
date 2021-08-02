package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeWebsite;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeWebsiteDetailDto;

import java.util.List;

public interface ResumeWebsiteService {

    DataResult<List<ResumeWebsite>> getAll();

    DataResult<List<ResumeWebsite>> getAllByResumeId(int resumeId);

    DataResult<List<ResumeWebsiteDetailDto>> getAllDetailDtoByResumeId(int resumeId);

    Result add(ResumeWebsite resumeWebsite);
}
