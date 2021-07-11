package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.WebsiteType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsiteTypeDao extends JpaRepository<WebsiteType, Integer> {

}
