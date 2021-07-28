package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {

    DataResult<List<Language>> getAll();

    DataResult<List<Language>> getAllByName(String name);

    Result add(Language language);

    DataResult<Optional<Language>> update(int id, Language language);

    Result delete(int id);
}
