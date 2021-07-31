package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.ResumeReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeReferenceDao extends JpaRepository<ResumeReference, Integer> {
    List<ResumeReference> findAllByResumeId(@Param("id") int id);
}
