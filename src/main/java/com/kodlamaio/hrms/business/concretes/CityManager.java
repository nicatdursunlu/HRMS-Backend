package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.CityService;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.CityDao;
import com.kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
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
    public DataResult<List<City>> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return new SuccessDataResult<List<City>>
                (this.cityDao.findAll(pageable).getContent(),
                        "Cities are listed successfully!");
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
                        "Cities of state " + stateId + " are listed successfully");
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

    @Override
    public DataResult<Optional<City>> update(int id, City city) {
        City oldCity = this.cityDao.findById(id).orElse(null);

        if (oldCity == null) {
            return new ErrorDataResult<>("City is not found");
        }

        oldCity.setStateId(city.getStateId());
        oldCity.setName(city.getName());

        this.cityDao.save(oldCity);

        return new SuccessDataResult<Optional<City>>(
                this.cityDao.findById(id), "City updated successfully!"
        );
    }

    @Override
    public Result delete(int id) {
        this.cityDao.deleteById(id);
        return new SuccessResult("City deleted successfully!");
    }
}
