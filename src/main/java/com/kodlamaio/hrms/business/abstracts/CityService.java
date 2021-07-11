package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.entities.concretes.City;

import java.util.List;
import java.util.Optional;

public interface CityService {

    public DataResult<List<City>> getAll();

    public DataResult<List<City>> getAllByName(String name);

    public DataResult<List<City>> getByStateId(int stateId);

    public DataResult<Optional<City>> getById(int id);

    public Result add(City city);
}
