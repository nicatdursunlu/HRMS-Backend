package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.ResumeReferenceService;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeReferenceDao;
import com.kodlamaio.hrms.entities.concretes.ResumeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeReferenceManager implements ResumeReferenceService {

    private ResumeReferenceDao resumeReferenceDao;

    @Autowired
    public ResumeReferenceManager(ResumeReferenceDao resumeReferenceDao) {
        this.resumeReferenceDao = resumeReferenceDao;
    }

    @Override
    public DataResult<List<ResumeReference>> getAll() {
        return new SuccessDataResult<List<ResumeReference>>(
                this.resumeReferenceDao.findAll(), "Resume References are listed successfully!"
        );
    }

    @Override
    public DataResult<List<ResumeReference>> getAllByResumeId(int resumeId) {
        List<ResumeReference> resumeReferences = this.resumeReferenceDao.findAllByResumeId(resumeId);
        return new SuccessDataResult<List<ResumeReference>>(
                resumeReferences, "Resume References by resume ID are listed successfully!\""
        );
    }

    @Override
    public DataResult<ResumeReference> add(ResumeReference resumeReference) {
        this.resumeReferenceDao.save(resumeReference);
        return new SuccessDataResult<ResumeReference>(resumeReference, "Resume Reference added successfully!");
    }

    @Override
    public DataResult<Optional<ResumeReference>> update(int id, ResumeReference resumeReference) {
        ResumeReference oldResumeReference = this.resumeReferenceDao.findById(id).orElse(null);

        if(oldResumeReference == null) {
            return new ErrorDataResult<>("Resume Reference is not found");
        }

        oldResumeReference.setDescription(resumeReference.getDescription());
        oldResumeReference.setFirstName(resumeReference.getFirstName());
        oldResumeReference.setLastName(resumeReference.getLastName());
        oldResumeReference.setOrganization(resumeReference.getOrganization());
        oldResumeReference.setPosition(resumeReference.getPosition());
        oldResumeReference.setEmail(resumeReference.getEmail());
        oldResumeReference.setPhone(resumeReference.getPhone());
        oldResumeReference.setDescription(resumeReference.getDescription());
        oldResumeReference.setResumeId(resumeReference.getResumeId());

        this.resumeReferenceDao.save(oldResumeReference);

        return new SuccessDataResult<Optional<ResumeReference>>(
                this.resumeReferenceDao.findById(id), "Resume Reference updated successfully!"
        );
    }

    @Override
    public Result delete(int id) {
        this.resumeReferenceDao.deleteById(id);
        return new SuccessResult("Resume Reference deleted successfully!");
    }
}
