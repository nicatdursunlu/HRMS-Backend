package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();

    Result create(User user);
}
