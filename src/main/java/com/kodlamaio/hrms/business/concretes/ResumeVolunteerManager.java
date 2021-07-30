package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.ResumeVolunteerService;
import com.kodlamaio.hrms.core.utilities.business.CheckEngine;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeVolunteersDao;
import com.kodlamaio.hrms.entities.concretes.ResumeVolunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeVolunteerManager implements ResumeVolunteerService {

    private ResumeVolunteersDao resumeVolunteersDao;

    @Autowired
    public ResumeVolunteerManager(ResumeVolunteersDao resumeVolunteersDao) {
        this.resumeVolunteersDao = resumeVolunteersDao;
    }

    @Override
    public DataResult<List<ResumeVolunteer>> getAll() {
        return new SuccessDataResult<List<ResumeVolunteer>>(
                this.resumeVolunteersDao.findAll(),
                "Resume Volunteers are listed successfully!"
        );
    }

    @Override
    public DataResult<List<ResumeVolunteer>> getAllByResumeId(int resumeId) {
        List<ResumeVolunteer> resumeVolunteers = this.resumeVolunteersDao.findAllByResumeId(resumeId);
        return new SuccessDataResult<List<ResumeVolunteer>>(
                resumeVolunteers, "Resume Volunteers by resume ID are listed successfully!"
        );
    }

    @Override
    public DataResult<ResumeVolunteer> add(ResumeVolunteer resumeVolunteer) {
        Result result = CheckEngine.run(checkIfIsContinueThenEndDateNotNull(resumeVolunteer));

        if(!result.isSuccess()) {
            return new ErrorDataResult<ResumeVolunteer>(resumeVolunteer, result.getMessage());
        }

        this.resumeVolunteersDao.save(resumeVolunteer);
        return new SuccessDataResult<ResumeVolunteer>(resumeVolunteer, "Resume Volunteers added successfully!");
    }

    private Result checkIfIsContinueThenEndDateNotNull(ResumeVolunteer resumeVolunteer) {
        if(resumeVolunteer.isContinued() && resumeVolunteer.getEndDate() != null) {
            return new ErrorResult("If is continue then end date can not be null");
        }
        return new SuccessResult();
    }

    @Override
    public DataResult<Optional<ResumeVolunteer>> update(int id, ResumeVolunteer resumeVolunteer) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }
}
