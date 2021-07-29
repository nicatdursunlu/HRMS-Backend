package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.SkillService;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import com.kodlamaio.hrms.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillManager implements SkillService {

    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(
                this.skillDao.findAll(),
                "Skills are listed successfully!"
        );
    }

    @Override
    public Result add(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult("Skills added successfully!");
    }

    @Override
    public DataResult<Optional<Skill>> update(int id, Skill skill) {
        Skill oldSkill = this.skillDao.findById(id).orElse(null);

        if(oldSkill == null) {
            return new ErrorDataResult<>("Skill is not found");
        }

        oldSkill.setName(skill.getName());
        this.skillDao.save(oldSkill);

        return new SuccessDataResult<Optional<Skill>>(
                this.skillDao.findById(id), "Skills updated successfully!"
        );
    }

    @Override
    public Result delete(int id) {
        this.skillDao.deleteById(id);
        return new SuccessResult("Skills deleted successfully!");
    }
}
