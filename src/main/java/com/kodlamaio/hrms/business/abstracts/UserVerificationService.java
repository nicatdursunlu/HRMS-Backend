package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.UserVerification;

public interface UserVerificationService {

    DataResult<UserVerification> generate(int userId);

    abstract DataResult<UserVerification> verificate(String code);
}
