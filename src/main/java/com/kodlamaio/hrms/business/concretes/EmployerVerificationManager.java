package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.EmployerVerificationService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.dataAccess.abstracts.UserVerificationDao;
import com.kodlamaio.hrms.entities.concretes.UserVerification;
import org.springframework.stereotype.Service;

@Service
public class EmployerVerificationManager extends UserVerificationManager implements EmployerVerificationService {

    public EmployerVerificationManager(UserVerificationDao userVerificationDao) {
        super(userVerificationDao);
    }

    @Override
    public DataResult<UserVerification> generate(int userId) {
        return super.generate(userId);
    }

    @Override
    public DataResult<UserVerification> verificate(String code) {
        return super.verificate(code);
    }
}
