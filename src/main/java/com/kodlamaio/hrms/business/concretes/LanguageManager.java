package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.LanguageService;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import com.kodlamaio.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public DataResult<Optional<Language>> update(int id, Language language) {
        Language oldLanguage = this.languageDao.findById(id).orElse(null);

        if (oldLanguage == null) {
            return new ErrorDataResult<>("Language is not found");
        }

        oldLanguage.setName(language.getName());
        this.languageDao.save(oldLanguage);

        return new SuccessDataResult<Optional<Language>>(
                this.languageDao.findById(id), "Language updated successfully!"
        );
    }

    @Override
    public Result delete(int id) {
        this.languageDao.deleteById(id);
        return new SuccessResult("Language deleted successfully!");
    }
}
