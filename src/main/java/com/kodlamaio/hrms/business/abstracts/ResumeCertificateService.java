package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ResumeCertificate;

import java.util.List;
import java.util.Optional;

public interface ResumeCertificateService {

    DataResult<List<ResumeCertificate>> getAll();

    DataResult<List<ResumeCertificate>> getAllByResumeId(int resumeId);

    DataResult<ResumeCertificate> add(ResumeCertificate resumeCertificate);

    DataResult<Optional<ResumeCertificate>> update(int id, ResumeCertificate resumeCertificate);

    Result delete(int id);
}
