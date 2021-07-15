package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.ResumeLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeLanguageDao extends JpaRepository<ResumeLanguage, Integer> {
    List<ResumeLanguage> findAllByResumeId(@Param("resumeId") int resumeId);
}
