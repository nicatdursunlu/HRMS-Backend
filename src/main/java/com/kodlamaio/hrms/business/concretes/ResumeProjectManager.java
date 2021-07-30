package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.ResumeProjectService;
import com.kodlamaio.hrms.core.utilities.business.CheckEngine;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeProjectDao;
import com.kodlamaio.hrms.entities.concretes.ResumeProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeProjectManager implements ResumeProjectService {

    private ResumeProjectDao resumeProjectDao;

    @Autowired
    public ResumeProjectManager(ResumeProjectDao resumeProjectDao) {
        this.resumeProjectDao = resumeProjectDao;
    }

    @Override
    public DataResult<List<ResumeProject>> getAll(){
        return new SuccessDataResult<List<ResumeProject>>(
                this.resumeProjectDao.findAll(),
                "Resume Projects are listed successfully!"
        );
    }

    @Override
    public DataResult<List<ResumeProject>> getAllByResumeId(int id){
        List<ResumeProject> resumeProjects = this.resumeProjectDao.findAllByResumeId(id);
        return new SuccessDataResult<List<ResumeProject>>(
                resumeProjects, "Resume Projects by resume ID are listed successfully!"
        );
    }

    @Override
    public DataResult<ResumeProject> add(ResumeProject resumeProject){
        Result result = CheckEngine.run(checkIfIsContinueThenEndDateNotNull(resumeProject));

        if(!result.isSuccess()) {
            return new ErrorDataResult<ResumeProject>(resumeProject, result.getMessage());
        }

        this.resumeProjectDao.save(resumeProject);
        return new SuccessDataResult<ResumeProject>(resumeProject, "Resume Project added successfully!");
    }

    private Result checkIfIsContinueThenEndDateNotNull(ResumeProject resumeProject) {
        if(resumeProject.isContinued() && resumeProject.getEndDate() != null) {
            return new ErrorResult("If is continue then end date can not be null");
        }
        return new SuccessResult();
    }

    @Override
    public DataResult<Optional<ResumeProject>> update(int id, ResumeProject resumeProject){
        ResumeProject oldResumeProject = this.resumeProjectDao.findById(id).orElse(null);

        if (oldResumeProject == null) {
            return new ErrorDataResult<>("Resume Project is not found");
        }

        oldResumeProject.setTitle(resumeProject.getTitle());
        oldResumeProject.setDescription(resumeProject.getDescription());
        oldResumeProject.setStartDate(resumeProject.getStartDate());
        oldResumeProject.setEndDate(resumeProject.getEndDate());
        oldResumeProject.setResumeId(resumeProject.getResumeId());

        this.resumeProjectDao.save(oldResumeProject);

        return new SuccessDataResult<Optional<ResumeProject>>(
                this.resumeProjectDao.findById(id), "Resume Project updated successfully!"
        );
    }

    @Override
    public Result delete(int id){
        this.resumeProjectDao.deleteById(id);
        return new SuccessResult("Resume Project deleted successfully!");
    }
}
