package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Resume;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeDetailDto;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeSummaryDto;

import java.util.List;

public interface ResumeService {
    DataResult<List<ResumeSummaryDto>> getAllSummaryDto();

    DataResult<List<ResumeDetailDto>> getDetailDtoById(int id);

    DataResult<Resume> getById(int id);

    Result add(Resume resume);
}
