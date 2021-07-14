package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.WebsiteType;

import java.util.List;

public interface WebsiteTypeService {

    DataResult<List<WebsiteType>> getAll();

    Result add(WebsiteType websiteType);
}
