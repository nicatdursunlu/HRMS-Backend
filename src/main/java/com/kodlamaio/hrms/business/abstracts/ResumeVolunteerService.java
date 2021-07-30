package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeVolunteer;

import java.util.List;
import java.util.Optional;

public interface ResumeVolunteerService {

    DataResult<List<ResumeVolunteer>> getAll();

    DataResult<List<ResumeVolunteer>> getAllByResumeId(int resumeId);

    DataResult<ResumeVolunteer> add(ResumeVolunteer resumeVolunteer);

    DataResult<Optional<ResumeVolunteer>> update(int id, ResumeVolunteer resumeVolunteer);

    Result delete(int id);
}
