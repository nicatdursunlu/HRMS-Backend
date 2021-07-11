package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.ResumeExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeExperienceDao extends JpaRepository<ResumeExperience, Integer> {
    DataResult<List<ResumeExperience>> findAllByResumeId(@Param("id") int id);
}
