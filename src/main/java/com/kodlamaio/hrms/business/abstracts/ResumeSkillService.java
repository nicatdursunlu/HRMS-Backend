package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeSkill;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeSkillDetailDto;

import java.util.List;

public interface ResumeSkillService {

    DataResult<List<ResumeSkill>> getAll();

    DataResult<List<ResumeSkill>> getAllByResumeId(int resumeId);

    DataResult<List<ResumeSkillDetailDto>> getAllDetailDtoByResumeId(int resumeId);

    Result add(ResumeSkill resumeSkill);
}
