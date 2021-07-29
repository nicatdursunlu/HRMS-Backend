package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.WebsiteType;

import java.util.List;
import java.util.Optional;

public interface WebsiteTypeService {

    DataResult<List<WebsiteType>> getAll();

    Result add(WebsiteType websiteType);

    DataResult<Optional<WebsiteType>> update(int id, WebsiteType websiteType);

    Result delete(int id);
}
