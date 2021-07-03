package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {

    DataResult<List<Candidate>> getAll();

    Result add(Candidate candidate);
}
