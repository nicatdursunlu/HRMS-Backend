package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeProject;

import java.util.List;
import java.util.Optional;

public interface ResumeProjectService {

    DataResult<List<ResumeProject>> getAll();

    DataResult<List<ResumeProject>> getAllByResumeId(int resumeId);

    DataResult<ResumeProject> add(ResumeProject resumeProject);

    DataResult<Optional<ResumeProject>> update(int id, ResumeProject resumeProject);

    Result delete(int id);
}
