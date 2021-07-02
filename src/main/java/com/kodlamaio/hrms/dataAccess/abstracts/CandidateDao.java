package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    boolean existsByIdentityNumberAndId(@Param("identityNumber") String identityNumber, @Param("id") int id);
}
