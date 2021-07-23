package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employee;
import com.kodlamaio.hrms.entities.concretes.Employer;

public interface AuthService {
    Result employerRegister(Employer employer, String confirmPassword);
    Result employeeRegister(Employee employee, String confirmPassword);
}
