package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeReference;

import java.util.List;
import java.util.Optional;

public interface ResumeReferenceService {
    DataResult<List<ResumeReference>> getAll();

    DataResult<List<ResumeReference>> getAllByResumeId(int resumeId);

    DataResult<ResumeReference> add(ResumeReference resumeReference);

    DataResult<Optional<ResumeReference>> update(int id, ResumeReference resumeReference);

    Result delete(int id);
}
