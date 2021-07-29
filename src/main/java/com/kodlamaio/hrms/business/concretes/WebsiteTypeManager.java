package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.WebsiteTypeService;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.WebsiteTypeDao;
import com.kodlamaio.hrms.entities.concretes.WebsiteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public DataResult<Optional<WebsiteType>> update(int id, WebsiteType websiteType) {
        WebsiteType oldWebsiteType = this.websiteTypeDao.findById(id).orElse(null);

        if(oldWebsiteType == null) {
            return new ErrorDataResult<>("Website Type is not found");
        }

        oldWebsiteType.setName(websiteType.getName());
        this.websiteTypeDao.save(oldWebsiteType);

        return new SuccessDataResult<Optional<WebsiteType>>(
                this.websiteTypeDao.findById(id), "Website Type updated successfully!"
        );
    }

    @Override
    public Result delete(int id) {
        this.websiteTypeDao.deleteById(id);
        return new SuccessResult("Website Type deleted successfully!");
    }
}
