package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();

    DataResult<User> findById(int id);

    DataResult<User> findByEmail(String email);

    Result create(User user);

    Result update(int id, User user);

    Result delete(int id);
}
