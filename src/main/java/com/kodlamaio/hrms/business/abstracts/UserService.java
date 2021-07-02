package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.entities.concretes.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User create(@RequestBody User user);
}
