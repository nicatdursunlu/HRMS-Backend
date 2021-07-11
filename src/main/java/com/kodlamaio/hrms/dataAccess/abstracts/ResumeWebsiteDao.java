package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.ResumeWebsite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeWebsiteDao extends JpaRepository<ResumeWebsite, Integer> {
    DataResult<List<ResumeWebsite>> findAllByResumeId(@Param("id") int id);
}
