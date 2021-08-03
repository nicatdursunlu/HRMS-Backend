package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.Candidate;
import com.kodlamaio.hrms.entities.dtos.CandidateDto;
import com.kodlamaio.hrms.entities.dtos.JobSummaryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

    boolean existsByIdentityNumberAndId(
            @Param("identityNumber") String identityNumber, @Param("id") int id);

    @Query(Query_CandidateDtoById)
    Optional<CandidateDto> getCandidateDtoById(@Param("id") int id);

    String Query_CandidateDto = "SELECT new com.kodlamaio.hrms.entities.dtos.CandidateDto "
            + 	"(c.id as id, "
            + 	"c.email as email, "
            + 	"c.phone as phone, "
            +   "c.firstName as firstName, "
            +   "c.lastName as lastName, "
            +   "c.identityNumber as identityNumber, "
//            +   "c.birthDate as birthDate, "
            +   "c.gender as gender, "

            + 	"c.linkedin as linkedin, "
            + 	"c.github as github, "
            + 	"c.website as website, "
            +   "c.about as about, "
            +   "c.hobby as hobby)"

            + 	"FROM Candidate c ";

    String Query_CandidateDtoById = Query_CandidateDto
            + "WHERE c.id = :id";

}
