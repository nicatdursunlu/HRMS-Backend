package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.ResumeCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeCertificateDao extends JpaRepository<ResumeCertificate, Integer> {
    List<ResumeCertificate> findAllByResumeId(@Param("id") int id);
}
