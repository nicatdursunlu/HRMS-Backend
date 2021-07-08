package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.UserVerificationService;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import com.kodlamaio.hrms.core.utilities.business.CheckEngine;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.UserVerificationDao;
import com.kodlamaio.hrms.entities.concretes.UserVerification;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class UserVerificationManager implements UserVerificationService {

    private UserVerificationDao userVerificationDao;

    @Autowired
    public UserVerificationManager(UserVerificationDao userVerificationDao) {
        this.userVerificationDao = userVerificationDao;
    }

    @Override
    public DataResult<UserVerification> generate(int userId) {
        UUID uuid = UUID.randomUUID();

        UserVerification userVerification = new UserVerification();
        userVerification.setUserId(userId);
        userVerification.setCode(uuid.toString());
        userVerification.setExpiryDate(Instant.now().plus(24, ChronoUnit.HOURS));
        this.userVerificationDao.save(userVerification);

        return new SuccessDataResult<UserVerification>(userVerification);
    }

    @Override
    public DataResult<UserVerification> verificate(String code) {
        int userId = this.userVerificationDao.findUserIdByCode(code);

        Result result = CheckEngine.run(
                this.checkIfCodeIsNotExists(code),
                this.checkIfUserIsAlreadyVerificated(userId)
        );

        if(!result.isSuccess()) {
            return new ErrorDataResult<UserVerification>(result.getMessage());
        }

        UserVerification userVerification = this.userVerificationDao.findByCode(code);
        userVerification.setVerificationDate(Instant.now());
        this.userVerificationDao.save(userVerification);

        return new SuccessDataResult<UserVerification>(userVerification);
    }

    private Result checkIfCodeIsNotExists(String code) {
        boolean result = this.userVerificationDao.existsByCode(code);

        if(!result) {
            return new ErrorResult(ValidationMessages.VERIFICATION_CODE_IS_NOT_EXISTS);
        }

        return new SuccessResult();
    }

    private Result checkIfUserIsAlreadyVerificated(int userId) {
        boolean result = this.userVerificationDao.userIsVerificated(userId);

        if(!result) {
            return new ErrorResult(ValidationMessages.USER_IS_ALREADY_VERIFICATED);
        }

        return new SuccessResult();
    }
}
