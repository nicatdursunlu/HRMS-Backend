package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.ResumeQualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeQualificationDao extends JpaRepository<ResumeQualification, Integer> {
    DataResult<List<ResumeQualification>> findAllByResumeId(@Param("id") int id);
}
