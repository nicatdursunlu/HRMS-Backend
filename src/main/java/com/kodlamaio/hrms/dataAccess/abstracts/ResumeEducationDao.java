package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.ResumeEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeEducationDao extends JpaRepository<ResumeEducation, Integer> {
    DataResult<List<ResumeEducation>> findAllByResumeId(@Param("id") int id);
}
