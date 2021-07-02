package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.UserService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.UserDao;
import com.kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>
                (this.userDao.findAll(), "Users are listed successfully");
    }

    @Override
    public DataResult<User> findById(@PathVariable("id") int id) {
        return new SuccessDataResult<User>
                (this.userDao.findById(id), "User is found");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>
                (this.userDao.findByEmail(email), "User is found");
    }


    @Override
    public Result create(User user) {
        this.userDao.save(user);
        return new SuccessResult("User added successfully");
    }

    @Override
    public Result delete(int id) {
        this.userDao.deleteById(id);
        return new SuccessResult("User deleted successfully");
    }
}
