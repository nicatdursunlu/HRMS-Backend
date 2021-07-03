package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LanguageDao extends JpaRepository<Language, Integer> {
    List<Language> findFirst10ByNameContainingIgnoreCase(@Param("name") String name);
}
