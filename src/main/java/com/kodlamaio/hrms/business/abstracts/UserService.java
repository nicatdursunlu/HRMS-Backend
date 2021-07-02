package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();

    DataResult<User> findById(int id);

    DataResult<User> findByEmail(String email);

    Result create(User user);

    Result delete(int id);
}
