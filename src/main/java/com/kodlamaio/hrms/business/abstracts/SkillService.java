package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Skill;

import java.util.List;

public interface SkillService {

    DataResult<List<Skill>> getAll();

    Result add(Skill skill);
}
