package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.ResumeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeProjectDao extends JpaRepository<ResumeProject, Integer> {
    List<ResumeProject> findAllByResumeId(@Param("id") int id);
}
