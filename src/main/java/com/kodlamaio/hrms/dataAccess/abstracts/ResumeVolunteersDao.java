package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.ResumeVolunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeVolunteersDao extends JpaRepository<ResumeVolunteer, Integer> {
    List<ResumeVolunteer> findAllByResumeId(@Param("id") int id);
}
