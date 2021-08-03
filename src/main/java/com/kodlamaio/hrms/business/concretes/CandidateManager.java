package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.CandidateService;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import com.kodlamaio.hrms.entities.concretes.Candidate;
import com.kodlamaio.hrms.entities.dtos.CandidateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;

    public CandidateManager(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>
                (this.candidateDao.findAll(), "Candidates are listed successfully");
    }

    @Override
    public DataResult<Candidate> getCandidateDtoById(int id) {
        Candidate candidate = this.candidateDao.findById(id).orElse(null);

        if (candidate == null) {
            return new ErrorDataResult<>("Candidate is not found");
        }

        return new SuccessDataResult<Candidate>(
                candidate, "Candidate found by id successfully"
        );
    }

    @Override
    public Result add(Candidate candidate) {
        this.candidateDao.save(candidate);
        return new SuccessResult("Candidate added successfully");
    }

    @Override
    public DataResult<Optional<Candidate>> update(int id, Candidate candidate) {
        Candidate oldCandidate = this.candidateDao.findById(id).orElse(null);

        if(oldCandidate == null) {
            return new ErrorDataResult<>("Candidate is not found");
        }

        oldCandidate.setFirstName(candidate.getFirstName());
        oldCandidate.setLastName(candidate.getLastName());
        oldCandidate.setEmail(candidate.getEmail());
        oldCandidate.setPhone(candidate.getPhone());
        oldCandidate.setBirthDate(candidate.getBirthDate());
        oldCandidate.setIdentityNumber(candidate.getIdentityNumber());
        oldCandidate.setPassword(candidate.getPassword());

        this.candidateDao.save(oldCandidate);

        return new SuccessDataResult<Optional<Candidate>>(
                this.candidateDao.findById(id), "Candidate updated successfully!"
        );
    }

    @Override
    public Result delete(int id) {
        this.candidateDao.deleteById(id);
        return new SuccessResult("Candidate deleted successfully!");
    }
}
