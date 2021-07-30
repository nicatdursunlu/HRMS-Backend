package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.ResumeCertificateService;
import com.kodlamaio.hrms.core.utilities.business.CheckEngine;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeCertificateDao;
import com.kodlamaio.hrms.entities.concretes.ResumeCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeCertificateManager implements ResumeCertificateService {

    private ResumeCertificateDao resumeCertificateDao;

    @Autowired
    public ResumeCertificateManager(ResumeCertificateDao resumeCertificateDao) {
        this.resumeCertificateDao = resumeCertificateDao;
    }

    @Override
    public DataResult<List<ResumeCertificate>> getAll() {
        return new SuccessDataResult<List<ResumeCertificate>>(
                this.resumeCertificateDao.findAll(), "Resume Certificates are listed successfully!"
        );
    }

    @Override
    public DataResult<List<ResumeCertificate>> getAllByResumeId(int resumeId) {
        List<ResumeCertificate> certificates = this.resumeCertificateDao.findAllByResumeId(resumeId);
        return new SuccessDataResult<List<ResumeCertificate>>(
                certificates, "Resume Certificates by resume ID are listed successfully!"
        );
    }

    @Override
    public DataResult<ResumeCertificate> add(ResumeCertificate resumeCertificate) {
        Result result = CheckEngine.run(checkIfIsContinueThenEndDateNotNull(resumeCertificate));

        if (!result.isSuccess()) {
            return new ErrorDataResult<ResumeCertificate>(resumeCertificate, result.getMessage());
        }

        this.resumeCertificateDao.save(resumeCertificate);
        return new SuccessDataResult<ResumeCertificate>(
                resumeCertificate, "Resume Certificate added successfully!");
    }

    private Result checkIfIsContinueThenEndDateNotNull(ResumeCertificate resumeCertificate) {
        if(resumeCertificate.isLimitless() && resumeCertificate.getEndDate() != null) {
            return new ErrorResult("If is continue then end date can not be null");
        }
        return new SuccessResult();
    }

    @Override
    public DataResult<Optional<ResumeCertificate>> update(int id, ResumeCertificate resumeCertificate) {
        ResumeCertificate oldResumeCertificate = this.resumeCertificateDao.findById(id).orElse(null);

        if (oldResumeCertificate == null) {
            return new ErrorDataResult<>("Resume Certificate is not found");
        }

        oldResumeCertificate.setTitle(resumeCertificate.getTitle());
        oldResumeCertificate.setDescription(resumeCertificate.getDescription());
        oldResumeCertificate.setOrganization(resumeCertificate.getOrganization());
        oldResumeCertificate.setDegree(resumeCertificate.getDegree());
        oldResumeCertificate.setResumeId(resumeCertificate.getResumeId());
        oldResumeCertificate.setOrganization(resumeCertificate.getOrganization());
        oldResumeCertificate.setCertificateNumber(resumeCertificate.getCertificateNumber());
        oldResumeCertificate.setGivenDate(resumeCertificate.getGivenDate());
        oldResumeCertificate.setEndDate(resumeCertificate.getEndDate());

        this.resumeCertificateDao.save(oldResumeCertificate);

        return new SuccessDataResult<Optional<ResumeCertificate>>(
                this.resumeCertificateDao.findById(id), "Resume Certificate updated successfully!"
        );
    }

    @Override
    public Result delete(int id) {
        this.resumeCertificateDao.deleteById(id);
        return new SuccessResult("Resume Certificate deleted successfully!");
    }
}
