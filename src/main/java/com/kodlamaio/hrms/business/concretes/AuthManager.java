package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.*;
import com.kodlamaio.hrms.core.mailSender.MailSenderService;
import com.kodlamaio.hrms.core.utilities.adapters.mernis.MernisService;
import com.kodlamaio.hrms.core.utilities.business.CheckEngine;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.core.utilities.verification.VerificationService;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.entities.concretes.Employee;
import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.concretes.UserVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthManager implements AuthService {

    private UserService userService;
    private EmployeeService employeeService;
    private EmployerService employerService;
    private VerificationService verificationService;
    private MernisService mernisService;
    private VerificationCodeService verificationCodeService;
    private MailSenderService mailSenderService;
    private EmployerDao employerDao;

    @Autowired
    public AuthManager(
            UserService userService, EmployeeService employeeService,
            EmployerService employerService, VerificationService verificationService,
            MernisService mernisService, VerificationCodeService verificationCodeService,
            MailSenderService mailSenderService, EmployerDao employerDao) {
        this.userService = userService;
        this.employeeService = employeeService;
        this.employerService = employerService;
        this.verificationService = verificationService;
        this.mernisService = mernisService;
        this.verificationCodeService = verificationCodeService;
        this.mailSenderService = mailSenderService;
        this.employerDao = employerDao;
    }

    @Override
    public Result employerRegister(Employer employer, String confirmPassword) {
        Result result = CheckEngine.run(
                checkIfNullInfoForEmployer(employer),
                checkIfEmailExists(employer.getEmail()),
                checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword));

        if(result.isSuccess()) {
            employerService.add(employer);
            String code = verificationService.sendCode();
            verificationCodeRecord(code, employer.getId(), employer.getEmail());

            return new SuccessResult("Registration has been successfully completed");
        }

        return result;
    }

    @Override
    public Result employeeRegister(Employee employee, String confirmPassword) {
        return null;
    }

    private Result checkIfNullInfoForEmployer(Employer employer) {
        if(employer.getCompanyName() != null && employer.getWebsite() != null && employer.getEmail() != null
                && employer.getPhone() != null && employer.getPassword() != null) {
            return new SuccessResult("Success");
        }

        return new ErrorResult("The fields cannot be empty");
    }

    private Result checkIfEqualEmailAndDomain(String email, String website) {
        String[] emailArray = email.split("@", 2);
        String domain = website.substring(4, website.length());

        if(emailArray[1].equals(domain)) {
            return new SuccessResult("Success");
        }

        return new ErrorResult("Email must be the same with the domain");
    }

    private Result checkIfEmailExists(String email) {
        if(this.userService.findByEmail(email).getData() == null) {
            return new SuccessResult("Success");
        }

        return new ErrorResult("This email has account");
    }

    private Result checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {
        if(!password.equals(confirmPassword)) {
            return new ErrorResult("Passwords must match");
        }

        return new SuccessResult("Success!");
    }

    private void verificationCodeRecord(String code, int id, String email) {

        UserVerification userVerification = new UserVerification(id, code);
        this.verificationCodeService.add(userVerification);
        System.out.println("Verification code has been sent to " + email);

    }
}
