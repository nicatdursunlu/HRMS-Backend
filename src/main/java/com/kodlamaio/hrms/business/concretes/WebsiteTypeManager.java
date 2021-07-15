package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.WebsiteTypeService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.WebsiteTypeDao;
import com.kodlamaio.hrms.entities.concretes.WebsiteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebsiteTypeManager implements WebsiteTypeService {

    private WebsiteTypeDao websiteTypeDao;

    @Autowired
    public WebsiteTypeManager(WebsiteTypeDao websiteTypeDao) {
        this.websiteTypeDao = websiteTypeDao;
    }

    @Override
    public DataResult<List<WebsiteType>> getAll() {
        return new SuccessDataResult<List<WebsiteType>>(
                this.websiteTypeDao.findAll(),
                "Website types are listed successfully!"
        );
    }

    @Override
    public Result add(WebsiteType websiteType) {
        this.websiteTypeDao.save(websiteType);
        return new SuccessResult("Website type added successfully");
    }
}
