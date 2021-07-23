package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.VerificationCodeService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.UserVerificationDao;
import com.kodlamaio.hrms.entities.concretes.UserVerification;
import org.springframework.beans.factory.annotation.Autowired;

public class VerificationCodeManager implements VerificationCodeService {
    private UserVerificationDao userVerificationDao;

    @Autowired
    public VerificationCodeManager(UserVerificationDao userVerificationDao) {
        this.userVerificationDao = userVerificationDao;
    }

    @Override
    public Result add(UserVerification code) {
        this.userVerificationDao.save(code);
        return new SuccessResult("Code has been saved successfully!");
    }
}
