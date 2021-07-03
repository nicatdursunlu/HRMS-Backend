package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.LanguageService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import com.kodlamaio.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>
                (this.languageDao.findAll(), "Languages are listed successfully");
    }

    @Override
    public DataResult<List<Language>> getAllByName(String name) {
        return new SuccessDataResult<List<Language>>(
                this.languageDao.findFirst10ByNameContainingIgnoreCase(name),
                "Languages are listed successfully");
    }

    @Override
    public Result add(Language language) {
        this.languageDao.save(language);
        return new SuccessResult("Language added successfully");
    }
}
