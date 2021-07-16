package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.ResumeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeSkillDao extends JpaRepository<ResumeSkill, Integer> {
    List<ResumeSkill> findAllByResumeId(@Param("resumeId") int resumeId);
}
