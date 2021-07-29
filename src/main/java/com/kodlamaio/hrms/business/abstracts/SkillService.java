package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillService {

    DataResult<List<Skill>> getAll();

    Result add(Skill skill);

    DataResult<Optional<Skill>> update(int id, Skill skill);

    Result delete(int id);
}
