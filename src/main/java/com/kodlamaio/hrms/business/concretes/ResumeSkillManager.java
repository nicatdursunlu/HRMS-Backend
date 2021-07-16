package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.ResumeSkillService;
import com.kodlamaio.hrms.core.utilities.mappers.ModelMapperUtils;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeSkillDao;
import com.kodlamaio.hrms.entities.concretes.ResumeSkill;
import com.kodlamaio.hrms.entities.dtos.resumes.ResumeSkillDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeSkillManager implements ResumeSkillService {

    private ResumeSkillDao resumeSkillDao;

    @Autowired
    public ResumeSkillManager(ResumeSkillDao resumeSkillDao) {
        this.resumeSkillDao = resumeSkillDao;
    }

    @Override
    public DataResult<List<ResumeSkill>> getAll() {
        return new SuccessDataResult<List<ResumeSkill>>(
                this.resumeSkillDao.findAll(),
                "Resume skills are listed successfully!"
        );
    }

    @Override
    public DataResult<List<ResumeSkill>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeSkill>>(
                this.resumeSkillDao.findAllByResumeId(resumeId),
                "Resume skills by resume id are listed successfully!"
        );
    }

    @Override
    public DataResult<List<ResumeSkillDetailDto>> getAllDetailDtoByResumeId(int resumeId) {
        return new SuccessDataResult<List<ResumeSkillDetailDto>>(
                ModelMapperUtils.toList(
                        this.getAllByResumeId(resumeId).getData(),
                        ResumeSkillDetailDto.class
                )
        );
    }

    @Override
    public Result add(ResumeSkill resumeSkill) {
        this.resumeSkillDao.save(resumeSkill);
        return new SuccessResult("Resume skill added successfully!");
    }
}
