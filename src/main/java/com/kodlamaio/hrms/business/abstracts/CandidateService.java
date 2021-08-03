package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Candidate;
import com.kodlamaio.hrms.entities.dtos.CandidateDto;

import java.util.List;
import java.util.Optional;

public interface CandidateService {

    DataResult<List<Candidate>> getAll();

    DataResult<Candidate> getCandidateDtoById(int id);

    Result add(Candidate candidate);

    DataResult<Optional<Candidate>> update(int id, Candidate candidate);

    Result delete(int id);
}
