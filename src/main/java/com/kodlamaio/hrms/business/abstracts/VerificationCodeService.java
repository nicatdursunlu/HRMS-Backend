package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.UserVerification;

public interface VerificationCodeService {
    Result add(UserVerification code);
}
