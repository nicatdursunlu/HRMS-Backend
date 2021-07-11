package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.CityService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CityDao;
import com.kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>
                (this.cityDao.findAll(), "Cities are listed successfully!");
    }

    @Override
    public DataResult<List<City>> getAllByName(String name) {
        return new SuccessDataResult<List<City>>
                (this.cityDao.findFirst10ByNameContainingIgnoreCase(name),
                        "Cities are listed successfully");
    }

    @Override
    public DataResult<List<City>> getByStateId(int stateId) {
        return new SuccessDataResult<List<City>>
                (this.cityDao.getByStateId(stateId),
                        "Cities of state" + stateId + " are listed successfully");
    }

    @Override
    public DataResult<Optional<City>> getById(int id) {
        return new SuccessDataResult<Optional<City>>
                (this.cityDao.findById(id), "City is found successfully!");
    }

    @Override
    public Result add(City city) {
        this.cityDao.save(city);
        return new SuccessResult("City added successfully!");
    }
}
